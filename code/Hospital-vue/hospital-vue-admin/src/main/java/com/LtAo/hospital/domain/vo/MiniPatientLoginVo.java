package com.LtAo.hospital.domain.vo;

import com.LtAo.hospital.domain.Patient;
import lombok.Data;

@Data
public class MiniPatientLoginVo {

    // 电话号码
    private String tel;

    private String statusMsg;

    private String token;



}
