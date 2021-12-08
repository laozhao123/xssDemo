package com.example.xssdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class De1Controller {


    @GetMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("demo")
    public @ResponseBody
    ResponseDemo demo(String username, String password, HttpServletResponse response, ModelAndView mode){

        ResponseDemo responseDemo = new ResponseDemo();
        responseDemo.setPassword(password);
        responseDemo.setUsername(username);
        Cookie cookie=new Cookie("name","xxoo");
        response.addCookie(cookie);
        return responseDemo;
    }

    @GetMapping("xss")
    public @ResponseBody String xss(String cookie){
        System.out.println(cookie);
        return "ok";
    }
}
