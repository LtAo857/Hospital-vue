package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.Job;

/**
 * 职位管理Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IJobService 
{
    /**
     * 查询职位管理
     * 
     * @param id 职位管理主键
     * @return 职位管理
     */
    public Job selectJobById(Long id);

    /**
     * 查询职位管理列表
     * 
     * @param job 职位管理
     * @return 职位管理集合
     */
    public List<Job> selectJobList(Job job);

    /**
     * 新增职位管理
     * 
     * @param job 职位管理
     * @return 结果
     */
    public int insertJob(Job job);

    /**
     * 修改职位管理
     * 
     * @param job 职位管理
     * @return 结果
     */
    public int updateJob(Job job);

    /**
     * 批量删除职位管理
     * 
     * @param ids 需要删除的职位管理主键集合
     * @return 结果
     */
    public int deleteJobByIds(Long[] ids);

    /**
     * 删除职位管理信息
     * 
     * @param id 职位管理主键
     * @return 结果
     */
    public int deleteJobById(Long id);
}
