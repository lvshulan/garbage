package com.collect.project.baseinfo.model;

import org.apache.ibatis.type.Alias;

import com.collect.common.annotation.Excel;
import com.collect.common.annotation.Excel.ColumnType;
import com.collect.common.core.model.BaseEntity;

import lombok.Data;

/**
 * 省份表 base_province
 * 
 * @author ruoyi
 */
@Alias("province")
@Data
public class Province extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	/** 省份ID */
	@Excel(name = "省份序号", cellType = ColumnType.NUMERIC)
	private Long provinceId;
	
	/** 省份名称 */
	@Excel(name = "省份名称")
	private String provinceName;
	
    
    public Province()
    {
    	
    }
	
    public Province(long provinceId)
    {
    	this.provinceId = provinceId;
    }
	
}
