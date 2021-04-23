package com.his.his_20184861.pojo.vo;

// 收费展示的信息

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PayInfo {
    private String MName;
    private float MPrice;
    private int MedAmount;
    private String CreateTime;
}
