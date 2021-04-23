package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.TuiHaoMapper;
import com.his.his_20184861.pojo.po.Patient;
import com.his.his_20184861.pojo.vo.TuiHaoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TuiHaoController {
    @Autowired
    TuiHaoMapper tuiHaoMapper;
    @RequestMapping("/tuihaoInfo")
    public String getTuiHaoInfo(@RequestParam("blh_TH") String blh, Model model){
        // 从挂号表中获取该病历号的信息
        List<TuiHaoInfo> tuiHaoInfos = tuiHaoMapper.getTuiHaoInfo(blh);
        // 通过病历号找到患者姓名和身份证号
        Patient patient = tuiHaoMapper.getPatient(blh);
        if (tuiHaoInfos == null || patient == null){
            return "redirect:/TuiHao.html";
        }
        else {
            for (int i = 0; i < tuiHaoInfos.size() ; i++) {
                if (tuiHaoInfos.get(i).getWatchState().equals("1")){
                    tuiHaoInfos.get(i).setWatchState("已看诊");
                }
                if (tuiHaoInfos.get(i).getWatchState().equals("2")){
                    tuiHaoInfos.get(i).setWatchState("未看诊");
                }
                if (tuiHaoInfos.get(i).getWatchState().equals("3")){
                    tuiHaoInfos.get(i).setWatchState("已退号");
                }
            }
            model.addAttribute("blh_t",blh);
            model.addAttribute("name_t",patient.getNAME());
            model.addAttribute("id_t",patient.getIdentification());
            model.addAttribute("tuihaoinfo",tuiHaoInfos);
        }
        return "TuiHao";
    }
    // 将挂号表中的看诊状态改为”已退号“
    @RequestMapping("/tuihaoUpdate")
    public String upDateTuiHao(@RequestParam("binglihao_t") String blh_t){
        tuiHaoMapper.UpdateTuiHaoState(blh_t);
        return "TuiHao";
    }
}
