package com.imooc.studyluckymoney.controller;

import com.imooc.studyluckymoney.Utils.ResultUtils;
import com.imooc.studyluckymoney.domain.Girl;
import com.imooc.studyluckymoney.domain.Result;
import com.imooc.studyluckymoney.repository.GirlRepository;
import com.imooc.studyluckymoney.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取女孩列表
     */
    @GetMapping("/girls")
    public List<Girl> lists(){
        logger.info("come in girls!");
        return girlRepository.findAll();
    }

    /**
     * 新增一个女孩
     */
    @PostMapping("/addGirls")
    public Object addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(girlRepository.save(girl));
    }
    /**
     * 查询一个女孩
     */
    @GetMapping("/girls/{id}")
    public Girl lists(@PathVariable("id") Integer id){
        girlRepository.findById(id);
        return girlRepository.findById(id).orElse(null);
    }
    /**
     * 更新一个女孩
     */
    @PostMapping("updateGirl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("name") String name,
                           @RequestParam("cup_size") String cup_size){
        //先查询再更新
        Optional<Girl> optionalGirl = girlRepository.findById(id);
        //判断是否有数据，未查询到数据则返回null
        if(optionalGirl.isPresent()){
            Girl girl = optionalGirl.get();
            girl.setId(id);
            girl.setAge(age);
            girl.setCup_size(cup_size);
            girl.setName(name);
            return girlRepository.save(girl);
        }
        return null;
    }

    /**
     * 通过id获取年龄进行业务处理
     */
    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
