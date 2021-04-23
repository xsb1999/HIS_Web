package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.po.Medicine;
import com.his.his_20184861.pojo.po.Patient;
import com.his.his_20184861.pojo.vo.PayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PayMapper {

    // 患者输入病历号，查看所要缴费的药品
    List<PayInfo> getPayInfo(@Param("MedRID") String MedRID);

    // 患者输入病历号，得到该患者的姓名和身份证号
    Patient getPatient(@Param("MedRID") String MedRID);

    // 在患者处方明细表中，将完成收费的药品的状态改为“已缴费”
    void changeState(@Param("blh") String blh, @Param("medList") List<String> medList);

    // 写入发票表
    void writeToInvoice(@Param("0") String InID, @Param("1")float InCost, @Param("2")String InState1, @Param("3")String PayTime, @Param("4") String RegistrarID, @Param("5")String RID,
                        @Param("6") String PayType, @Param("7")String Chonghong, @Param("8")String InState2);

    // 写入缴费明细表
    void writeToPayment(@Param("0") int PayID, @Param("1")String RID, @Param("2")String InID, @Param("3")String ProjectID, @Param("4") String ProjectType, @Param("5")String ProjectName,
                        @Param("6") float Price, @Param("7")int Amount, @Param("8")String PayTime, @Param("9")String PayType);


    // 通过药品名称得到药品id和单价
    Medicine getMIDandPrice(@Param("MName") String MName);


    // 获得当前缴费明细表中的递增id主键的最大值
    int getID();

}
