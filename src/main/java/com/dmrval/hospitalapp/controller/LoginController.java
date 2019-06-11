package com.dmrval.hospitalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping(value = {"","/login"})
    public String getLoginPage(ModelMap model, HttpServletRequest request) {
        if(request.getParameterMap().containsKey("error")) {
            model.addAttribute("error",true);
        }
        if(request.getParameterMap().containsKey("logout")) {
            model.addAttribute("logout",true);
        }
        return "login";
    }


    @GetMapping("/accessDenied")
    public String getAccecDeniedPage() {
        return "accessDenied";
    }

    @GetMapping("/singUp")
    public String getsignUpPage() {
        return "singUp";
    }


}
