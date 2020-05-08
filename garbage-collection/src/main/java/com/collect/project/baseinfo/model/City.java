package com.collect.project.baseinfo.model;

import org.apache.ibatis.type.Alias;

import com.collect.common.core.model.BaseEntity;

import lombok.Data;

/**
 * 城市表 base_city
 * 
 * @author ruoyi
 */
@Alias("city")
@Data
public class City extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	/** 城市ID */
	private Long cityId;
	
	/** 城市名称 */
	private String cityName;
	
	/** 省份ID */
	private Province province;
	
    public City()
    {
    	
    }
	
    public City(long cityId)
    {
    	this.cityId = cityId;
    }
	
}
