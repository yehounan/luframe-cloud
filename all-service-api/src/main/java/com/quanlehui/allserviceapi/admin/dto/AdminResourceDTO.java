package com.quanlehui.allserviceapi.admin.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Desc    :
 * @author  : yxy
 * @date    : 2018-02-12
 */
@Data
public class AdminResourceDTO {

    protected Long id;

    protected Date createTime;

    private String name;

    private String resourceUrl;

    private String jumpUrl;

    private Byte type;

    private Long parentId;

    private Integer sort;

    private Boolean right; //是否拥有权限

    private List<AdminResourceDTO> subResourceList;
}
