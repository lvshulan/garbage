package com.collect.project.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.collect.project.system.model.OperLog;

/**
 * 操作日志 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface IOperLogMapper
{
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(OperLog operLog);

    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<OperLog> selectOperLogList(OperLog operLog);
    
    /**
     * 批量删除系统操作日志
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteOperLogByIds(String[] ids);
    
    /**
     * 查询操作日志详细
     * 
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public OperLog selectOperLogById(Long operId);
    
    /**
     * 清空操作日志
     */
    public void cleanOperLog();
}
