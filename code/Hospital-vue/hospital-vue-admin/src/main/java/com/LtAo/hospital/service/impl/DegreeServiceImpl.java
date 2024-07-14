package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.DegreeMapper;
import com.LtAo.hospital.domain.Degree;
import com.LtAo.hospital.service.IDegreeService;

/**
 * 学位
Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class DegreeServiceImpl implements IDegreeService 
{
    @Autowired
    private DegreeMapper degreeMapper;

    /**
     * 查询学位

     * 
     * @param id 学位
主键
     * @return 学位

     */
    @Override
    public Degree selectDegreeById(Long id)
    {
        return degreeMapper.selectDegreeById(id);
    }

    /**
     * 查询学位
列表
     * 
     * @param degree 学位

     * @return 学位

     */
    @Override
    public List<Degree> selectDegreeList(Degree degree)
    {
        return degreeMapper.selectDegreeList(degree);
    }

    /**
     * 新增学位

     * 
     * @param degree 学位

     * @return 结果
     */
    @Override
    public int insertDegree(Degree degree)
    {
        degree.setCreateTime(DateUtils.getNowDate());
        return degreeMapper.insertDegree(degree);
    }

    /**
     * 修改学位

     * 
     * @param degree 学位

     * @return 结果
     */
    @Override
    public int updateDegree(Degree degree)
    {
        degree.setUpdateTime(DateUtils.getNowDate());
        return degreeMapper.updateDegree(degree);
    }

    /**
     * 批量删除学位

     * 
     * @param ids 需要删除的学位
主键
     * @return 结果
     */
    @Override
    public int deleteDegreeByIds(Long[] ids)
    {
        return degreeMapper.deleteDegreeByIds(ids);
    }

    /**
     * 删除学位
信息
     * 
     * @param id 学位
主键
     * @return 结果
     */
    @Override
    public int deleteDegreeById(Long id)
    {
        return degreeMapper.deleteDegreeById(id);
    }
}
