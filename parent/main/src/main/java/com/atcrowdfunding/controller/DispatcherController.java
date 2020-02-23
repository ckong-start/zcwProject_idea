package com.atcrowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @create 2020-02-03 0:17
 */
@Controller
public class DispatcherController {
    //根据请求转发首页
    @GetMapping(value={"/", "/index", "/default", "/index.html"})
    public String toIndexPage(){
        return "index";
    }

    //跳转到登录页面
    @GetMapping("/login.html")
    public String doLogin(){
        return "admin/login";
    }

}
