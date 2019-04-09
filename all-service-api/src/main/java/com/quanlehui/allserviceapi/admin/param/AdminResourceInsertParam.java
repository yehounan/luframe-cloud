package com.quanlehui.allserviceapi.admin.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Desc    : 资源插入参数类
 * @date    : 2018-01-27
 *
 * @author : yxy
 */
@Data
public class AdminResourceInsertParam {

    @NotNull(message = "资源名称不能为空！")
    private String name;

    @NotNull(message = "资源链接不能为空！")
    private String resourceUrl;

    @NotNull(message = "资源类型不能为空！")
    @Min(value = 1,message = "资源类型只能大于等于1,小于等于2")
    @Max(value = 2,message = "资源类型只能大于等于1,小于等于2")
    private Byte type;

    @NotNull(message = "父资源ID不能为空！")
    @Min(value = 0,message = "父资源ID大于等于0")
    private Long parentId;

    private Integer sort;
}
