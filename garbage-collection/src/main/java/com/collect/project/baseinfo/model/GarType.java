package com.collect.project.baseinfo.model;

import org.apache.ibatis.type.Alias;

import com.collect.common.annotation.Excel;
import com.collect.common.annotation.Excel.ColumnType;
import com.collect.common.core.model.BaseEntity;

import lombok.Data;

/**
 * 垃圾类型表 gar_type
 * 
 * @author ruoyi
 */
@Alias("gartype")
@Data
public class GarType extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	/** 垃圾类型ID */
	@Excel(name = "垃圾类型序号", cellType = ColumnType.NUMERIC)
	private Long garId;
	
	/** 垃圾类型 */
	@Excel(name = "垃圾类型")
	private String garType;
	
	/** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
    
    /** 描述 */
    @Excel(name = "描述")
    private String description;
    
    public GarType()
    {
    	
    }
	
    public GarType(long garId)
    {
    	this.garId = garId;
    }
	
}
