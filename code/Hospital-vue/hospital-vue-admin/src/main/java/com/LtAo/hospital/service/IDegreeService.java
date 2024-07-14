package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.Degree;

/**
 * 学位
Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IDegreeService 
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
     * 批量删除学位

     * 
     * @param ids 需要删除的学位
主键集合
     * @return 结果
     */
    public int deleteDegreeByIds(Long[] ids);

    /**
     * 删除学位
信息
     * 
     * @param id 学位
主键
     * @return 结果
     */
    public int deleteDegreeById(Long id);
}
