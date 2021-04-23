package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.FaYaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FaYaoUpdateController {
    @Autowired
    FaYaoMapper faYaoMapper;

    @RequestMapping("/fayao1")
    public String fyUpdate(@RequestParam("binglihao") String blh){

        faYaoMapper.changeMState(blh);
        return ("FaYao");
    }

}
