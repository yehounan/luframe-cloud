package com.quanlehui.servicebase.base.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Desc    : 时间范围参数
 * Date    : 2018-02-01
 *
 * @author : yxy
 */
@Data
public class TimeScopeParam {

    /**
     * 时间范围起始时间
     */
    @NotNull(message = "起始时间不能为空!")
    protected Date startPoint;

    /**
     * 时间范围截止时间
     */
    protected Date endPoint;
}
