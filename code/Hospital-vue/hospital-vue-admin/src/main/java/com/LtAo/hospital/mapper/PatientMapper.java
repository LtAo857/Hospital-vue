package com.LtAo.hospital.mapper;

import java.util.List;
import com.LtAo.hospital.domain.Patient;

/**
 * 患者小程序账号Mapper接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface PatientMapper 
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
     * 删除患者小程序账号
     * 
     * @param id 患者小程序账号主键
     * @return 结果
     */
    public int deletePatientById(Long id);

    /**
     * 批量删除患者小程序账号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientByIds(Long[] ids);


    /**
     * 查询当前患者是否注册
     * @param openId
     * @return
     */
    public Integer searchAlreadyRegistered(String openId);
}
