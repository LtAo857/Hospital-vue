package com.LtAo.hospital.service.impl;

import java.util.List;
import com.LtAo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LtAo.hospital.mapper.PatientInfoCardMapper;
import com.LtAo.hospital.domain.PatientInfoCard;
import com.LtAo.hospital.service.IPatientInfoCardService;

/**
 * 患者信息卡Service业务层处理
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@Service
public class PatientInfoCardServiceImpl implements IPatientInfoCardService 
{
    @Autowired
    private PatientInfoCardMapper patientInfoCardMapper;

    @Override
    public PatientInfoCard selectPatientInfoCardByUserId(Long userId) {
        return patientInfoCardMapper.selectPatientInfoCardByUserId(userId);
    }

    /**
     * 查询患者信息卡
     * 
     * @param id 患者信息卡主键
     * @return 患者信息卡
     */
    @Override
    public PatientInfoCard selectPatientInfoCardById(Long id)
    {
        return patientInfoCardMapper.selectPatientInfoCardById(id);
    }

    /**
     * 查询患者信息卡列表
     * 
     * @param patientInfoCard 患者信息卡
     * @return 患者信息卡
     */
    @Override
    public List<PatientInfoCard> selectPatientInfoCardList(PatientInfoCard patientInfoCard)
    {
        return patientInfoCardMapper.selectPatientInfoCardList(patientInfoCard);
    }

    /**
     * 新增患者信息卡
     * 
     * @param patientInfoCard 患者信息卡
     * @return 结果
     */
    @Override
    public int insertPatientInfoCard(PatientInfoCard patientInfoCard)
    {
        patientInfoCard.setCreateTime(DateUtils.getNowDate());
        return patientInfoCardMapper.insertPatientInfoCard(patientInfoCard);
    }

    /**
     * 修改患者信息卡
     * 
     * @param patientInfoCard 患者信息卡
     * @return 结果
     */
    @Override
    public int updatePatientInfoCard(PatientInfoCard patientInfoCard)
    {
        patientInfoCard.setUpdateTime(DateUtils.getNowDate());
        return patientInfoCardMapper.updatePatientInfoCard(patientInfoCard);
    }

    /**
     * 批量删除患者信息卡
     * 
     * @param ids 需要删除的患者信息卡主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoCardByIds(Long[] ids)
    {
        return patientInfoCardMapper.deletePatientInfoCardByIds(ids);
    }

    /**
     * 删除患者信息卡信息
     * 
     * @param id 患者信息卡主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoCardById(Long id)
    {
        return patientInfoCardMapper.deletePatientInfoCardById(id);
    }
}
