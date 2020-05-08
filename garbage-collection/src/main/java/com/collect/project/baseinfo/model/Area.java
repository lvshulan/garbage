package com.collect.project.baseinfo.model;

import org.apache.ibatis.type.Alias;

import com.collect.common.core.model.BaseEntity;

import lombok.Data;

/**
 * 区域表 base_area
 * 
 * @author ruoyi
 */
@Alias("area")
@Data
public class Area extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	/** 区域ID */
	private Long areaId;
	
	/** 区域名称 */
	private String areaName;
	
	/** 城市ID */
	private City city;
	
    public Area()
    {
    	
    }
	
    public Area(long areaId)
    {
    	this.areaId = areaId;
    }
	
}