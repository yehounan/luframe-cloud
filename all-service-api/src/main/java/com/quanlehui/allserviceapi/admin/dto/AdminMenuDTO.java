package com.quanlehui.allserviceapi.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * Desc    :
 * @author  : yxy
 * @date    : 2018-02-12
 */
@Data
public class AdminMenuDTO {

    protected Long id;

    protected Date createTime;

    private String name;

    private String resourceUrl;

    private Byte type;

    private Long parentId;

    private Integer sort;
}
