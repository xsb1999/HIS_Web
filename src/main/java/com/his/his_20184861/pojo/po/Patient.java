package com.his.his_20184861.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Patient {
    private String MedRID;
    private String NAME;
    private String Identification;
    private String Age;
    private String Gender;
}
