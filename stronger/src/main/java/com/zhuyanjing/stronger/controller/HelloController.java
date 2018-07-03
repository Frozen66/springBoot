package com.zhuyanjing.stronger.controller;

import com.zhuyanjing.stronger.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController/*类要通过web方式访问要加一个这个注解*/
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;//没有创建这个bean,需要在目标中加入@Component注解

   /* @Value("${beauty}")*//*变量配置文件里边的额*//*
    private String beauty;*//*配置进来给她一个属性即可*//*

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/


//    @RequestMapping(value = "/say",method = RequestMethod.GET)//设置默认为0
    @GetMapping(value = "/say")
    public String say(@RequestParam(value="id",required = false,defaultValue = "0") Integer myId){
        return "id:"+myId;
        /*return "hello Spring Boot";*/
        /*return  beauty+age;*/
//      return girlProperties.getBeauty();/*在配置里边再使用配置！*/
//          return "index";
    }
}
