package com.quanlehui.adminservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.quanlehui.adminservice.mapper.AdminUserMapper;
import com.quanlehui.adminservice.mapper.AdminUserRoleMapper;
import com.quanlehui.adminservice.service.AdminUserService;
import com.quanlehui.allserviceapi.admin.domain.AdminUser;
import com.quanlehui.allserviceapi.admin.domain.AdminUserRole;
import com.quanlehui.allserviceapi.admin.dto.AdminUserDTO;
import com.quanlehui.allserviceapi.admin.param.AdminUserInsertParam;
import com.quanlehui.allserviceapi.admin.param.AdminUserUpdateParam;
import com.quanlehui.servicebase.base.param.PageParam;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @Description: 后台用户service
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

    /**
     * 系统用户管理分页查询
     *
     * @param pageParam
     * @return
     */
    @Override
    public ExtendVO getAdminUserList(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        List<AdminUserDTO> list = adminUserMapper.selectUserList();
        //根据用户id获取所属角色列表
        List<Map> role = null;
        for (int i = 0; i < list.size(); i++) {
            //根据用户id获取用户角色
            role = adminUserRoleMapper.getUserRoleName(list.get(i).getId());
            list.get(i).setRole(role);
        }
        PageInfo<AdminUserDTO> pageInfo = new PageInfo<>(list);
        return VOUtils.returnExtendVOFillPageInfo(pageInfo);
    }

    @Override
    public ExtendVO getAdminUserByIds(List<Long> ids) {
        List<AdminUser> list = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(ids)) {
            Example example = new Example(AdminUser.class);
            example.and().andIn("id", ids);
            list = adminUserMapper.selectByExample(example);
        }
        return VOUtils.returnExtendVOSuccess(list);
    }

    @Override
    public ExtendVO getAdminUserIdsByName(String name) {
        List<Long> ids = Lists.newArrayList();
        Example example = new Example(AdminUser.class);
        example.and().andLike("username", "%" + name + "%");
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        adminUsers.stream().forEach(s -> {
            ids.add(s.getId());
        });
        return VOUtils.returnExtendVOSuccess(ids);
    }

    /**
     * 获取所有系统用户用户名信息
     *
     * @return
     */
    @Override
    public ExtendVO getAdminUsernameAll() {
        List<AdminUserDTO> list = adminUserMapper.selectUserList();
        Map<Long, String> map = new HashMap<>(16);
        for (AdminUserDTO dto : list) {
            map.put(dto.getId(), dto.getUsername());
        }
        return VOUtils.returnExtendVOSuccess(map);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public AdminUserDTO getAdminUser(Long userId) {
        AdminUserDTO user = adminUserMapper.getAdminUser(userId);
        List<Map> role = adminUserRoleMapper.getUserRoleName(user.getId());
        user.setRole(role);
        user.setIsAdmin(false);
        for (Map map : role) {
            Object obj = map.get("isAdmin");
            if (obj != null) {
                String isAdmin = obj.toString();
                if ("true".equals(isAdmin) || "1".equals(isAdmin)) {
                    user.setIsAdmin(true);
                    break;
                }
            }
        }

        return user;
    }


    /**
     * 新增用户
     *
     * @param adminUserInsertParam
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Throwable.class)
    public BaseVO adminUserInsert(AdminUserInsertParam adminUserInsertParam) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserInsertParam, adminUser);
        adminUser.setCreateTime(new Date());
        //新增用户
        try {
            adminUserMapper.insertUseGeneratedKeys(adminUser);
        } catch (Exception e) {
            log.error("", e);
            return VOUtils.returnBaseVOError(CodeEnum.ADMIN_USER_ALREADY_EXISTS);
        }
        //关联角色
        String[] roleId = adminUserInsertParam.getRoleId().split(",");
        setUserRole(roleId, adminUser.getId());
        return VOUtils.returnBaseVOSuccess();
    }

    /**
     * 修改用户信息
     *
     * @param adminUserUpdateParam
     * @return
     */
    @Override
    public BaseVO adminUserUpdate(AdminUserUpdateParam adminUserUpdateParam) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserUpdateParam, adminUser);
        //修改用户信息
        adminUserMapper.updateByPrimaryKeySelective(adminUser);
        //删除用户之前的所有角色
        AdminUserRole userRole = new AdminUserRole();
        userRole.setUserId(adminUser.getId());
        adminUserRoleMapper.delete(userRole);
        //从新分配角色
        String[] roleId = adminUserUpdateParam.getRoleId().split(",");
        setUserRole(roleId, adminUser.getId());
        return VOUtils.returnBaseVOSuccess();
    }


    /**
     * 给用户分配指定角色
     *
     * @param roleId
     * @param userId
     */
    private void setUserRole(String[] roleId, Long userId) {
        List<AdminUserRole> saveParam = new ArrayList<>();
        for (int i = 0; i < roleId.length; i++) {
            AdminUserRole adminUserRole = new AdminUserRole();
            adminUserRole.setUserId(userId);
            adminUserRole.setRoleId(Long.parseLong(roleId[i].toString()));
            adminUserRole.setCreateTime(new Date());
            saveParam.add(adminUserRole);
        }
        adminUserRoleMapper.insertList(saveParam);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public BaseVO adminUserDelete(Long id) {
        adminUserMapper.deleteByPrimaryKey(id);
        Example example = new Example(AdminUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", id);
        adminUserRoleMapper.deleteByExample(example);
        return VOUtils.returnBaseVOSuccess();
    }

    /**
     * 修改，密码
     *
     * @param id
     * @param pwd
     * @return
     */
    @Override
    public BaseVO adminUserResetPassword(Long id, String pwd) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(id);
        adminUser.setPassword(pwd);
        adminUserMapper.updateByPrimaryKeySelective(adminUser);
        return VOUtils.returnBaseVOSuccess();
    }

}
