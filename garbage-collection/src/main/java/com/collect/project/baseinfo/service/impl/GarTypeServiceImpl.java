package com.collect.project.baseinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collect.common.constant.UserConstants;
import com.collect.common.core.text.Convert;
import com.collect.common.utils.StringUtils;
import com.collect.project.baseinfo.mapper.IGarTypeMapper;
import com.collect.project.baseinfo.model.GarType;
import com.collect.project.baseinfo.service.IGarTypeService;

/**
 * 垃圾类型 业务层处理
 * 
 * @author ruoyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GarTypeServiceImpl implements IGarTypeService
{
    @Autowired
    private IGarTypeMapper garTypeMapper;

    /**
     * 根据条件分页查询垃圾类型
     * 
     * @param garType 垃圾类型信息
     * @return 垃圾类型集合信息
     */
    @Override
    public List<GarType> selectGarTypeList(GarType garType)
    {
        return garTypeMapper.selectGarTypeList(garType);
    }
    
    /**
     * 查询垃圾类型
     * 
     * @return 垃圾类型集合信息
     */
    @Override
	public List<GarType> selectGarTypeAll()
	{
    	return garTypeMapper.selectGarTypeAll();
	}

    /**
     * 根据垃圾类型ID查询信息
     * 
     * @param garId 垃圾类型ID
     * @return 垃圾类型
     */
    @Override
    public GarType selectGarTypeById(Long garId)
    {
        return garTypeMapper.selectGarTypeById(garId);
    }

    /**
     * 批量删除垃圾类型
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteGarTypeByIds(String ids)
    {
        return garTypeMapper.deleteGarTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存垃圾类型信息
     * 
     * @param garType 垃圾类型信息
     * @return 结果
     */
    @Override
    public int insertGarType(GarType garType)
    {
        return garTypeMapper.insertGarType(garType);
    }

    /**
     * 修改保存垃圾类型信息
     * 
     * @param garType 垃圾类型信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateGarType(GarType garType)
    {
        return garTypeMapper.updateGarType(garType);
    }

    /**
     * 校验垃圾类型是否唯一
     * 
     * @param dict 垃圾类型
     * @return 结果
     */
    @Override
    public String checkGarTypeUnique(GarType garType)
    {
        Long garId = StringUtils.isNull(garType.getGarId()) ? -1L : garType.getGarId();
        GarType gar = garTypeMapper.checkGarTypeUnique(garType.getGarType());
        if (StringUtils.isNotNull(gar) && gar.getGarId().longValue() != garId.longValue())
        {
            return UserConstants.GAR_TYPE_NOT_UNIQUE;
        }
        return UserConstants.GAR_TYPE_UNIQUE;
    }

}
