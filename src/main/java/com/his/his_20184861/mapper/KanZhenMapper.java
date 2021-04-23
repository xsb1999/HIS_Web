package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.po.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KanZhenMapper {

    List<Patient> getAllWaitPatient(@Param("doc") String doc);
    List<Patient> getAllDonePatient(@Param("doc") String doc);

    // 提交诊断信息到病历表
    void submitInfo(@Param("0") String RID, @Param("1")String MedRID, @Param("2")String Statement, @Param("3")String CurrentDiseaseHistory,
                    @Param("4") String CurrentSituationOfDisease, @Param("5")String PastDiseaseHistory, @Param("6") String AlleryHistory,
                    @Param("7")String BodyCheck, @Param("8")String CheckAdvice, @Param("9")String Warn, @Param("10")String CheckResult,
                    @Param("11")String DiagnoseResult, @Param("12")String Advice, @Param("13")String MedRState);


}
