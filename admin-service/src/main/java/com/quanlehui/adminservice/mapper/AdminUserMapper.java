package com.quanlehui.adminservice.mapper;


import com.quanlehui.allserviceapi.admin.domain.AdminUser;
import com.quanlehui.allserviceapi.admin.dto.AdminUserDTO;
import com.quanlehui.servicebase.base.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Repository
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    /**
     * 根据用户名称获取管理员用户
     * @param username
     * @return
     */
    AdminUser selectByUsername(String username);

    /**
     * 根据用户id和用户名获取管理员用户
     * @param id
     * @param username
     * @return
     */
    AdminUser selectByIdAndUsername(@Param("id") Long id, @Param("username") String username);

    /**
     * 获取所有管理员用户列表
     * @return
     */
    List<AdminUserDTO> selectUserList();

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    AdminUserDTO  getAdminUser(@Param("userId") Long userId);
}