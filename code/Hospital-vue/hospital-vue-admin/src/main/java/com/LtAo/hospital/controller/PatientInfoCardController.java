package com.LtAo.hospital.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LtAo.common.annotation.Log;
import com.LtAo.common.core.controller.BaseController;
import com.LtAo.common.core.domain.AjaxResult;
import com.LtAo.common.enums.BusinessType;
import com.LtAo.hospital.domain.PatientInfoCard;
import com.LtAo.hospital.service.IPatientInfoCardService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 患者信息卡Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/card")
public class PatientInfoCardController extends BaseController
{
    @Autowired
    private IPatientInfoCardService patientInfoCardService;

    /**
     * 查询患者信息卡列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:list')")
    @GetMapping("/list")
    public TableDataInfo list(PatientInfoCard patientInfoCard)
    {
        startPage();
        List<PatientInfoCard> list = patientInfoCardService.selectPatientInfoCardList(patientInfoCard);
        return getDataTable(list);
    }

    /**
     * 导出患者信息卡列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:export')")
    @Log(title = "患者信息卡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PatientInfoCard patientInfoCard)
    {
        List<PatientInfoCard> list = patientInfoCardService.selectPatientInfoCardList(patientInfoCard);
        ExcelUtil<PatientInfoCard> util = new ExcelUtil<PatientInfoCard>(PatientInfoCard.class);
        util.exportExcel(response, list, "患者信息卡数据");
    }

    /**
     * 通过用户id获取患者信息卡详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:query')")
    @GetMapping( "/patientInfo/{userId}")
    public AjaxResult patientInfoCardService(@PathVariable("userId") Long userId)
    {
        // 打印userIdStr
        System.out.println("userId = " + userId);
        return success(patientInfoCardService.selectPatientInfoCardByUserId(userId));
    }



    /**
     * 获取患者信息卡详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(patientInfoCardService.selectPatientInfoCardById(id));
    }

    /**
     * 新增患者信息卡
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:add')")
    @Log(title = "患者信息卡", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PatientInfoCard patientInfoCard)
    {
        return toAjax(patientInfoCardService.insertPatientInfoCard(patientInfoCard));
    }

    /**
     * 修改患者信息卡
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:edit')")
    @Log(title = "患者信息卡", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PatientInfoCard patientInfoCard)
    {
        return toAjax(patientInfoCardService.updatePatientInfoCard(patientInfoCard));
    }

    /**
     * 删除患者信息卡
     */
    @PreAuthorize("@ss.hasPermi('hospital:card:remove')")
    @Log(title = "患者信息卡", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(patientInfoCardService.deletePatientInfoCardByIds(ids));
    }
}
