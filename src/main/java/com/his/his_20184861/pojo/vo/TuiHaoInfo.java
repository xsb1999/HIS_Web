package com.his.his_20184861.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TuiHaoInfo {
    private String MedRID;
    private String NAME;
    private String WatchDate;
    private String Noon;
    private String DName;
    private String WatchState;
}
