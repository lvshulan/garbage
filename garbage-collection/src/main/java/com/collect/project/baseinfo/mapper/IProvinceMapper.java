package com.collect.project.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.baseinfo.model.Province;

/**
 * 省份表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface IProvinceMapper 
{
	 /**
     * 根据条件分页查询省份
     * 
     * @param province 省份信息
     * @return 省份集合信息
     */
	//public List<Province> selectProvinceList(Province province);

	/**
     * 通过省份ID查询省份信息
     * 
     * @param provinceId 省份ID
     * @return 结果
     */
	public Province selectProvinceById(Long provinceId);
	
	/**
     * 通过省份名称查询省份信息
     * 
     * @param garName 省份名称
     * @return 结果
     */
    public Province selectProvinceByName(String provinceName);
	
    /**
     * 通过省份ID删除省份信息
     * 
     * @param dictId 省份ID
     * @return 结果
     */
    public int deleteProvinceById(Long provinceId);
    
	/**
     * 批量删除省份
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteProvinceByIds(String[] ids);

    /**
     * 新增省份信息
     * 
     * @param province 省份信息
     * @return 结果
     */
    public int insertProvince(Province province);

    /**
     * 修改省份信息
     * 
     * @param province 省份信息
     * @return 结果
     */
    public int updateProvince(Province province);

    /**
     * 校验省份名称是否唯一
     * 
     * @param province 省份
     * @return 结果
     */
    public Province checkprovinceNameUnique(String provinceName);
}
