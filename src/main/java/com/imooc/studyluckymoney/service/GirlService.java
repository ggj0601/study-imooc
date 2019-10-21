package com.imooc.studyluckymoney.service;

import com.imooc.studyluckymoney.domain.Girl;
import com.imooc.studyluckymoney.enums.ResultEnums;
import com.imooc.studyluckymoney.exception.GirlException;
import com.imooc.studyluckymoney.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository repository;

    public void getAge(Integer id) throws Exception{
        Optional<Girl> girl = repository.findById(id);
        Integer age = girl.get().getAge();
        if(age >= 8 && age <13){
            //返回 你可能还在上小学 code = 001
//            String code = "001";
//            String msg = "你可能还在上小学";
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        }else if(age >= 13 && age < 18){
            //返回 你可能在上中学 code = 002
//            String code = "002";
//            String msg = "你可能在上中学";
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }else if(age >= 18 && age < 21){
            //返回 你可能已经在上高中 code = 003
//            String code = "003";
//            String msg = "你可能已经在上高中";
            throw new GirlException(ResultEnums.HIGNH_SCHOOL);
        }else {
            //返回 你应该已经在上大学了 code = 004
//            String code = "004";
//            String msg = "你应该已经在上大学了";
            throw new GirlException(ResultEnums.BIG_SCHOOL);
        }

    }
}
