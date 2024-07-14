package com.LtAo.hospital.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.LtAo.hospital.domain.vo.DeptVo;
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
import com.LtAo.hospital.domain.Dept;
import com.LtAo.hospital.service.IDeptService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 科室管理Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/dept")
public class DeptController extends BaseController
{
    @Autowired
    private IDeptService deptService;

    /**
     * 查询科室管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(Dept dept)
    {
        startPage();
        List<DeptVo> list = deptService.selectDeptVoList(dept);
        return getDataTable(list);
    }

    /**
     * 导出科室管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:export')")
    @Log(title = "科室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dept dept)
    {
        List<Dept> list = deptService.selectDeptList(dept);
        ExcelUtil<Dept> util = new ExcelUtil<Dept>(Dept.class);
        util.exportExcel(response, list, "科室管理数据");
    }

    /**
     * 获取科室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deptService.selectDeptById(id));
    }

    /**
     * 新增科室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:add')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dept dept)
    {
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 修改科室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:edit')")
    @Log(title = "科室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dept dept)
    {
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 删除科室管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:dept:remove')")
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deptService.deleteDeptByIds(ids));
    }
}
