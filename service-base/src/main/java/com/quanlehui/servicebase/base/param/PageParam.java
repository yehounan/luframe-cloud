package com.quanlehui.servicebase.base.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Desc    : 分页请求参数
 * Date    : 2018-01-09
 *
 * @author : yxy
 */
@Data
public class PageParam {

    /**
     * 第几页，从1开始
     */
    @NotNull(message = "页码不能为空!")
    @Min(value = 1)
    protected Integer pageNum;

    /**
     * 页尺寸
     */
    @NotNull(message = "页尺寸不能为空!")
    @Min(1)
    @Max(500)
    protected Integer pageSize;

    /**
     * 排序 例如：id desc
     */
    protected String orderBy;

}
