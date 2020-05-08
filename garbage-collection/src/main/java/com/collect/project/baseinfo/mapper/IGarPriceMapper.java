package com.collect.project.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.baseinfo.model.GarPrice;

/**
 * 垃圾价格表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface IGarPriceMapper 
{
	 /**
     * 根据条件分页查询垃圾价格
     * 
     * @param garPrice 垃圾价格信息
     * @return 垃圾价格集合信息
     */
	public List<GarPrice> selectGarPriceList(GarPrice garPrice);

	/**
     * 通过垃圾ID查询垃圾信息
     * 
     * @param garId 垃圾ID
     * @return 结果
     */
	public GarPrice selectGarPriceById(Long garId);
	
	/**
     * 通过垃圾名称查询垃圾价格信息
     * 
     * @param garName 垃圾名称
     * @return 结果
     */
    public GarPrice selectGarPriceByGarName(String garName);
	
    /**
     * 通过垃圾ID删除垃圾价格信息
     * 
     * @param dictId 垃圾ID
     * @return 结果
     */
    public int deleteGarPriceById(Long garId);
    
	/**
     * 批量删除垃圾价格
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteGarPriceByIds(String[] ids);

    /**
     * 新增垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    public int insertGarPrice(GarPrice garPrice);

    /**
     * 修改垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    public int updateGarPrice(GarPrice garPrice);

    /**
     * 校验垃圾名称是否唯一
     * 
     * @param garPrice 垃圾价格
     * @return 结果
     */
    public GarPrice checkGarNameUnique(String garName);
}
