package com.LtAo.hospital.service.impl;

import java.util.HashMap;
import java.util.List;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.LtAo.common.core.domain.model.MiniLoginBody;
import com.LtAo.common.utils.DateUtils;
import com.LtAo.common.utils.http.HttpUtils;
import com.LtAo.hospital.domain.PatientInfoCard;
import com.LtAo.hospital.domain.vo.MiniPatientLoginVo;
import com.LtAo.hospital.mapper.PatientInfoCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private PatientInfoCardMapper patientInfoCardMapper;


    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

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

    /**
     * 小程序登录或者注册
     * @param miniLoginBody
     * @return
     */
    @Override
    public MiniPatientLoginVo loginOrRegister(MiniLoginBody miniLoginBody){
        MiniPatientLoginVo miniPatientLoginVo = new MiniPatientLoginVo();
        // 实现方法
        // 1.先通过getCode获取openId
        String openId = this.getOpenId(miniLoginBody.getCode());
        // 2.通过openId查询是否存在该患者
        Integer id = patientMapper.searchAlreadyRegistered(openId);
        if ( id==null) {
            // 不存在，执行注册
            Patient patient = new Patient();
            patient.setOpenId(openId);
            patient.setNickname(miniLoginBody.getNickname());
            patient.setPhoto(miniLoginBody.getPhoto());
            patient.setSex(miniLoginBody.getSex());
            patientMapper.insertPatient(patient);
            //查询新用户的主键值
            id =  patientMapper.searchAlreadyRegistered(patient.getOpenId());
            miniPatientLoginVo.setStatusMsg("注册成功");
        } else {
            // 存在，获取token
            miniPatientLoginVo.setStatusMsg("登录成功");
            miniPatientLoginVo.setToken("eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjY0OWI4YTdjLWVlNDAtNDNlOC04ZTY1LWI0ZTE3YzMzZGQ4ZSJ9.wAX5kwViRLLuNWbNLnZ2fCNsdvG4TavYEqLj1WVjS7AcJiyClMS_XLGO94pairr5tl7y4gVDXmeRhJfyHqOgOg");
        }
        // 3.查询患者信息卡中的电话号码
        String patientTel = patientInfoCardMapper.searchPatientTel(id);
        miniPatientLoginVo.setTel(patientTel);

        return miniPatientLoginVo;
    }
    /**
     * 通过wx的code获取当前登录患者的openId
     * @return
     */
    private String getOpenId(String code) {
        // 通过微信公众号平台，以及appid，secret，js_code，grant_type四个参数获取
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap map = new HashMap();
        map.put("appid", appId);
        map.put("secret", appSecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String response = HttpUtil.post(url, map);
        // {"session_key":"q4JrGB0+Vr1qa5roHPbrGw==","openid":"oYhEv4_-pu7QtCyS_x1pQ8WAiSoY"}
        JSONObject json = JSONUtil.parseObj(response);
        String openId = json.getStr("openid");
        if (openId == null || openId.length() == 0) {
            throw new RuntimeException("临时登陆凭证错误");
        }

        return openId;
    }
}
