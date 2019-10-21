package com.imooc.studyluckymoney.service;

import com.imooc.studyluckymoney.domain.Luckymoney;
import com.imooc.studyluckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 事务 指的是 数据库的事务，也就是数据库表需要支持事务
     */
    @Transactional
    public void createTwo(){
        Luckymoney luckymoneyOne = new Luckymoney();
        luckymoneyOne.setConsumer("有钱人");
        luckymoneyOne.setMoney(new BigDecimal("520"));
        repository.save(luckymoneyOne);
        Luckymoney luckymoneyTwo = new Luckymoney();
        luckymoneyTwo.setConsumer("有钱淫");
        luckymoneyTwo.setMoney(new BigDecimal("1314"));
        repository.save(luckymoneyTwo);
    }
}
