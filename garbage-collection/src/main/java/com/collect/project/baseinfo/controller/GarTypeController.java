package com.collect.project.baseinfo.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collect.common.annotation.Log;
import com.collect.common.constant.UserConstants;
import com.collect.common.core.controller.BaseController;
import com.collect.common.core.model.AjaxResult;
import com.collect.common.core.page.TableDataInfo;
import com.collect.common.enums.BusinessType;
import com.collect.common.utils.poi.ExcelUtil;
import com.collect.framework.util.ShiroUtils;
import com.collect.project.baseinfo.model.GarType;
import com.collect.project.baseinfo.service.IGarTypeService;

/**
 * 垃圾类型信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/baseinfo/gar/type")
public class GarTypeController extends BaseController 
{
	private String prefix = "baseinfo/gar/type";
	
	@Autowired
	private IGarTypeService garTypeService;
	
	/**
     * 垃圾管理
     */
	@GetMapping()
	public String garType()
	{
		return prefix + "/type";
	}
	
	/**
     * 垃圾类型列表
     */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GarType garType)
	{
		startPage();
		List<GarType> list = garTypeService.selectGarTypeList(garType);
		return getDataTable(list);
	}
	
	/**
     * 导出垃圾类型列表
     */
	@Log(title = "垃圾类型", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarType garType)
    {
		List<GarType> list = garTypeService.selectGarTypeList(garType);
		ExcelUtil<GarType> util = new ExcelUtil<GarType>(GarType.class);
		return util.exportExcel(list, "垃圾类型");
    }
	
	/**
     * 新增垃圾类型
     */
	@GetMapping("/add")
	public String add()
	{
		 return prefix + "/add";
	}
	
	/**
     * 新增保存垃圾类型
     */
    @Log(title = "垃圾类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated GarType gar)
    {
        if (UserConstants.GAR_TYPE_NOT_UNIQUE.equals(garTypeService.checkGarTypeUnique(gar)))
        {
            return error("新增垃圾'" + gar.getGarType() + "'失败，垃圾类型已存在");
        }
        gar.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(garTypeService.insertGarType(gar));
    }
    
    /**
     * 修改垃圾类型
     */
    @GetMapping("/edit/{garId}")
    public String edit(@PathVariable("garId") Long garId, ModelMap mmap)
    {
        mmap.put("gar", garTypeService.selectGarTypeById(garId));
        return prefix + "/edit";
    }

    /**
     * 修改保存垃圾类型
     */
    @Log(title = "垃圾类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated GarType gar)
    {
        if (UserConstants.GAR_TYPE_NOT_UNIQUE.equals(garTypeService.checkGarTypeUnique(gar)))
        {
            return error("修改垃圾'" + gar.getGarType() + "'失败，垃圾类型已存在");
        }
        gar.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(garTypeService.updateGarType(gar));
    }

    /**
     * 删除垃圾类型
     */
    @Log(title = "垃圾类型", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garTypeService.deleteGarTypeByIds(ids));
    }
    
    /**
     * 垃圾类型详细
     */
    @GetMapping("/detail/{garId}")
    public String detail(@PathVariable("garId") Long garId, ModelMap mmap)
    {
        mmap.put("garType", garTypeService.selectGarTypeById(garId));
        return prefix + "/detail";
    }
    /**
     * 校验垃圾类型
     */
    @PostMapping("/checkGarTypeUnique")
    @ResponseBody
    public String checkGarTypeUnique(GarType garType)
    {
        return garTypeService.checkGarTypeUnique(garType);
    }
}
