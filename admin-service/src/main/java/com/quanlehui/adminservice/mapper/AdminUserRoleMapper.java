package com.quanlehui.adminservice.mapper;


import com.quanlehui.allserviceapi.admin.domain.AdminUserRole;
import com.quanlehui.servicebase.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Repository
public interface AdminUserRoleMapper extends BaseMapper<AdminUserRole> {

    /**
     * 根据用户id获取用户角色列表
     * @param userId
     * @return
     */
    List<AdminUserRole> selectByUserId(Long userId);

    /**
     * 根据用户id获取用户角色详细信息
     * @param userId
     * @return
     */
    List<Map> getUserRoleName(@Param("userId") Long userId);


    /**
     * 判断用户是不是超级管理员
     * @param userId
     * @return
     */
   int checkAdmin(@Param("userId") Long userId);
}