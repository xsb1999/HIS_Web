package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.vo.FaYaoInfo;
import com.his.his_20184861.pojo.po.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FaYaoMapper {

    // 从患者处方明细表中获取已经交费的药品
    List<FaYaoInfo> getMedicine(@Param("blh") String blh);

    // 通过病历号找到患者姓名和身份证号
    Patient getPatient(@Param("MedRID") String MedRID);

    // 更新患者处方表中的药品状态为“已发药”
    void changeMState(@Param("blh") String blh);

}
