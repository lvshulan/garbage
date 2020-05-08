package com.collect.project.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.baseinfo.model.City;

/**
 * 城市表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface ICityMapper 
{
	 /**
     * 根据条件分页查询城市
     * 
     * @param city 城市信息
     * @return 城市集合信息
     */
	public List<City> selectCityList(City city);

	 /**
     * 根据省份ID查询城市
     * 
     * @param privinceId 省份ID
     * @return 城市集合信息
     */
	public List<City> selectCityListByPrivinceId(Long privinceId);
	
	/**
     * 通过城市ID查询城市信息
     * 
     * @param cityId 城市ID
     * @return 结果
     */
	public City selectCityById(Long cityId);
	
	/**
     * 通过城市名称查询城市信息
     * 
     * @param garName 城市名称
     * @return 结果
     */
    public City selectCityByName(String cityName);
	
    /**
     * 通过城市ID删除城市信息
     * 
     * @param dictId 城市ID
     * @return 结果
     */
    public int deleteCityById(Long cityId);
    
	/**
     * 批量删除城市
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteCityByIds(String[] ids);

    /**
     * 新增城市信息
     * 
     * @param city 城市信息
     * @return 结果
     */
    public int insertCity(City city);

    /**
     * 修改城市信息
     * 
     * @param city 城市信息
     * @return 结果
     */
    public int updateCity(City city);

    /**
     * 校验城市名称是否唯一
     * 
     * @param city 城市
     * @return 结果
     */
    public City checkcityNameUnique(String cityName);
}
