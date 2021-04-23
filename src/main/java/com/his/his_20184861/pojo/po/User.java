package com.his.his_20184861.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class User {
    private String UID;
    private String PASSWORD;
    private String UName;
    private String UserType;
    private String DoctorType;
    private String UserJobTitle;
    private String DID;

}
