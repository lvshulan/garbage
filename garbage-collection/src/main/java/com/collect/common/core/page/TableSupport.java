package com.collect.common.core.page;

import com.collect.common.constant.Constants;
import com.collect.common.utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @author ruoyi
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageModel getPageModel()
    {
        PageModel PageModel = new PageModel();
        PageModel.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        PageModel.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        PageModel.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        PageModel.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return PageModel;
    }

    public static PageModel buildPageRequest()
    {
        return getPageModel();
    }
}
