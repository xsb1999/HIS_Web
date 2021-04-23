package com.his.his_20184861.controller;

import com.his.his_20184861.mapper.PayMapper;
import com.his.his_20184861.pojo.po.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PayInvoiceController {

    @Autowired
    PayMapper payMapper;
    @RequestMapping("/jiaofei")
    public String changeState(@RequestParam("blh") String blh, @RequestParam("yp") String yp,
                              @RequestParam("fph")String fph, @RequestParam("cost1") float cost){
        List<String> medList = new ArrayList<>();
        String[] s = yp.split(",");
        for (int i = 0; i < s.length; i++) {
            medList.add(s[i]);
        }
        // 更新药品状态为“已交费”
        payMapper.changeState(blh, medList);
        // 写入发票表
        String RID = "100"+blh;
        String InState1 = "1";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String PayTime =formatter.format(date);
        String RegistrarID = "ghy";
        String PayType = "1";
        String chonghong = "1";
        String InState2 = "1";
        payMapper.writeToInvoice(fph,cost,InState1,PayTime,RegistrarID,RID,PayType,chonghong,InState2);
        // 写入患者缴费表
        for (int i = 0; i < medList.size() ; i++) {
            Medicine medicine = payMapper.getMIDandPrice(medList.get(i));
            String ProjectID = medicine.getMID();
            float Price = medicine.getMPrice();
            String ProjectName = medicine.getMName();
            int Amount = 1;
            Date date1 = new Date();
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String PayTime1 =formatter1.format(date1);
            String PayType1 = "1";
            String ProjectType = "2";
            String RID1 = "100"+blh;
            String fph1 = fph;
            int PayID = payMapper.getID() + 1;
            payMapper.writeToPayment(PayID,RID1,fph1,ProjectID,ProjectType,ProjectName,Price,Amount,PayTime,PayType);
        }
        return "invoice";
    }


}
