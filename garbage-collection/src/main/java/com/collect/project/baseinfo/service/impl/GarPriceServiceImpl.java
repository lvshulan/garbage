package com.collect.project.baseinfo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collect.common.constant.UserConstants;
import com.collect.common.core.text.Convert;
import com.collect.common.exception.BusinessException;
import com.collect.common.utils.StringUtils;
import com.collect.common.utils.security.Md5Utils;
import com.collect.project.baseinfo.mapper.IGarPriceMapper;
import com.collect.project.baseinfo.model.GarPrice;
import com.collect.project.baseinfo.service.IGarPriceService;
import com.collect.project.system.model.User;

/**
 * 垃圾价格 业务层处理
 * 
 * @author ruoyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GarPriceServiceImpl implements IGarPriceService
{
	private static final Logger log = LoggerFactory.getLogger(GarPriceServiceImpl.class);
	
    @Autowired
    private IGarPriceMapper garPriceMapper;

    /**
     * 根据条件分页查询垃圾价格
     * 
     * @param garPrice 垃圾价格信息
     * @return 垃圾价格集合信息
     */
    @Override
    public List<GarPrice> selectGarPriceList(GarPrice garPrice)
    {
        return garPriceMapper.selectGarPriceList(garPrice);
    }

    /**
     * 根据垃圾价格ID查询信息
     * 
     * @param priceId 垃圾价格ID
     * @return 垃圾价格
     */
    @Override
    public GarPrice selectGarPriceById(Long garId)
    {
        return garPriceMapper.selectGarPriceById(garId);
    }

    /**
     * 批量删除垃圾价格
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteGarPriceByIds(String ids)
    {
        return garPriceMapper.deleteGarPriceByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    @Override
    public int insertGarPrice(GarPrice garPrice)
    {
        return garPriceMapper.insertGarPrice(garPrice);
    }

    /**
     * 修改保存垃圾价格信息
     * 
     * @param garPrice 垃圾价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateGarPrice(GarPrice garPrice)
    {
        return garPriceMapper.updateGarPrice(garPrice);
    }

    /**
     * 校验垃圾名称称是否唯一
     * 
     * @param garPrice 垃圾价格
     * @return 结果
     */
    @Override
    public String checkGarNameUnique(GarPrice garPrice)
    {
        Long priceId = StringUtils.isNull(garPrice.getPriceId()) ? -1L : garPrice.getPriceId();
        GarPrice gar = garPriceMapper.checkGarNameUnique(garPrice.getGarName());
        if (StringUtils.isNotNull(gar) && gar.getPriceId().longValue() != priceId.longValue())
        {
            return UserConstants.GAR_PRICE_NOT_UNIQUE;
        }
        return UserConstants.GAR_PRICE_UNIQUE;
    }

    /**
     * 导入垃圾价格数据
     * 
     * @param garPriceList 垃圾价格数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importGarPrice(List<GarPrice> garPriceList, Boolean isUpdateSupport, String operName)
    {
    	if (StringUtils.isNull(garPriceList) || garPriceList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //String password = configService.selectConfigByKey("sys.user.initPassword");
        for (GarPrice garPrice : garPriceList)
        {
            try
            {
                // 验证是否存在这个垃圾名
            	GarPrice gar = garPriceMapper.selectGarPriceByGarName(garPrice.getGarName());
                if (StringUtils.isNull(gar))
                {
                	garPrice.setCreateBy(operName);
                    this.insertGarPrice(garPrice);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + garPrice.getGarName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                	garPrice.setUpdateBy(operName);
                    this.updateGarPrice(garPrice);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + garPrice.getGarName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + garPrice.getGarName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + garPrice.getGarName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
    
}
