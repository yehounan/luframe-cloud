package com.quanlehui.allserviceapi.admin.param;


import com.quanlehui.allserviceapi.admin.dto.AdminResourceDTO;
import lombok.Data;

import java.util.List;

/**
 * Desc    : 角色更新参数
 *
 * @author : yxy
 * @date : 2018-02-12
 */
@Data
public class AdminRoleUpdateParam {

    private Long id;


    private List<AdminResourceDTO> resourceList;
}
