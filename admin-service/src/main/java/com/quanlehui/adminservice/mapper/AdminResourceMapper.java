package com.quanlehui.adminservice.mapper;


import com.quanlehui.allserviceapi.admin.domain.AdminResource;
import com.quanlehui.servicebase.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Repository
public interface AdminResourceMapper extends BaseMapper<AdminResource> {

    /**
     * 根据资源url获取资源信息
     * @param resourceUrl
     * @return
     */
    AdminResource selectByResourceUrl(String resourceUrl);

    /**
     * 根据父id获取菜单列表
     * @param parentId
     * @return
     */
    List<AdminResource> selectMenuByParentId(Long parentId);

    /**
     * 获顺序取菜单列表
     * @return
     */
    List<AdminResource> selectAllOrderBySort();
}