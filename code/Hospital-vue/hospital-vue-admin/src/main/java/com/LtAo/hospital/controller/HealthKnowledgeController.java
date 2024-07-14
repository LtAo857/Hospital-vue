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
import com.LtAo.hospital.domain.HealthKnowledge;
import com.LtAo.hospital.service.IHealthKnowledgeService;
import com.LtAo.common.utils.poi.ExcelUtil;
import com.LtAo.common.core.page.TableDataInfo;

/**
 * 健康科普Controller
 * 
 * @author LtAo
 * @date 2024-07-13
 */
@RestController
@RequestMapping("/hospital/knowledge")
public class HealthKnowledgeController extends BaseController
{
    @Autowired
    private IHealthKnowledgeService healthKnowledgeService;

    /**
     * 查询健康科普列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthKnowledge healthKnowledge)
    {
        startPage();
        List<HealthKnowledge> list = healthKnowledgeService.selectHealthKnowledgeList(healthKnowledge);
        return getDataTable(list);
    }

    /**
     * 导出健康科普列表
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:export')")
    @Log(title = "健康科普", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthKnowledge healthKnowledge)
    {
        List<HealthKnowledge> list = healthKnowledgeService.selectHealthKnowledgeList(healthKnowledge);
        ExcelUtil<HealthKnowledge> util = new ExcelUtil<HealthKnowledge>(HealthKnowledge.class);
        util.exportExcel(response, list, "健康科普数据");
    }

    /**
     * 获取健康科普详细信息
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthKnowledgeService.selectHealthKnowledgeById(id));
    }

    /**
     * 新增健康科普
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:add')")
    @Log(title = "健康科普", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthKnowledge healthKnowledge)
    {
        return toAjax(healthKnowledgeService.insertHealthKnowledge(healthKnowledge));
    }

    /**
     * 修改健康科普
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:edit')")
    @Log(title = "健康科普", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthKnowledge healthKnowledge)
    {
        return toAjax(healthKnowledgeService.updateHealthKnowledge(healthKnowledge));
    }

    /**
     * 删除健康科普
     */
    @PreAuthorize("@ss.hasPermi('hospital:knowledge:remove')")
    @Log(title = "健康科普", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthKnowledgeService.deleteHealthKnowledgeByIds(ids));
    }
}
