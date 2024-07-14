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
import com.LtAo.hospital.domain.DeptSub;
import com.LtAo.hospital.service.IDeptSubService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 诊室管理Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/sub")
public class DeptSubController extends BaseController
{
    @Autowired
    private IDeptSubService deptSubService;

    /**
     * 查询诊室管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:list')")
    @GetMapping("/list")
    public TableDataInfo list(DeptSub deptSub)
    {
        startPage();
        List<DeptSub> list = deptSubService.selectDeptSubList(deptSub);
        return getDataTable(list);
    }

    /**
     * 导出诊室管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:export')")
    @Log(title = "诊室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeptSub deptSub)
    {
        List<DeptSub> list = deptSubService.selectDeptSubList(deptSub);
        ExcelUtil<DeptSub> util = new ExcelUtil<DeptSub>(DeptSub.class);
        util.exportExcel(response, list, "诊室管理数据");
    }

    /**
     * 获取诊室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deptSubService.selectDeptSubById(id));
    }

    /**
     * 新增诊室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:add')")
    @Log(title = "诊室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeptSub deptSub)
    {
        return toAjax(deptSubService.insertDeptSub(deptSub));
    }

    /**
     * 修改诊室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:edit')")
    @Log(title = "诊室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeptSub deptSub)
    {
        return toAjax(deptSubService.updateDeptSub(deptSub));
    }

    /**
     * 删除诊室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:sub:remove')")
    @Log(title = "诊室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deptSubService.deleteDeptSubByIds(ids));
    }
}
