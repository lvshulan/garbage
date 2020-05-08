package com.collect.project.baseinfo.model;

import org.apache.ibatis.type.Alias;

import com.collect.common.annotation.Excel;
import com.collect.common.annotation.Excel.ColumnType;
import com.collect.common.core.model.BaseEntity;

import lombok.Data;

/**
 * 垃圾价格表 base_gar_price
 * 
 * @author ruoyi
 */
@Alias("garprice")
@Data
public class GarPrice extends BaseEntity 
{
	private static final long serialVersionUID = 1L;
	
	/** 垃圾价格ID */
	@Excel(name = "垃圾价格序号", cellType = ColumnType.NUMERIC)
	private Long priceId;
	
	/** 垃圾类型 */
	@Excel(name = "垃圾类型")
	private String garType;
	
	/** 垃圾名称 */
	@Excel(name = "垃圾名称")
	private String garName;
	
	/** 单价 */
	@Excel(name = "垃圾价格")
	private String unitPrice;
	
	/** 价格单位 */
	@Excel(name = "价格单位")
	private String unit;
	
	/** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
    
    public GarPrice()
    {
    	
    }
	
    public GarPrice(long priceId)
    {
    	this.priceId = priceId;
    }
	
}
