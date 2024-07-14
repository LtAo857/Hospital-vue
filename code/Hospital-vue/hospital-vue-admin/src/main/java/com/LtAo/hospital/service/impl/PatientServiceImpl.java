package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.PatientMapper;
import com.LtAo.hospital.domain.Patient;
import com.LtAo.hospital.service.IPatientService;

/**
 * 患者小程序账号Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class PatientServiceImpl implements IPatientService 
{
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 查询患者小程序账号
     * 
     * @param id 患者小程序账号主键
     * @return 患者小程序账号
     */
    @Override
    public Patient selectPatientById(Long id)
    {
        return patientMapper.selectPatientById(id);
    }

    /**
     * 查询患者小程序账号列表
     * 
     * @param patient 患者小程序账号
     * @return 患者小程序账号
     */
    @Override
    public List<Patient> selectPatientList(Patient patient)
    {
        return patientMapper.selectPatientList(patient);
    }

    /**
     * 新增患者小程序账号
     * 
     * @param patient 患者小程序账号
     * @return 结果
     */
    @Override
    public int insertPatient(Patient patient)
    {
        patient.setCreateTime(DateUtils.getNowDate());
        return patientMapper.insertPatient(patient);
    }

    /**
     * 修改患者小程序账号
     * 
     * @param patient 患者小程序账号
     * @return 结果
     */
    @Override
    public int updatePatient(Patient patient)
    {
        patient.setUpdateTime(DateUtils.getNowDate());
        return patientMapper.updatePatient(patient);
    }

    /**
     * 批量删除患者小程序账号
     * 
     * @param ids 需要删除的患者小程序账号主键
     * @return 结果
     */
    @Override
    public int deletePatientByIds(Long[] ids)
    {
        return patientMapper.deletePatientByIds(ids);
    }

    /**
     * 删除患者小程序账号信息
     * 
     * @param id 患者小程序账号主键
     * @return 结果
     */
    @Override
    public int deletePatientById(Long id)
    {
        return patientMapper.deletePatientById(id);
    }
}
