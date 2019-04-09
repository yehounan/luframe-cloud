package com.quanlehui.allserviceapi.admin;


import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Package: com.huanya.data.admin.service.api
 * @Author: SunXiaoYong.Inc
 * @Descripton: 后台管理用户接口类
 * @Date: Create In 2018/7/30 15:54
 * @Jdk: 1.8
 * @Modified By:
 */
public interface AdminUserServiceAPI {

    /**
     * 查询所有后台用户ID和用户名
     * @return 数据列表
     */
    @GetMapping(value = "/feign/user/name/list/all")
    public ExtendVO listAllAdminUserName();

    @PostMapping("/feign/user/getAdminUserByIds")
    ExtendVO getAdminUserByIds(@RequestBody List<Long> ids);

    @GetMapping("/feign/user/getAdminUserIdsByName")
    ExtendVO getAdminUserIdsByName(@RequestParam("name") String name);
}
