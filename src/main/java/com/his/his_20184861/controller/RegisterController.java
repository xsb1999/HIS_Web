package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.RegisterMapper;
import com.his.his_20184861.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RegisterMapper registerMapper;

    @RequestMapping("/Reg")
    public String resgister(@RequestParam("username") String name, @RequestParam("BingLiHao") String blh,
                            @RequestParam("kanzhenDate") String kanzhendate, @RequestParam("DoctorName") String doctor,
                            @RequestParam("DepartmentName") String department, @RequestParam("ages") String age,
                            @RequestParam("identitys") String identitys,@RequestParam("gender") String gender,
                            @RequestParam("birthday") String birthday,@RequestParam("home") String home,
                            @RequestParam("noon") String noon, @RequestParam("level") String level,
                            @RequestParam("blb") String blb,
                            Model model){
        if (name == "" || age=="" || identitys=="" || kanzhendate.equals("")){
            model.addAttribute("reg","挂号失败！信息未填全！");
        }else {
            model.addAttribute("reg","挂号成功！");
            // 获取当前时间
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime =formatter.format(date);
            // 获取医生id和科室id
            String UID = userMapper.getDoctorId(doctor);
            String DID = userMapper.getDepartmentId(doctor);
            // 是否需要病历本
            if (blb.equals("要")){
                blb = "是";
            }else {
                blb = "否";
            }
            // 专家号还是普通号
            if (level.equals("专家号")){
                level = "1";
            }else {
                level = "2";
            }
            String RegistarID = "ghy";
            String watchState = "2";
            String RID = "100"+blh;
            String AgeType = "岁";
            int age1 = Integer.parseInt(age);
            // 写入数据库中的挂号表
            registerMapper.AddToPatient(blh,name,identitys,age1,gender);
            registerMapper.AddToRM(RID,blh);
            registerMapper.AddToRegisterTable(RID,blh,name,gender,identitys,birthday,age1,AgeType,home,kanzhendate,noon,
                    watchState,DID,UID,level,"1",blb,nowTime,RegistarID);
        }



        return "register";
    }

}
