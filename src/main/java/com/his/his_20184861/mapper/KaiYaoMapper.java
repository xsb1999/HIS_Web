package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.po.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KaiYaoMapper {

    // 从数据库中查找所开立的处方明细
    List<Prescription> getSubmitPrescription(@Param("pre_name") String pre_name);

    // 获取患者处方明细表中当前的递增id主键的值
    int getID();

    // 将开立的处方明细写入患者处方明细表
    void writeToPatientPrescriptionDetail(@Param("id") int id, @Param("0") String MedRID, @Param("1")String PreID, @Param("2")String RID, @Param("3")String PreName,
                                          @Param("4") int PreAmount, @Param("5")String CreateDocID, @Param("6") String CreateTime,@Param("7")String MID,
                                          @Param("8")String YongFa, @Param("9")String YongLiang, @Param("10")String PinCi, @Param("11")int MedAmount,
                                          @Param("12")String MState, @Param("13")String PayState);

}

