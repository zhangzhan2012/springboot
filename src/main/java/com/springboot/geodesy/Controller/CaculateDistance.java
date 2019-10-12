package com.springboot.geodesy.Controller;

import com.springboot.geodesy.entity.Bank;
import com.springboot.geodesy.entity.Company;
import com.springboot.geodesy.entity.Distance;
import com.springboot.geodesy.service.BankService;
import com.springboot.geodesy.service.CompanyService;
import com.springboot.geodesy.service.DistanceService;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//@Controller
//@RequestMapping("/zyb")
@Component
public class CaculateDistance implements CommandLineRunner, Ordered {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private BankService bankService;
    @Autowired
    private DistanceService distanceService;

    @RequestMapping("/index")
    public String getInfo(){
        List<Company> companyList = new ArrayList<>();
        List<Bank> bankList = new ArrayList<>();
        long total = 0;
        long delTotal = 0;
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String dataDt = sf.format(date);
        List<Distance> distanceList = new ArrayList<>();
        long start = 0;
        Distance dis = new Distance();
                try{
                    companyList = companyService.getCompanyList();
                    bankList = bankService.getBankList();
                    delTotal = distanceService.delDisctanceInfo(dataDt);
                    if(bankList.size() == 0 || companyList.size() == 0){
                        return "";
                    }else{
                        total = companyList.size();
                        double distance = 0;
                        double m =0;
                        Company com = null;
                        Bank bank = null;
                        start = System.currentTimeMillis();
                        for(int i = 0;i < companyList.size();i++){
                            distance = Double.MAX_VALUE;
                            for (int j = 0; j< bankList.size();j++){
                                m = getDis(companyList.get(i).getCompLati(),companyList.get(i).getCompLong(),bankList.get(j).getBranLati(),bankList.get(j).getBranLong());
                                if(m < distance){
                                    distance = m;
                                    bank = bankList.get(j);
                                }
                            }
                            com = companyList.get(i);
                            dis.setDistance(String.valueOf(distance));
                            dis.setCompAddr(com.getCompAddr());
                            dis.setCompanyName(com.getCompanyName());
                            dis.setOrgName(bank.getOrgName());
                            dis.setDataDt(dataDt);
                            distanceService.saveDistance(dis);
                            if(i%100 == 0){
                                if(i != 0){
                                    System.out.println("插入"+i+"条数据！！！！！");
                                }
                            }
                    }
            }
            long end = System.currentTimeMillis();
            System.out.println("插入"+total+"条数据！！！！！");
            System.out.println("处理完成！！！！！！！！！");
            System.out.println("耗时："+(end - start)/1000+"秒");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public double getDis(String  comLa,String comLong,String branLa , String branLong){
            double meter = 0;
            GlobalCoordinates source = new GlobalCoordinates(Double.parseDouble(comLa.trim()), Double.parseDouble(comLong.trim()));
            GlobalCoordinates target = new GlobalCoordinates(Double.parseDouble(branLa.trim()), Double.parseDouble(branLong.trim()));
            meter = getDistanceMeter(source, target, Ellipsoid.WGS84);
        return meter;
    }

    public  double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid)
    {
        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);
        return geoCurve.getEllipsoidalDistance();
    }

//    项目启动自动执行该方法
    @Override
    public void run(String... args) throws Exception {
        getInfo();
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
