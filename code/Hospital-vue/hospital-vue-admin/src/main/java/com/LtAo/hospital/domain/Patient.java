package com.LtAo.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 患者小程序账号对象 tb_patient
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public class Patient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 唯一授权字符串 */
    @Excel(name = "唯一授权字符串")
    private String openId;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String nickname;

    /** 微信头像 */
    @Excel(name = "微信头像")
    private String photo;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String sex;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
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
            .append("openId", getOpenId())
            .append("nickname", getNickname())
            .append("photo", getPhoto())
            .append("sex", getSex())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
