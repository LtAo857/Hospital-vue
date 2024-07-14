package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.DeptSub;

/**
 * 诊室管理Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IDeptSubService 
{
    /**
     * 查询诊室管理
     * 
     * @param id 诊室管理主键
     * @return 诊室管理
     */
    public DeptSub selectDeptSubById(Long id);

    /**
     * 查询诊室管理列表
     * 
     * @param deptSub 诊室管理
     * @return 诊室管理集合
     */
    public List<DeptSub> selectDeptSubList(DeptSub deptSub);

    /**
     * 新增诊室管理
     * 
     * @param deptSub 诊室管理
     * @return 结果
     */
    public int insertDeptSub(DeptSub deptSub);

    /**
     * 修改诊室管理
     * 
     * @param deptSub 诊室管理
     * @return 结果
     */
    public int updateDeptSub(DeptSub deptSub);

    /**
     * 批量删除诊室管理
     * 
     * @param ids 需要删除的诊室管理主键集合
     * @return 结果
     */
    public int deleteDeptSubByIds(Long[] ids);

    /**
     * 删除诊室管理信息
     * 
     * @param id 诊室管理主键
     * @return 结果
     */
    public int deleteDeptSubById(Long id);
}
