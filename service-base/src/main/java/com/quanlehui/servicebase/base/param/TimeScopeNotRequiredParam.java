package com.quanlehui.servicebase.base.param;

import lombok.Data;

import java.util.Date;

/**
 * Desc    : 时间范围(非必需)参数
 * Date    : 2018-02-01
 *
 * @author : yxy
 */
@Data
public class TimeScopeNotRequiredParam extends PageParam {

    /**
     * 时间范围起始时间
     */
    protected Date startPoint;

    /**
     * 时间范围截止时间
     */
    protected Date endPoint;
}
