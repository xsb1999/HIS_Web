package com.his.his_20184861.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FaYaoInfo {
    private String MName;
    private float MPrice;
    private int MedAmount;
    private String PreName;
    private String CreateTime;
}


