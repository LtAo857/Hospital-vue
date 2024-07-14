package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.Dept;
import com.LtAo.hospital.domain.vo.DeptVo;

/**
 * 科室管理Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IDeptService 
{
    /**
     * 查询科室管理
     * 
     * @param id 科室管理主键
     * @return 科室管理
     */
    public Dept selectDeptById(Long id);

    /**
     * 查询科室管理列表
     * 
     * @param dept 科室管理
     * @return 科室管理集合
     */
    public List<Dept> selectDeptList(Dept dept);

    /**
     * 查询科室管理VO列表
     * @param dept
     * @return 科室管理集合
     */
    public List<DeptVo> selectDeptVoList(Dept dept);



    /**
     * 新增科室管理
     * 
     * @param dept 科室管理
     * @return 结果
     */
    public int insertDept(Dept dept);

    /**
     * 修改科室管理
     * 
     * @param dept 科室管理
     * @return 结果
     */
    public int updateDept(Dept dept);

    /**
     * 批量删除科室管理
     * 
     * @param ids 需要删除的科室管理主键集合
     * @return 结果
     */
    public int deleteDeptByIds(Long[] ids);

    /**
     * 删除科室管理信息
     * 
     * @param id 科室管理主键
     * @return 结果
     */
    public int deleteDeptById(Long id);
}
