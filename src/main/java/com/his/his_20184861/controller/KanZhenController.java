package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.KanZhenMapper;
import com.his.his_20184861.pojo.po.Patient;
import com.his.his_20184861.pojo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;


import java.util.List;

@Controller
public class KanZhenController {

    @Autowired
    KanZhenMapper kanZhenMapper;

    @RequestMapping("/KanZhen")
    public String getAllWaitPatient(@SessionAttribute("SessionUser") User user, Model model){
        List<Patient> patientsWait = kanZhenMapper.getAllWaitPatient(user.getUName());
        List<Patient> patientsDone = kanZhenMapper.getAllDonePatient(user.getUName());
        model.addAttribute("waitPatients", patientsWait);
        model.addAttribute("donePatients", patientsDone);

        return "doctor_page";
    }



    @RequestMapping("/KanZhen1")
    public String submitinfo(Model model, @RequestParam("MedID") String MedID,
                                    @RequestParam("Statement") String Statement,
                                    @RequestParam("CurrentDiseaseHistory") String CurrentDiseaseHistory,
                                    @RequestParam("CurrentSituationOfDisease") String CurrentSituationOfDisease,
                                    @RequestParam("PastDiseaseHistory") String PastDiseaseHistory,
                                    @RequestParam("AlleryHistory") String AlleryHistory,
                                    @RequestParam("BodyCheck") String BodyCheck)

    {

        // 获取患者病历号
        MedID = MedID.substring(MedID.length() - 6);
        String RID = "100"+MedID;
        String warn = "无";
        String checkresult = "无";
        String diagnoseresult = "无";
        String advice = "无";
        String MedState = "2";
        String checkadvice = "无";

        // 写入病历表
        kanZhenMapper.submitInfo(RID,MedID,Statement,CurrentDiseaseHistory,CurrentSituationOfDisease,
                PastDiseaseHistory,AlleryHistory,BodyCheck,checkadvice,warn,checkresult,diagnoseresult,advice,MedState);


        return "redirect:/KanZhen";
    }


}
