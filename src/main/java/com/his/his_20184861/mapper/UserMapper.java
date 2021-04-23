package com.his.his_20184861.mapper;

import com.his.his_20184861.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    User VerifyLogin(@Param("id") String ID, @Param("password") String password);
    String getDoctorId(@Param("name") String name);
    String getDepartmentId(@Param("name") String name);
}
