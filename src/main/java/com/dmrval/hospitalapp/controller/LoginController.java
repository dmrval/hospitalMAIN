package com.dmrval.hospitalapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
