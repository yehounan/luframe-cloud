package com.quanlehui.adminservice.controller.feign;


import com.quanlehui.adminservice.service.AdminUserService;
import com.quanlehui.allserviceapi.admin.AdminUserServiceAPI;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 后台用户feign控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
public class AdminUserServiceAPIController implements AdminUserServiceAPI {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 查询所有后台用户ID和用户名
     *
     * @return 数据列表
     */
    @Override
    public ExtendVO listAllAdminUserName() {
        return adminUserService.getAdminUsernameAll();


    }

    @Override
    public ExtendVO getAdminUserByIds(@RequestBody List<Long> ids) {
        return adminUserService.getAdminUserByIds(ids);
    }


    @Override
    public ExtendVO getAdminUserIdsByName(@RequestParam("name") String name) {
        return adminUserService.getAdminUserIdsByName(name);
    }
}
