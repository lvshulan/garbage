package com.collect.project.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.baseinfo.model.GarType;

/**
 * 垃圾类型表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface IGarTypeMapper 
{
	 /**
     * 根据条件分页查询垃圾类型
     * 
     * @param garType 垃圾类型信息
     * @return 垃圾类型集合信息
     */
	public List<GarType> selectGarTypeList(GarType garType);

	 /**
     * 查询垃圾类型
     * 
     * @return 垃圾类型集合信息
     */
	public List<GarType> selectGarTypeAll();
	
	/**
     * 通过垃圾ID删除垃圾信息
     * 
     * @param garId 垃圾ID
     * @return 结果
     */
	public GarType selectGarTypeById(Long garId);
	
	/**
     * 通过垃圾ID删除垃圾类型信息
     * 
     * @param dictId 垃圾ID
     * @return 结果
     */
    public int deleteGarTypeById(Long garId);
	
	/**
     * 批量删除垃圾类型
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteGarTypeByIds(String[] ids);

    /**
     * 新增垃圾类型信息
     * 
     * @param garType 垃圾类型信息
     * @return 结果
     */
    public int insertGarType(GarType garType);

    /**
     * 修改垃圾类型信息
     * 
     * @param garType 垃圾类型信息
     * @return 结果
     */
    public int updateGarType(GarType garType);

    /**
     * 校验垃圾类型称是否唯一
     * 
     * @param garType 垃圾类型
     * @return 结果
     */
    public GarType checkGarTypeUnique(String garType);
}
