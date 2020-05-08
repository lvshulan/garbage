package com.collect.project.baseinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collect.common.constant.UserConstants;
import com.collect.common.core.text.Convert;
import com.collect.common.utils.StringUtils;
import com.collect.project.baseinfo.mapper.IOrderMapper;
import com.collect.project.baseinfo.model.Order;
import com.collect.project.baseinfo.service.IOrderService;

/**
 * 订单 业务层处理
 * 
 * @author ruoyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements IOrderService
{
    @Autowired
    private IOrderMapper orderMapper;

    /**
     * 根据条件分页查询订单
     * 
     * @param order 订单信息
     * @return 订单集合信息
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }
    
//    /**
//     * 查询订单
//     * 
//     * @return 订单集合信息
//     */
//    @Override
//	public List<Order> selectOrderAll()
//	{
//    	return orderMapper.selectOrderAll();
//	}

	 /**
    * 根据省份ID查询订单
    * 
    * @param privinceId 省份ID
    * @return 订单集合信息
    */
	public List<Order> selectOrderListByPrivinceId(Long privinceId)
	{
		return orderMapper.selectOrderListByPrivinceId(privinceId);
	}
	
	/**
    * 根据城市ID查询订单
    * 
    * @param cityId 城市ID
    * @return 订单集合信息
    */
	public List<Order> selectOrderListByCityId(Long cityId)
	{
		return orderMapper.selectOrderListByCityId(cityId);
	}
	
	/**
    * 根据区域ID查询订单
    * 
    * @param areaId 区域ID
    * @return 订单集合信息
    */
	public List<Order> selectOrderListByAreaId(Long areaId)
	{
		return orderMapper.selectOrderListByAreaId(areaId);
	}
	
	/**
    * 根据用户ID查询订单
    * 
    * @param userId 用户ID
    * @return 订单集合信息
    */
	public List<Order> selectOrderListByUserId(Long userId)
	{
		return orderMapper.selectOrderListByUserId(userId);
	}
	
	/**
    * 根据时间段查询订单
    * 
    * @param period 时间段
    * @return 订单集合信息
    */
	public List<Order> selectOrderListByPeriod(String period)
	{
		return orderMapper.selectOrderListByPeriod(period);
	}

    
    /**
     * 根据订单ID查询信息
     * 
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public Order selectOrderById(String orderId)
    {
        return orderMapper.selectOrderById(orderId);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(String ids)
    {
        return orderMapper.deleteOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存订单信息
     * 
     * @param order 订单信息
     * @return 结果
     */
    @Override
    public int insertOrder(Order order)
    {
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改保存订单信息
     * 
     * @param order 订单信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateOrder(Order order)
    {
        return orderMapper.updateOrder(order);
    }

}
