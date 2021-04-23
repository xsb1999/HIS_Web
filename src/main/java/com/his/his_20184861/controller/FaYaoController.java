package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.FaYaoMapper;
import com.his.his_20184861.pojo.vo.FaYaoInfo;
import com.his.his_20184861.pojo.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FaYaoController {

    @Autowired
    FaYaoMapper faYaoMapper;
    @RequestMapping("/fayao")
    public String getMedcine(@RequestParam("blh") String blh, Model model){
        // 通过病历号找到患者姓名和身份证号
        Patient patient = faYaoMapper.getPatient(blh);
        // 从患者处方明细表中获取已经交费的药品
        List<FaYaoInfo> faYaoInfoList = faYaoMapper.getMedicine(blh);
        if (faYaoInfoList == null || patient == null){
            return "redirect:/FaYao.html";
        }
        else{
            model.addAttribute("fyName",patient.getNAME());
            model.addAttribute("fyId",patient.getIdentification());
            model.addAttribute("fyBlh",blh);
            model.addAttribute("faYaoInfoList", faYaoInfoList);
        }
        return "FaYao";
    }

}
