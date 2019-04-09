package com.quanlehui.adminservice.mapper;


import com.quanlehui.allserviceapi.admin.domain.AdminRoleResource;
import com.quanlehui.servicebase.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Repository
public interface AdminRoleResourceMapper extends BaseMapper<AdminRoleResource> {

    /**
     * 根据角色id获取角色资源列表
     * @param roleId
     * @return
     */
    List<AdminRoleResource> selectByRoleId(Long roleId);

    /**
     * 根据角色id列表获取角色资源列表
     * @param roleIdList
     * @return
     */
    List<AdminRoleResource> selectByRoleIdList(List<Long> roleIdList);

}