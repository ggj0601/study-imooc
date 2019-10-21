package com.imooc.studyluckymoney.controller;

import com.imooc.studyluckymoney.properties.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Controller + @ResponseBody=@RestController
 */

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/paramTest2")
    public String paramTest2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, @RequestParam("name") String name){
        return "获取请求参数中的id:" + id + ",\nname="+name;
    }

    @GetMapping("/paramTest/{id}")
    public String paramTest(@PathVariable("id") Integer id){
        return "获取URL中的参数id:" + id;
    }

    @PostMapping("/post-value")
    public String postTest(){
        return "只允许POST请求!";
    }

    @GetMapping({"/valueTest", "vT"})
    public String valueTest(){
        return "说明:" + limitConfig.getDescription();
    }

    @GetMapping("/hello")
    public String testSay(){
        return "spring boot 学习之路!";
    }
}
