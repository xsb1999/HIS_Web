package com.his.his_20184861.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Prescription {
    private String PreID;
    private String MID;
    private String YongFa;
    private String YongLiang;
    private String PinCi;
    private int Amount;
}
