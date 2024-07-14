package com.LtAo.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 学位
对象 tb_degree
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public class Degree extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学位名称 */
    @Excel(name = "学位名称")
    private String name;

    /** 学位类型：1=学士，2=硕士，3=博士，4=其他 */
    @Excel(name = "学位类型：1=学士，2=硕士，3=博士，4=其他")
    private Long type;

    /** 学位描述 */
    @Excel(name = "学位描述")
    private String description;

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
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
