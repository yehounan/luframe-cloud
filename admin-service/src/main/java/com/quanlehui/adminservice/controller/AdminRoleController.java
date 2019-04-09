package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminRoleService;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.domain.AdminRole;
import com.quanlehui.allserviceapi.admin.param.AdminRoleUpdateParam;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 后台角色控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@RestController
public class AdminRoleController {

    @Autowired
    AdminRoleService adminRoleService;

    @RecordLog
    @PostMapping(URIConstants.ROLE_INSERT)
    public BaseVO roleInsert(@RequestBody AdminRole adminRole) {
        try {
            String roleName = adminRole.getRoleName();
            String remark = adminRole.getRemark();
            return adminRoleService.roleInsert(roleName, remark);
        } catch (Exception e) {
            log.error("",e);
            return VOUtils.returnBaseVOError(CodeEnum.ERROR);
        }
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RecordLog
    @GetMapping("role/delete")
    public BaseVO roleDelete(@RequestParam("id") Long id) {
        try {
            return adminRoleService.roleDelete(id);
        } catch (Exception e) {
            log.error("",e);
            return VOUtils.returnBaseVOError(CodeEnum.ERROR);
        }
    }

    /**
     * 修改角色
     *
     * @param adminRole{id,remark,roleName}
     * @return
     */
    @RecordLog
    @PostMapping("role/update")
    public BaseVO roleUpdate(@RequestBody AdminRole adminRole) {
        try {
            Long id = adminRole.getId();
            String remark = adminRole.getRemark();
            String roleName = adminRole.getRoleName();
            return adminRoleService.roleUpdate(id, remark, roleName);
        } catch (Exception e) {
            log.error("",e);
            return VOUtils.returnBaseVOError(CodeEnum.ERROR);
        }
    }

    /**
     * 给角色分配权限
     *
     * @param adminRoleUpdateParam
     * @return
     */
    @RecordLog
    @PostMapping(URIConstants.ROLE_UPDATE_AUTHORITY)
    public BaseVO roleUpdateAuthority(@Validated @RequestBody AdminRoleUpdateParam adminRoleUpdateParam) {
        return adminRoleService.roleUpdateAuthority(adminRoleUpdateParam);
    }

    /**
     * 获取角色列表 不分页
     *
     * @return
     */
    @GetMapping(URIConstants.ROLE_LIST)
    public ExtendVO adminRoleList() {
        return adminRoleService.getAdminRoleList();
    }

}
