package com.his.his_20184861.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/Register/page_1.html").setViewName("register");
        registry.addViewController("/TuiHao.html").setViewName("TuiHao");
        registry.addViewController("/Doctor.html").setViewName("Doctor");
        registry.addViewController("/doctor_page.html").setViewName("doctor_page");
        registry.addViewController("/pay.html").setViewName("pay");
        registry.addViewController("/invoice.html").setViewName("invoice");
        registry.addViewController("/YaoFang.html").setViewName("YaoFang");
        registry.addViewController("/FaYao.html").setViewName("FaYao");


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/dashboard.html",
                "/register.html", "/TuiHao.html","/Doctor.html", "/doctor_page.html","/pay.html",
                "/invoice.html","/YaoFang.html","/FaYao.html","/Register/page_1.html");
    }
}
