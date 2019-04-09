package com.quanlehui.adminservice.service;


import com.quanlehui.allserviceapi.admin.param.AdminRoleUpdateParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminRoleService {

    /**
     * 新增角色
     * @param roleName
     * @param remark
     * @return
     */
    BaseVO roleInsert(String roleName, String remark);


    /**
     * 删除角色
     * @param id
     * @return
     */
    BaseVO roleDelete(Long id);

    /**
     * 修改角色
     * @param id
     * @param remark
     * @param roleName
     * @return
     */
    BaseVO roleUpdate(Long id, String remark, String roleName) ;

    /**
     * 角色权限更新
     * @param adminRoleUpdateParam
     * @return
     */
    BaseVO roleUpdateAuthority(AdminRoleUpdateParam adminRoleUpdateParam);


    /**
     * 角色列表不分页
     * @return
     */
    ExtendVO getAdminRoleList();
}
