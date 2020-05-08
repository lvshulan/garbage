package com.collect.project.baseinfo.model;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.collect.common.annotation.Excel;
import com.collect.common.annotation.Excel.ColumnType;
import com.collect.common.core.model.BaseEntity;
import com.collect.common.utils.DateUtils;
import com.collect.project.system.model.User;

import lombok.Data;

/**
 * 订单表 base_order
 * 
 * @author ruoyi
 */
@Alias("order")
@Data
public class Order 
{
	//private static final long serialVersionUID = 1L;
	
	/** 订单ID */
	@Excel(name = "订单号", cellType = ColumnType.NUMERIC)
	private String orderId = DateUtils.dateTimeNow();

	/** 用户ID */
	@Excel(name = "用户号")
	private Long userId;
	
	private User user;
	
	/** 姓名 */
	@Excel(name = "姓名")
	private String userName;
	
	/**  */
	@Excel(name = "")
	private String phone;
	
	/** 省份ID */
	@Excel(name = "省份号")
	private Long provinceId;
	
	private Province province;
	
	/** 城市ID */
	@Excel(name = "城市号")
	private Long cityId;
	
	private City city;
	
	/** 区域ID */
	@Excel(name = "区域号")
	private Long areaId;
	
	private Area area;

	/** 详细地址 */
	private String detailAddress;
	
	/** 图片 */
	private String avatar;
	
	/** 预约时间 */
	private Date serviceTime;
	
	/** 时间段 
	 *  （0 8:00-10:00,1 10:00-12:00,2 12:00-14:00,3 14:00-16:00,4 16:00-18:00 5 18:00-20:00）
	 *  */
	private String period;
	
	/** 下单时间 */
	private Date createTime;
	
	/** 更新时间 */
	private Date updateTime;
	
	/** 状态（0新订单 1处理中 2已处理 3已取消） */
    @Excel(name = "状态", readConverterExp = "0=新订单, 1=处理中,2=已处理,3=已取消")
    private String status;
    
    /** 交易金额 */
    private BigDecimal amount;
    
    /** 备注 */
    private String remake;
    
    public Order()
    {
    	
    }
	
    public Order(String orderId)
    {
    	this.orderId = orderId;
    }

	public void setUser(Long userId) {
		// TODO Auto-generated method stub
		
	}
	
}
