package com.springboot.geodesy.service;

import com.springboot.geodesy.dao.CompanyMapper;
import com.springboot.geodesy.dao.DistanceMapper;
import com.springboot.geodesy.entity.Company;
import com.springboot.geodesy.entity.Distance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceService {

    @Autowired
    private DistanceMapper distanceMapper;

    public long  saveDistance(Distance distance){
        return distanceMapper.saveDistanceList(distance);
    }

    public long delDisctanceInfo(String dataDt){
        long total = distanceMapper.delDistanceInfo(dataDt);
        return total;
    }


}
