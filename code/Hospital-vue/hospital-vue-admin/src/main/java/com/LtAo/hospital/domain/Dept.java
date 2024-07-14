package com.LtAo.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 科室管理对象 tb_dept
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public class Dept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String name;

    /** 是否为门诊 */
    @Excel(name = "是否为门诊")
    private Integer outpatient;

    /** 详细介绍 */
    @Excel(name = "详细介绍")
    private String description;

    /** 是否为推荐科室 */
    @Excel(name = "是否为推荐科室")
    private Integer recommended;

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
    public void setOutpatient(Integer outpatient) 
    {
        this.outpatient = outpatient;
    }

    public Integer getOutpatient() 
    {
        return outpatient;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setRecommended(Integer recommended) 
    {
        this.recommended = recommended;
    }

    public Integer getRecommended() 
    {
        return recommended;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("outpatient", getOutpatient())
            .append("description", getDescription())
            .append("recommended", getRecommended())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
