package com.leakeyash.bootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "hello")
@RequestMapping("/hello")
@RestController
public class HelloController {
    @GetMapping("/getHello")
    @ApiOperation("获取hello")
    public String getHello(){
        return "Hello, Swagger";
    }
}
