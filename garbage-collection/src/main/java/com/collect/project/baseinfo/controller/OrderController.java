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
import com.collect.project.baseinfo.model.Order;
import com.collect.project.baseinfo.service.IOrderService;

/**
 * 订单信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/baseinfo/order")
public class OrderController extends BaseController 
{
	private String prefix = "baseinfo/order";
	
	@Autowired
	private IOrderService orderService;
	
	/**
     * 订单管理
     */
	@GetMapping()
	public String order()
	{
		return prefix + "/type";
	}
	
	/**
     * 订单列表
     */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		startPage();
		List<Order> list = orderService.selectOrderList(order);
		return getDataTable(list);
	}
	
	/**
     * 导出订单列表
     */
	@Log(title = "订单", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
		List<Order> list = orderService.selectOrderList(order);
		ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
		return util.exportExcel(list, "订单");
    }
	
	/**
     * 新增订单
     */
	@GetMapping("/add")
	public String add()
	{
		 return prefix + "/add";
	}
	
	/**
     * 新增保存订单
     */
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Order order)
    {
        order.setUser(ShiroUtils.getUserId());
        //.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(orderService.insertOrder(order));
    }
    
    /**
     * 修改订单
     */
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        mmap.put("order", orderService.selectOrderById(orderId));
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Order order)
    {
        if (UserConstants.GAR_TYPE_NOT_UNIQUE.equals(orderService.checkOrderUnique(order)))
        {
            return error("修改垃圾'" + order.getOrder() + "'失败，订单已存在");
        }
        order.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除订单
     */
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderService.deleteOrderByIds(ids));
    }
    

}
