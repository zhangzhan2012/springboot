package com.springboot.geodesy.dao;

import com.springboot.geodesy.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyMapper {
    public List<Company> getCompanyList();
}
