package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import com.LtAo.hospital.domain.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.DeptMapper;
import com.LtAo.hospital.domain.Dept;
import com.LtAo.hospital.service.IDeptService;

/**
 * 科室管理Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class DeptServiceImpl implements IDeptService 
{
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询科室管理
     * 
     * @param id 科室管理主键
     * @return 科室管理
     */
    @Override
    public Dept selectDeptById(Long id)
    {
        return deptMapper.selectDeptById(id);
    }

    /**
     * 查询科室管理列表
     * 
     * @param dept 科室管理
     * @return 科室管理
     */
    @Override
    public List<Dept> selectDeptList(Dept dept)
    {
        return deptMapper.selectDeptList(dept);
    }

    @Override
    public List<DeptVo> selectDeptVoList(Dept dept) {
        return deptMapper.selectDeptVoList(dept);
    }

    /**
     * 新增科室管理
     * 
     * @param dept 科室管理
     * @return 结果
     */
    @Override
    public int insertDept(Dept dept)
    {
        dept.setCreateTime(DateUtils.getNowDate());
        return deptMapper.insertDept(dept);
    }

    /**
     * 修改科室管理
     * 
     * @param dept 科室管理
     * @return 结果
     */
    @Override
    public int updateDept(Dept dept)
    {
        dept.setUpdateTime(DateUtils.getNowDate());
        return deptMapper.updateDept(dept);
    }

    /**
     * 批量删除科室管理
     * 
     * @param ids 需要删除的科室管理主键
     * @return 结果
     */
    @Override
    public int deleteDeptByIds(Long[] ids)
    {
        return deptMapper.deleteDeptByIds(ids);
    }

    /**
     * 删除科室管理信息
     * 
     * @param id 科室管理主键
     * @return 结果
     */
    @Override
    public int deleteDeptById(Long id)
    {
        return deptMapper.deleteDeptById(id);
    }
}
