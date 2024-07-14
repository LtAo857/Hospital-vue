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
import com.LtAo.hospital.domain.Degree;
import com.LtAo.hospital.service.IDegreeService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 学位
Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/degree")
public class DegreeController extends BaseController
{
    @Autowired
    private IDegreeService degreeService;

    /**
     * 查询学位
列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:list')")
    @GetMapping("/list")
    public TableDataInfo list(Degree degree)
    {
        startPage();
        List<Degree> list = degreeService.selectDegreeList(degree);
        return getDataTable(list);
    }

    /**
     * 导出学位
列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:export')")
    @Log(title = "学位 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Degree degree)
    {
        List<Degree> list = degreeService.selectDegreeList(degree);
        ExcelUtil<Degree> util = new ExcelUtil<Degree>(Degree.class);
        util.exportExcel(response, list, "学位 数据");
    }

    /**
     * 获取学位
详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(degreeService.selectDegreeById(id));
    }

    /**
     * 新增学位

     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:add')")
    @Log(title = "学位 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Degree degree)
    {
        return toAjax(degreeService.insertDegree(degree));
    }

    /**
     * 修改学位

     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:edit')")
    @Log(title = "学位 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Degree degree)
    {
        return toAjax(degreeService.updateDegree(degree));
    }

    /**
     * 删除学位

     */
    @PreAuthorize("@ss.hasPermi('hospital:degree:remove')")
    @Log(title = "学位 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(degreeService.deleteDegreeByIds(ids));
    }
}
