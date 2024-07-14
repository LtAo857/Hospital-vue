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
import com.LtAo.hospital.domain.Patient;
import com.LtAo.hospital.service.IPatientService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 患者小程序账号Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/patient")
public class PatientController extends BaseController
{
    @Autowired
    private IPatientService patientService;

    /**
     * 查询患者小程序账号列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(Patient patient)
    {
        startPage();
        List<Patient> list = patientService.selectPatientList(patient);
        return getDataTable(list);
    }

    /**
     * 导出患者小程序账号列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:export')")
    @Log(title = "患者小程序账号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Patient patient)
    {
        List<Patient> list = patientService.selectPatientList(patient);
        ExcelUtil<Patient> util = new ExcelUtil<Patient>(Patient.class);
        util.exportExcel(response, list, "患者小程序账号数据");
    }

    /**
     * 获取患者小程序账号详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(patientService.selectPatientById(id));
    }

    /**
     * 新增患者小程序账号
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:add')")
    @Log(title = "患者小程序账号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Patient patient)
    {
        return toAjax(patientService.insertPatient(patient));
    }

    /**
     * 修改患者小程序账号
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:edit')")
    @Log(title = "患者小程序账号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Patient patient)
    {
        return toAjax(patientService.updatePatient(patient));
    }

    /**
     * 删除患者小程序账号
     */
    @PreAuthorize("@ss.hasPermi('hospital:patient:remove')")
    @Log(title = "患者小程序账号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(patientService.deletePatientByIds(ids));
    }
}
