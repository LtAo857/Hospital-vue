package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.Patient;

/**
 * 患者小程序账号Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IPatientService 
{
    /**
     * 查询患者小程序账号
     * 
     * @param id 患者小程序账号主键
     * @return 患者小程序账号
     */
    public Patient selectPatientById(Long id);

    /**
     * 查询患者小程序账号列表
     * 
     * @param patient 患者小程序账号
     * @return 患者小程序账号集合
     */
    public List<Patient> selectPatientList(Patient patient);

    /**
     * 新增患者小程序账号
     * 
     * @param patient 患者小程序账号
     * @return 结果
     */
    public int insertPatient(Patient patient);

    /**
     * 修改患者小程序账号
     * 
     * @param patient 患者小程序账号
     * @return 结果
     */
    public int updatePatient(Patient patient);

    /**
     * 批量删除患者小程序账号
     * 
     * @param ids 需要删除的患者小程序账号主键集合
     * @return 结果
     */
    public int deletePatientByIds(Long[] ids);

    /**
     * 删除患者小程序账号信息
     * 
     * @param id 患者小程序账号主键
     * @return 结果
     */
    public int deletePatientById(Long id);
}
