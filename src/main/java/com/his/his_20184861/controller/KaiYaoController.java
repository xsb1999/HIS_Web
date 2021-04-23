package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.KaiYaoMapper;
import com.his.his_20184861.pojo.po.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class KaiYaoController {

    @Autowired
    KaiYaoMapper kaiYaoMapper;

    @RequestMapping("/KaiYao")
    public String KaiLi(@RequestParam("chufang_name") String chufang_name, @RequestParam("p_MedID") String p_MedID){

        // 从数据库中查找所开立的处方明细
        List<Prescription> submitPrescription = kaiYaoMapper.getSubmitPrescription(chufang_name);

        for (int i = 0; i<submitPrescription.size(); i++){
            String MedRID = p_MedID.substring(p_MedID.length() - 6);
            String PreID = submitPrescription.get(i).getPreID();
            String PreName = chufang_name;
            int PreAmount = submitPrescription.get(i).getAmount();
            String MID = submitPrescription.get(i).getMID();
            String YongFa = submitPrescription.get(i).getYongFa();
            String YongLiang = submitPrescription.get(i).getYongLiang();
            String PinCi = submitPrescription.get(i).getPinCi();
            int id = kaiYaoMapper.getID() + 1;
            String CreateDocID = "bianque";
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String CreateTime =formatter.format(date);
            String MState = "2";
            String PayState = "2";
            int MedAmount = 1;
            String RID = "100"+MedRID;
            // 将开立的处方明细写入患者处方明细表
            kaiYaoMapper.writeToPatientPrescriptionDetail(id, MedRID, PreID, RID, PreName, PreAmount,
                    CreateDocID, CreateTime, MID, YongFa, YongLiang, PinCi, MedAmount, MState, PayState);
        }
        return "redirect:/KanZhen";
    }



}
