package com.his.his_20184861.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface RegisterMapper {
    void AddToRegisterTable(@Param("0") String RID, @Param("1")String MedRID,@Param("2")String name, @Param("3")String gender,@Param("4") String id, @Param("5")String birth,@Param("6") int age
    ,@Param("7")String agetype, @Param("8")String home, @Param("9")String watchdate, @Param("10")String noon, @Param("11")String watchstate, @Param("12")String DID, @Param("13")String DocID, @Param("14")String level,
                            @Param("15")String payType, @Param("16")String mh, @Param("17")String time, @Param("18")String ResID);


    void AddToPatient(@Param("1")String MedRID,@Param("2")String name,@Param("4") String id,@Param("6") int age,@Param("3")String gender);

    void AddToRM(@Param("0") String RID, @Param("1")String MedRID);

}
