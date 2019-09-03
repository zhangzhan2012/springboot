package com.springboot.geodesy.dao;

import com.springboot.geodesy.entity.Bank;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankMapper {
    public List<Bank> getBankList();
}
