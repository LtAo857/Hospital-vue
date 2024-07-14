package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.HealthKnowledge;

/**
 * 健康科普Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IHealthKnowledgeService 
{
    /**
     * 查询健康科普
     * 
     * @param id 健康科普主键
     * @return 健康科普
     */
    public HealthKnowledge selectHealthKnowledgeById(Long id);

    /**
     * 查询健康科普列表
     * 
     * @param healthKnowledge 健康科普
     * @return 健康科普集合
     */
    public List<HealthKnowledge> selectHealthKnowledgeList(HealthKnowledge healthKnowledge);

    /**
     * 新增健康科普
     * 
     * @param healthKnowledge 健康科普
     * @return 结果
     */
    public int insertHealthKnowledge(HealthKnowledge healthKnowledge);

    /**
     * 修改健康科普
     * 
     * @param healthKnowledge 健康科普
     * @return 结果
     */
    public int updateHealthKnowledge(HealthKnowledge healthKnowledge);

    /**
     * 批量删除健康科普
     * 
     * @param ids 需要删除的健康科普主键集合
     * @return 结果
     */
    public int deleteHealthKnowledgeByIds(Long[] ids);

    /**
     * 删除健康科普信息
     * 
     * @param id 健康科普主键
     * @return 结果
     */
    public int deleteHealthKnowledgeById(Long id);
}
