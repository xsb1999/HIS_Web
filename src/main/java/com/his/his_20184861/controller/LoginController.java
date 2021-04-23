package com.his.his_20184861.controller;

import com.his.his_20184861.pojo.po.User;
import com.his.his_20184861.service.user.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserLoginService userLoginService;

    @RequestMapping("/user/login")
    public String VerifyLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session, Model model)
    {

        User user = userLoginService.VerifyLogin(username,password);
        System.out.println(user);
        if (user==null){
            model.addAttribute("msg","用户名或密码错误！");
        }else {
            if (user.getUID().equals("ghy")){
                session.setAttribute("SessionUser", user);
                return "redirect:/dashboard.html";
            }
            if (user.getUserType().equals("1")){
                session.setAttribute("SessionUser", user);
                return "redirect:/Doctor.html";
            }
            if (user.getUID().equals("admin")){
                session.setAttribute("SessionUser", user);
                return "redirect:/YaoFang.html";
            }
        }
        return "index";
    }


}
