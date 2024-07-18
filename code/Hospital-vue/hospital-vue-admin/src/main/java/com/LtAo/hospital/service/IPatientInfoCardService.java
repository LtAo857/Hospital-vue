package com.LtAo.hospital.service;

import java.util.List;
import com.LtAo.hospital.domain.PatientInfoCard;

/**
 * 患者信息卡Service接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface IPatientInfoCardService
{

//    /**
//     * 在患者信息表通过userId查询患者手机号
//     * @param userId
//     * @return
//     */
//    public String searchPatientTel(int userId);
//

    public PatientInfoCard selectPatientInfoCardByUserId(Long userId);
    /**
     * 查询患者信息卡
     * 
     * @param id 患者信息卡主键
     * @return 患者信息卡
     */
    public PatientInfoCard selectPatientInfoCardById(Long id);

    /**
     * 查询患者信息卡列表
     * 
     * @param patientInfoCard 患者信息卡
     * @return 患者信息卡集合
     */
    public List<PatientInfoCard> selectPatientInfoCardList(PatientInfoCard patientInfoCard);

    /**
     * 新增患者信息卡
     * 
     * @param patientInfoCard 患者信息卡
     * @return 结果
     */
    public int insertPatientInfoCard(PatientInfoCard patientInfoCard);

    /**
     * 修改患者信息卡
     * 
     * @param patientInfoCard 患者信息卡
     * @return 结果
     */
    public int updatePatientInfoCard(PatientInfoCard patientInfoCard);

    /**
     * 批量删除患者信息卡
     * 
     * @param ids 需要删除的患者信息卡主键集合
     * @return 结果
     */
    public int deletePatientInfoCardByIds(Long[] ids);

    /**
     * 删除患者信息卡信息
     * 
     * @param id 患者信息卡主键
     * @return 结果
     */
    public int deletePatientInfoCardById(Long id);
}
