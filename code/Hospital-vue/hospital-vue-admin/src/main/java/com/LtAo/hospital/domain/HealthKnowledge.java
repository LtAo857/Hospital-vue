package com.LtAo.hospital.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.LtAo.common.annotation.Excel;
import com.LtAo.common.core.domain.BaseEntity;

/**
 * 健康科普对象 tb_health_knowledge
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public class HealthKnowledge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
    private Long views;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likes;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long comments;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setViews(Long views) 
    {
        this.views = views;
    }

    public Long getViews() 
    {
        return views;
    }
    public void setLikes(Long likes) 
    {
        this.likes = likes;
    }

    public Long getLikes() 
    {
        return likes;
    }
    public void setComments(Long comments) 
    {
        this.comments = comments;
    }

    public Long getComments() 
    {
        return comments;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("category", getCategory())
            .append("author", getAuthor())
            .append("views", getViews())
            .append("likes", getLikes())
            .append("comments", getComments())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
