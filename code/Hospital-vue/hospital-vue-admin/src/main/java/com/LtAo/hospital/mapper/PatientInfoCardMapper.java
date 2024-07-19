package com.LtAo.hospital.mapper;

import java.util.List;
import com.LtAo.hospital.domain.PatientInfoCard;

/**
 * 患者信息卡Mapper接口
 * 
 * @author LtAo
 * @date 2024-07-13
 */
public interface PatientInfoCardMapper 
{
    /**
     * 查询患者信息卡
     * 
     * @param id 患者信息卡主键
     * @return 患者信息卡
     */
    public PatientInfoCard selectPatientInfoCardById(Long id);

    /**
     * 查询患者信息卡通过用户Id
     * @param userId
     * @return
     */
    public PatientInfoCard selectPatientInfoCardByUserId(Long userId);



    /*在患者信息表通过userId查询患者手机号*/
    public String searchPatientTel(int userId);
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
     * 删除患者信息卡
     * 
     * @param id 患者信息卡主键
     * @return 结果
     */
    public int deletePatientInfoCardById(Long id);

    /**
     * 批量删除患者信息卡
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientInfoCardByIds(Long[] ids);
}
