package com.LtAo.hospital.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 医生对象 tb_doctor
 * 
 * @author LtAo
 * @date 2024-07-19
 */
public class Doctor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String name;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String pid;

    /** UUID（用于在工牌上印刷二维码） */
    private String uuid;

    /** 医生性别 */
    @Excel(name = "医生性别")
    private String sex;

    /** 医生照片地址 */
    @Excel(name = "医生照片地址")
    private String photo;

    /** 医生生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "医生生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 医生毕业学校 */
    @Excel(name = "医生毕业学校")
    private String school;

    /** 医生学位 */
    @Excel(name = "医生学位")
    private String degree;

    /** 医生电话 */
    @Excel(name = "医生电话")
    private String tel;

    /** 医生地址 */
    @Excel(name = "医生地址")
    private String address;

    /** 医生邮箱 */
    @Excel(name = "医生邮箱")
    private String email;

    /** 医生职务（主任医师、副主任医师等） */
    @Excel(name = "医生职务", readConverterExp = "主=任医师、副主任医师等")
    private Long jobId;

    /** 详细介绍 */
    @Excel(name = "详细介绍")
    private String description;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hiredate;

    /** 特点标签（小程序上用到） */
    @Excel(name = "特点标签", readConverterExp = "小=程序上用到")
    private String tag;

    /** 是否在小程序上推荐 */
    @Excel(name = "是否在小程序上推荐")
    private Integer recommended;

    /** 状态（1在职，2离职，3退休，4隐藏） */
    @Excel(name = "状态", readConverterExp = "1=在职，2离职，3退休，4隐藏")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setDegree(String degree) 
    {
        this.degree = degree;
    }

    public String getDegree() 
    {
        return degree;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setHiredate(Date hiredate) 
    {
        this.hiredate = hiredate;
    }

    public Date getHiredate() 
    {
        return hiredate;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setRecommended(Integer recommended) 
    {
        this.recommended = recommended;
    }

    public Integer getRecommended() 
    {
        return recommended;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("pid", getPid())
            .append("uuid", getUuid())
            .append("sex", getSex())
            .append("photo", getPhoto())
            .append("birthday", getBirthday())
            .append("school", getSchool())
            .append("degree", getDegree())
            .append("tel", getTel())
            .append("address", getAddress())
            .append("email", getEmail())
            .append("jobId", getJobId())
            .append("remark", getRemark())
            .append("description", getDescription())
            .append("hiredate", getHiredate())
            .append("tag", getTag())
            .append("recommended", getRecommended())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
