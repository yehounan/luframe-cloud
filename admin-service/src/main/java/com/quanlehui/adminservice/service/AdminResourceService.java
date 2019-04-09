package com.quanlehui.adminservice.service;


import com.quanlehui.allserviceapi.admin.param.AdminResourceInsertParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminResourceService {

    /**
     * 根据角色ID获取资源列表
     * @param roleId
     * @return
     */
    ExtendVO getResourceList(Long roleId);

    /**
     * 获取菜单列表
     * @param userId
     * @return
     */
    ExtendVO getMenuList(Long userId);

    /**
     * 新增资源
     * @param adminResourceInsertParam
     * @return
     */
    BaseVO insertResource(AdminResourceInsertParam adminResourceInsertParam);


}
