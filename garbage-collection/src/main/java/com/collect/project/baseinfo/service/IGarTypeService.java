package com.collect.project.baseinfo.service;

import java.util.List;

import com.collect.project.baseinfo.model.GarType;

/**
 * 垃圾 业务层
 * 
 * @author ruoyi
 */
public interface IGarTypeService
{
    /**
     * 根据条件分页查询垃圾类型
     * 
     * @param garType 垃圾类型信息
     * @return 垃圾类型集合信息
     */
    public List<GarType> selectGarTypeList(GarType gGarType);
    
    /**
     * 查询垃圾类型
     * 
     * @return 垃圾类型集合信息
     */
	public List<GarType> selectGarTypeAll();

    /**
     * 根据垃圾类型ID查询信息
     * 
     * @param garId 垃圾类型ID
     * @return 垃圾类型
     */
    public GarType selectGarTypeById(Long garId);


    /**
     * 批量删除垃圾类型
     * 
     * @param ids 需要删除的数据
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteGarTypeByIds(String ids);

    /**
     * 新增保存垃圾类型信息
     * 
     * @param garType 垃圾类型信息
     * @return 结果
     */
    public int insertGarType(GarType garType);

    /**
     * 修改保存垃圾类型信息
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
    public String checkGarTypeUnique(GarType garType);

}
