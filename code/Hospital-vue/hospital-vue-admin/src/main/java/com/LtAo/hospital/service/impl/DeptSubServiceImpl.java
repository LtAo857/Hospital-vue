package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.DeptSubMapper;
import com.LtAo.hospital.domain.DeptSub;
import com.LtAo.hospital.service.IDeptSubService;

/**
 * 诊室管理Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class DeptSubServiceImpl implements IDeptSubService 
{
    @Autowired
    private DeptSubMapper deptSubMapper;

    /**
     * 查询诊室管理
     * 
     * @param id 诊室管理主键
     * @return 诊室管理
     */
    @Override
    public DeptSub selectDeptSubById(Long id)
    {
        return deptSubMapper.selectDeptSubById(id);
    }

    /**
     * 查询诊室管理列表
     * 
     * @param deptSub 诊室管理
     * @return 诊室管理
     */
    @Override
    public List<DeptSub> selectDeptSubList(DeptSub deptSub)
    {
        return deptSubMapper.selectDeptSubList(deptSub);
    }

    /**
     * 新增诊室管理
     * 
     * @param deptSub 诊室管理
     * @return 结果
     */
    @Override
    public int insertDeptSub(DeptSub deptSub)
    {
        deptSub.setCreateTime(DateUtils.getNowDate());
        return deptSubMapper.insertDeptSub(deptSub);
    }

    /**
     * 修改诊室管理
     * 
     * @param deptSub 诊室管理
     * @return 结果
     */
    @Override
    public int updateDeptSub(DeptSub deptSub)
    {
        deptSub.setUpdateTime(DateUtils.getNowDate());
        return deptSubMapper.updateDeptSub(deptSub);
    }

    /**
     * 批量删除诊室管理
     * 
     * @param ids 需要删除的诊室管理主键
     * @return 结果
     */
    @Override
    public int deleteDeptSubByIds(Long[] ids)
    {
        return deptSubMapper.deleteDeptSubByIds(ids);
    }

    /**
     * 删除诊室管理信息
     * 
     * @param id 诊室管理主键
     * @return 结果
     */
    @Override
    public int deleteDeptSubById(Long id)
    {
        return deptSubMapper.deleteDeptSubById(id);
    }
}
