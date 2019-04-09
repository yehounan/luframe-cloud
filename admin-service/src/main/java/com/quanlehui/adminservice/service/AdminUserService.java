package com.quanlehui.adminservice.service;



import com.quanlehui.allserviceapi.admin.dto.AdminUserDTO;
import com.quanlehui.allserviceapi.admin.param.AdminUserInsertParam;
import com.quanlehui.allserviceapi.admin.param.AdminUserUpdateParam;
import com.quanlehui.servicebase.base.param.PageParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminUserService {

    /**
     * 获取管理员用户列表
     * @param pageParam
     * @return
     */
    ExtendVO getAdminUserList(PageParam pageParam);

    /**
     * 根据id列表获取管理员用户
     * @param ids
     * @return
     */
    ExtendVO getAdminUserByIds(List<Long> ids);

    /**
     * 根据用户名称获取管理员用户
     * @param name
     * @return
     */
    ExtendVO getAdminUserIdsByName(String name);

    /**
     * 获取所有管理员用户
     *
     * @return
     */
    ExtendVO getAdminUsernameAll();

    /**
     * 新增用户
     *
     * @param adminUserInsertParam
     * @return
     */
    BaseVO adminUserInsert(AdminUserInsertParam adminUserInsertParam);

    /**
     * 更新用户
     * @param adminUserUpdateParam
     * @return
     */
    BaseVO adminUserUpdate(AdminUserUpdateParam adminUserUpdateParam);

    /**
     * 删除用户
     * @param id
     * @return
     */
    BaseVO adminUserDelete(Long id);

    /**
     * 重置密码
     * @param id
     * @param pwd
     * @return
     */
    BaseVO adminUserResetPassword(Long id, String pwd);


    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    AdminUserDTO getAdminUser(Long userId);

}
