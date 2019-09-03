package com.springboot.geodesy.service;

import com.springboot.geodesy.dao.BankMapper;
import com.springboot.geodesy.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankService {
    @Autowired
    private BankMapper bankDao;

    public List<Bank> getBankList(){
        List<Bank> list = bankDao.getBankList();
        return list;
    }
}
