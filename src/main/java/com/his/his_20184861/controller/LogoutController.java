package com.his.his_20184861.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("SessionUser");
        return "redirect:/index.html";
    }

}

