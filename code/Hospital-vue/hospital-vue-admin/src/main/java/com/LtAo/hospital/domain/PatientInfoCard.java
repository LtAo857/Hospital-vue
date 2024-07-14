package com.LtAo.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 患者信息卡对象 tb_patient_info_card
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public class PatientInfoCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long userId;

    /** UUID，当做患者信息卡的编号 */
    @Excel(name = "UUID，当做患者信息卡的编号")
    private String uuid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 医生性别 */
    @Excel(name = "医生性别")
    private String sex;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String pid;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String tel;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 疾病史，JSON数组 */
    @Excel(name = "疾病史，JSON数组")
    private String medicalHistory;

    /** 保险类型 */
    @Excel(name = "保险类型")
    private String insuranceType;

    /** 是否录入面部信息 */
    @Excel(name = "是否录入面部信息")
    private Integer existFaceModel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setMedicalHistory(String medicalHistory) 
    {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() 
    {
        return medicalHistory;
    }
    public void setInsuranceType(String insuranceType) 
    {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() 
    {
        return insuranceType;
    }
    public void setExistFaceModel(Integer existFaceModel) 
    {
        this.existFaceModel = existFaceModel;
    }

    public Integer getExistFaceModel() 
    {
        return existFaceModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("uuid", getUuid())
            .append("name", getName())
            .append("sex", getSex())
            .append("pid", getPid())
            .append("tel", getTel())
            .append("birthday", getBirthday())
            .append("medicalHistory", getMedicalHistory())
            .append("insuranceType", getInsuranceType())
            .append("existFaceModel", getExistFaceModel())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
