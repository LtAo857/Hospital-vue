package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.JobMapper;
import com.LtAo.hospital.domain.Job;
import com.LtAo.hospital.service.IJobService;

/**
 * 职位管理Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class JobServiceImpl implements IJobService 
{
    @Autowired
    private JobMapper jobMapper;

    /**
     * 查询职位管理
     * 
     * @param id 职位管理主键
     * @return 职位管理
     */
    @Override
    public Job selectJobById(Long id)
    {
        return jobMapper.selectJobById(id);
    }

    /**
     * 查询职位管理列表
     * 
     * @param job 职位管理
     * @return 职位管理
     */
    @Override
    public List<Job> selectJobList(Job job)
    {
        return jobMapper.selectJobList(job);
    }

    /**
     * 新增职位管理
     * 
     * @param job 职位管理
     * @return 结果
     */
    @Override
    public int insertJob(Job job)
    {
        job.setCreateTime(DateUtils.getNowDate());
        return jobMapper.insertJob(job);
    }

    /**
     * 修改职位管理
     * 
     * @param job 职位管理
     * @return 结果
     */
    @Override
    public int updateJob(Job job)
    {
        job.setUpdateTime(DateUtils.getNowDate());
        return jobMapper.updateJob(job);
    }

    /**
     * 批量删除职位管理
     * 
     * @param ids 需要删除的职位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobByIds(Long[] ids)
    {
        return jobMapper.deleteJobByIds(ids);
    }

    /**
     * 删除职位管理信息
     * 
     * @param id 职位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobById(Long id)
    {
        return jobMapper.deleteJobById(id);
    }
}
