package com.collect.project.baseinfo.service;

import java.util.List;

import com.collect.project.baseinfo.model.GarPrice;
import com.collect.project.system.model.User;

/**
 * 垃圾价格 业务层
 * 
 * @author ruoyi
 */
public interface IGarPriceService
{
    /**
     * 根据条件分页查询垃圾价格
     * 
     * @param GarPrice 垃圾价格信息
     * @return 垃圾价格集合信息
     */
    public List<GarPrice> selectGarPriceList(GarPrice garPrice);

    /**
     * 根据垃圾价格ID查询信息
     * 
     * @param priceId 垃圾价格ID
     * @return 垃圾价格
     */
    public GarPrice selectGarPriceById(Long priceId);


    /**
     * 批量删除垃圾价格
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteGarPriceByIds(String ids);

    /**
     * 新增保存垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    public int insertGarPrice(GarPrice garPrice);

    /**
     * 修改保存垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    public int updateGarPrice(GarPrice garPrice);

    /**
     * 校验垃圾名称称是否唯一
     * 
     * @param garPrice 垃圾价格
     * @return 结果
     */
    public String checkGarNameUnique(GarPrice garName);

    /**
     * 导入垃圾价格数据
     * 
     * @param garPriceList 垃圾价格数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importGarPrice(List<GarPrice> garPriceList, Boolean isUpdateSupport, String operName);
}
