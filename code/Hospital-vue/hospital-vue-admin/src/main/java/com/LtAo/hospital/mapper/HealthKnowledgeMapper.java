package com.LtAo.hospital.mapper;

import java.util.List;
import com.LtAo.hospital.domain.HealthKnowledge;

/**
 * 健康科普Mapper接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface HealthKnowledgeMapper 
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
     * 删除健康科普
     * 
     * @param id 健康科普主键
     * @return 结果
     */
    public int deleteHealthKnowledgeById(Long id);

    /**
     * 批量删除健康科普
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHealthKnowledgeByIds(Long[] ids);
}
