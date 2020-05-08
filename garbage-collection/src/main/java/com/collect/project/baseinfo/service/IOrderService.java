package com.collect.project.baseinfo.service;

import java.util.List;

import com.collect.project.baseinfo.model.Order;

/**
 * 订单 业务层
 * 
 * @author ruoyi
 */
public interface IOrderService
{
    /**
     * 根据条件分页查询订单
     * 
     * @param Order 订单信息
     * @return 订单集合信息
     */
    public List<Order> selectOrderList(Order order);

	 /**
     * 根据省份ID查询订单
     * 
     * @param privinceId 省份ID
     * @return 订单集合信息
     */
	public List<Order> selectOrderListByPrivinceId(Long privinceId);
	
	/**
     * 根据城市ID查询订单
     * 
     * @param cityId 城市ID
     * @return 订单集合信息
     */
	public List<Order> selectOrderListByCityId(Long cityId);
	
	/**
     * 根据区域ID查询订单
     * 
     * @param areaId 区域ID
     * @return 订单集合信息
     */
	public List<Order> selectOrderListByAreaId(Long areaId);
	
	/**
     * 根据用户ID查询订单
     * 
     * @param userId 用户ID
     * @return 订单集合信息
     */
	public List<Order> selectOrderListByUserId(Long userId);
	
	/**
     * 根据时间段查询订单
     * 
     * @param period 时间段
     * @return 订单集合信息
     */
	public List<Order> selectOrderListByPeriod(String period);    

	/**
     * 通过订单ID查询订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
	public Order selectOrderById(String orderId);	
	
    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteOrderByIds(String ids);

    /**
     * 新增保存订单信息
     * 
     * @param order 订单信息
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改保存订单信息
     * 
     * @param order 订单信息
     * @return 结果
     */
    public int updateOrder(Order order);

}
