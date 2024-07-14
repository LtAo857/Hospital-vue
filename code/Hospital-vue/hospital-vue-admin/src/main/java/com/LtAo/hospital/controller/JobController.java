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
import com.LtAo.hospital.domain.Job;
import com.LtAo.hospital.service.IJobService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 职位管理Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/job")
public class JobController extends BaseController
{
    @Autowired
    private IJobService jobService;

    /**
     * 查询职位管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:list')")
    @GetMapping("/list")
    public TableDataInfo list(Job job)
    {
        startPage();
        List<Job> list = jobService.selectJobList(job);
        return getDataTable(list);
    }

    /**
     * 导出职位管理列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:export')")
    @Log(title = "职位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Job job)
    {
        List<Job> list = jobService.selectJobList(job);
        ExcelUtil<Job> util = new ExcelUtil<Job>(Job.class);
        util.exportExcel(response, list, "职位管理数据");
    }

    /**
     * 获取职位管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(jobService.selectJobById(id));
    }

    /**
     * 新增职位管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:add')")
    @Log(title = "职位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Job job)
    {
        return toAjax(jobService.insertJob(job));
    }

    /**
     * 修改职位管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:edit')")
    @Log(title = "职位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Job job)
    {
        return toAjax(jobService.updateJob(job));
    }

    /**
     * 删除职位管理
     */
    @PreAuthorize("@ss.hasPermi('hospital:job:remove')")
    @Log(title = "职位管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(jobService.deleteJobByIds(ids));
    }
}
