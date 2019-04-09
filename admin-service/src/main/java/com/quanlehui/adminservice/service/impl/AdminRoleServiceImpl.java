package com.quanlehui.adminservice.service.impl;


import com.quanlehui.adminservice.mapper.AdminRoleMapper;
import com.quanlehui.adminservice.mapper.AdminRoleResourceMapper;
import com.quanlehui.adminservice.mapper.AdminUserRoleMapper;
import com.quanlehui.adminservice.service.AdminRoleService;
import com.quanlehui.allserviceapi.admin.domain.AdminRole;
import com.quanlehui.allserviceapi.admin.domain.AdminRoleResource;
import com.quanlehui.allserviceapi.admin.domain.AdminUserRole;
import com.quanlehui.allserviceapi.admin.dto.AdminResourceDTO;
import com.quanlehui.allserviceapi.admin.param.AdminRoleUpdateParam;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 角色service
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    private AdminRoleResourceMapper adminRoleResourceMapper;

    /**
     * 新增角色
     *
     * @param roleName
     * @return
     */
    @Override
    public BaseVO roleInsert(String roleName, String remark) {
        AdminRole adminRole = new AdminRole();
        adminRole.setCreateTime(new Date());
        adminRole.setRoleName(roleName);
        adminRole.setRemark(remark);
        adminRole.setIsAdmin("0");
        adminRoleMapper.insert(adminRole);
        return VOUtils.returnBaseVOSuccess();
    }


    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @Override
    public BaseVO roleDelete(Long id) {
        //判定乖角色是否有关联用户
        AdminUserRole adminUserRole = new AdminUserRole();
        adminUserRole.setRoleId(id);
        List<AdminUserRole> list = adminUserRoleMapper.select(adminUserRole);
        if (list.size() > 0) {
            return VOUtils.returnBaseVODynamic(CodeEnum.ERROR, "该角色还关联了用户，不能删除！");
        }
        adminRoleMapper.deleteByPrimaryKey(id);
        return VOUtils.returnBaseVOSuccess();
    }


    /**
     * 修改角色
     *
     * @param id
     * @return
     */
    @Override
    public BaseVO roleUpdate(Long id, String remark, String roleName) {
        AdminRole role = new AdminRole();
        role.setId(id);
        role.setRoleName(roleName);
        role.setRemark(remark);
        adminRoleMapper.updateByPrimaryKeySelective(role);
        return VOUtils.returnBaseVOSuccess();
    }


    /**
     * 获取角色列表不分页
     *
     * @return
     */
    @Override
    public ExtendVO getAdminRoleList() {
        List<AdminRole> roles = adminRoleMapper.selectAll();
        return VOUtils.returnExtendVOSuccess(roles);
    }


    /**
     * 修改角色权限
     *
     * @param adminRoleUpdateParam
     * @return
     */
    @Override
    public BaseVO roleUpdateAuthority(AdminRoleUpdateParam adminRoleUpdateParam) {
        AdminRole adminRole = new AdminRole();
        adminRole.setId(adminRoleUpdateParam.getId());
        List<AdminResourceDTO> dtoList = adminRoleUpdateParam.getResourceList();
        List<AdminRoleResource> roleResourceList = new ArrayList<>();
        for (AdminResourceDTO dto : dtoList) {
            if (dto.getRight()) {
                AdminRoleResource adminRoleResource = new AdminRoleResource();
                adminRoleResource.setRoleId(adminRole.getId());
                adminRoleResource.setResourceId(dto.getId());
                adminRoleResource.setCreateTime(new Date());
                roleResourceList.add(adminRoleResource);
                List<AdminResourceDTO> subList = dto.getSubResourceList();
                if (subList != null) {
                    for (AdminResourceDTO sub : subList) {
                        if (sub.getRight()) {
                            AdminRoleResource subAdminRoleResource = new AdminRoleResource();
                            subAdminRoleResource.setRoleId(adminRole.getId());
                            subAdminRoleResource.setResourceId(sub.getId());
                            subAdminRoleResource.setCreateTime(new Date());
                            roleResourceList.add(subAdminRoleResource);
                        }
                    }
                }
            }
        }
        Example example = new Example(AdminRoleResource.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", adminRole.getId());
        adminRoleResourceMapper.deleteByExample(example);
        adminRoleResourceMapper.insertList(roleResourceList);
        return VOUtils.returnBaseVOSuccess();
    }

}
