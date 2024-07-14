package com.LtAo.hospital.domain.vo;

import com.LtAo.hospital.domain.Dept;

public class DeptVo extends Dept {

    private String doctorCount;

    private String deptSubCount;


    public String getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(String doctorCount) {
        this.doctorCount = doctorCount;
    }

    public String getDeptSubCount() {
        return deptSubCount;
    }

    public void setDeptSubCount(String deptSubCount) {
        this.deptSubCount = deptSubCount;
    }
}
