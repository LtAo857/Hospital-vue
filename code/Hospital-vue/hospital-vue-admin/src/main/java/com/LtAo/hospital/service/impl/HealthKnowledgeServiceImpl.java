package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.HealthKnowledgeMapper;
import com.LtAo.hospital.domain.HealthKnowledge;
import com.LtAo.hospital.service.IHealthKnowledgeService;

/**
 * 健康科普Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class HealthKnowledgeServiceImpl implements IHealthKnowledgeService 
{
    @Autowired
    private HealthKnowledgeMapper healthKnowledgeMapper;

    /**
     * 查询健康科普
     * 
     * @param id 健康科普主键
     * @return 健康科普
     */
    @Override
    public HealthKnowledge selectHealthKnowledgeById(Long id)
    {
        return healthKnowledgeMapper.selectHealthKnowledgeById(id);
    }

    /**
     * 查询健康科普列表
     * 
     * @param healthKnowledge 健康科普
     * @return 健康科普
     */
    @Override
    public List<HealthKnowledge> selectHealthKnowledgeList(HealthKnowledge healthKnowledge)
    {
        return healthKnowledgeMapper.selectHealthKnowledgeList(healthKnowledge);
    }

    /**
     * 新增健康科普
     * 
     * @param healthKnowledge 健康科普
     * @return 结果
     */
    @Override
    public int insertHealthKnowledge(HealthKnowledge healthKnowledge)
    {
        healthKnowledge.setCreateTime(DateUtils.getNowDate());
        return healthKnowledgeMapper.insertHealthKnowledge(healthKnowledge);
    }

    /**
     * 修改健康科普
     * 
     * @param healthKnowledge 健康科普
     * @return 结果
     */
    @Override
    public int updateHealthKnowledge(HealthKnowledge healthKnowledge)
    {
        healthKnowledge.setUpdateTime(DateUtils.getNowDate());
        return healthKnowledgeMapper.updateHealthKnowledge(healthKnowledge);
    }

    /**
     * 批量删除健康科普
     * 
     * @param ids 需要删除的健康科普主键
     * @return 结果
     */
    @Override
    public int deleteHealthKnowledgeByIds(Long[] ids)
    {
        return healthKnowledgeMapper.deleteHealthKnowledgeByIds(ids);
    }

    /**
     * 删除健康科普信息
     * 
     * @param id 健康科普主键
     * @return 结果
     */
    @Override
    public int deleteHealthKnowledgeById(Long id)
    {
        return healthKnowledgeMapper.deleteHealthKnowledgeById(id);
    }
}
