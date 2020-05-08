package com.collect.project.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.baseinfo.model.Area;

/**
 * 区域表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface IAreaMapper 
{
	 /**
     * 根据条件分页查询区域
     * 
     * @param area 区域信息
     * @return 区域集合信息
     */
	public List<Area> selectAreaList(Area area);

	 /**
     * 根据城市ID查询区域
     * 
     * @param cityId 城市ID
     * @return 区域集合信息
     */
	public List<Area> selectAreaListByCityId(Long cityId);
	
	/**
     * 通过区域ID查询区域信息
     * 
     * @param areaId 区域ID
     * @return 结果
     */
	public Area selectAreaById(Long areaId);
	
	/**
     * 通过区域名称查询区域信息
     * 
     * @param garName 区域名称
     * @return 结果
     */
    public Area selectAreaByName(String areaName);
	
    /**
     * 通过区域ID删除区域信息
     * 
     * @param dictId 区域ID
     * @return 结果
     */
    public int deleteAreaById(Long areaId);
    
	/**
     * 批量删除区域
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteAreaByIds(String[] ids);

    /**
     * 新增区域信息
     * 
     * @param area 区域信息
     * @return 结果
     */
    public int insertArea(Area area);

    /**
     * 修改区域信息
     * 
     * @param area 区域信息
     * @return 结果
     */
    public int updateArea(Area area);

    /**
     * 校验区域名称是否唯一
     * 
     * @param areaName 区域名称
     * @return 结果
     */
    public Area checkareaNameUnique(String areaName);
}
