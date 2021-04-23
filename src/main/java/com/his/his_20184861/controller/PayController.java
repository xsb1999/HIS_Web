package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.PayMapper;
import com.his.his_20184861.pojo.po.Patient;
import com.his.his_20184861.pojo.vo.PayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PayController {

    @Autowired
    PayMapper payMapper;

    @RequestMapping("/shoufei")
    public String getPayInfo(@RequestParam("pay_MedRID") String pay_MedRID, Model model){

        Patient patient = payMapper.getPatient(pay_MedRID);
        List<PayInfo> payInfoList = payMapper.getPayInfo(pay_MedRID);

        if (payInfoList == null || patient == null){
            return "redirect:/pay.html";
        }
        else {
            model.addAttribute("p_name", patient.getNAME());
            model.addAttribute("p_id", patient.getIdentification());
            model.addAttribute("p_medrid", pay_MedRID);
            model.addAttribute("payInfo", payInfoList);

        }

        return "pay";
    }



}
