package com.LtAo.hospital.mapper;

import java.util.List;
import com.LtAo.hospital.domain.Degree;

/**
 * 学位
Mapper接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface DegreeMapper 
{
    /**
     * 查询学位

     * 
     * @param id 学位
主键
     * @return 学位

     */
    public Degree selectDegreeById(Long id);

    /**
     * 查询学位
列表
     * 
     * @param degree 学位

     * @return 学位
集合
     */
    public List<Degree> selectDegreeList(Degree degree);

    /**
     * 新增学位

     * 
     * @param degree 学位

     * @return 结果
     */
    public int insertDegree(Degree degree);

    /**
     * 修改学位

     * 
     * @param degree 学位

     * @return 结果
     */
    public int updateDegree(Degree degree);

    /**
     * 删除学位

     * 
     * @param id 学位
主键
     * @return 结果
     */
    public int deleteDegreeById(Long id);

    /**
     * 批量删除学位

     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDegreeByIds(Long[] ids);
}
