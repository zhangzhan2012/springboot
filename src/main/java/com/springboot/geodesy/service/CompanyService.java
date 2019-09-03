package com.springboot.geodesy.service;

import com.springboot.geodesy.dao.CompanyMapper;
import com.springboot.geodesy.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyDao;

    public List<Company> getCompanyList(){
        List<Company> list = companyDao.getCompanyList();
        return list;
    }

}
