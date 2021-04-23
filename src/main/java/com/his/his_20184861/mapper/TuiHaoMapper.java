package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.po.Patient;
import com.his.his_20184861.pojo.vo.TuiHaoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TuiHaoMapper {

    // 从挂号表中获取该病历号的信息
    List<TuiHaoInfo> getTuiHaoInfo(@Param("blh") String blh);

    // 通过病历号找到患者姓名和身份证号
    Patient getPatient(@Param("MedRID") String MedRID);

    // 将挂号表中的看诊状态改为”已退号“
    void UpdateTuiHaoState(@Param("blh_t") String blh_t);

}
