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
import org.springframework.web.multipart.MultipartFile;

import com.collect.common.annotation.Log;
import com.collect.common.constant.UserConstants;
import com.collect.common.core.controller.BaseController;
import com.collect.common.core.model.AjaxResult;
import com.collect.common.core.page.TableDataInfo;
import com.collect.common.enums.BusinessType;
import com.collect.common.utils.poi.ExcelUtil;
import com.collect.framework.util.ShiroUtils;
import com.collect.project.baseinfo.model.GarPrice;
import com.collect.project.baseinfo.service.IGarPriceService;
import com.collect.project.baseinfo.service.IGarTypeService;
/**
 * 垃圾价格信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/baseinfo/gar/price")
public class GarPriceController extends BaseController 
{
	private String prefix = "baseinfo/gar/price";
	
	@Autowired
	private IGarPriceService garPriceService;
	
	@Autowired
	private IGarTypeService garTypeService;
	
	/**
     * 垃圾价格管理
     */
	@GetMapping()
	public String garPrice(ModelMap mmap)
	{
		mmap.put("gar", garTypeService.selectGarTypeAll());
		return prefix + "/price";
	}
	
	/**
     * 垃圾价格列表
     */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GarPrice garPrice)
	{
		startPage();
		List<GarPrice> list = garPriceService.selectGarPriceList(garPrice);
		return getDataTable(list);
	}
	
	/**
     * 导出垃圾价格列表
     */
	@Log(title = "垃圾价格", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarPrice garPrice)
    {
		List<GarPrice> list = garPriceService.selectGarPriceList(garPrice);
		ExcelUtil<GarPrice> util = new ExcelUtil<GarPrice>(GarPrice.class);
		return util.exportExcel(list, "垃圾价格");
    }
	
    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(Long userId, MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<GarPrice> util = new ExcelUtil<GarPrice>(GarPrice.class);
        List<GarPrice> garPriceList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getUser().getLoginName();
        String message = garPriceService.importGarPrice(garPriceList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<GarPrice> util = new ExcelUtil<GarPrice>(GarPrice.class);
        return util.importTemplateExcel("垃圾价格数据");
    }	
	
	/**
     * 新增垃圾价格
     */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("gar", garTypeService.selectGarTypeAll());
		 return prefix + "/add";
	}
	
	/**
     * 新增保存垃圾价格
     */
    @Log(title = "垃圾价格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated GarPrice gar)
    {
        if (UserConstants.GAR_PRICE_NOT_UNIQUE.equals(garPriceService.checkGarNameUnique(gar)))
        {
            return error("新增垃圾'" + gar.getGarName() + "'失败，垃圾名称已存在");
        }
        gar.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(garPriceService.insertGarPrice(gar));
    }
    
    /**
     * 修改垃圾价格
     */
    @GetMapping("/edit/{priceId}")
    public String edit(@PathVariable("priceId") Long priceId, ModelMap mmap)
    {
        mmap.put("gar", garPriceService.selectGarPriceById(priceId));
        return prefix + "/edit";
    }

    /**
     * 修改保存垃圾价格
     */
    @Log(title = "垃圾价格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated GarPrice gar)
    {
        if (UserConstants.GAR_TYPE_NOT_UNIQUE.equals(garPriceService.checkGarNameUnique(gar)))
        {
            return error("修改垃圾'" + gar.getGarName() + "'失败，垃圾价格已存在");
        }
        gar.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(garPriceService.updateGarPrice(gar));
    }

    /**
     * 删除垃圾价格
     */
    @Log(title = "垃圾价格", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garPriceService.deleteGarPriceByIds(ids));
    }
    
    /**
     * 校验垃圾价格
     */
    @PostMapping("/checkGarNameUnique")
    @ResponseBody
    public String checkGarNameUnique(GarPrice garPrice)
    {
        return garPriceService.checkGarNameUnique(garPrice);
    }
}
