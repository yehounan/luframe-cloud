package com.quanlehui.adminservice.controller.feign;


import com.quanlehui.adminservice.service.AdminIpWhitelistConfigService;
import com.quanlehui.allserviceapi.admin.AdminIpWhitelistConfigServiceAPI;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 后台白名单feign控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
public class AdminIpWhitelistConfigFeignController implements AdminIpWhitelistConfigServiceAPI {

    @Autowired
    private AdminIpWhitelistConfigService adminIpWhitelistConfigService;

    @Override
    public ExtendVO list() {
        try {
            return VOUtils.returnExtendVOSuccess(adminIpWhitelistConfigService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return VOUtils.returnExtendVOError(CodeEnum.ERROR, null);
        }
    }
}
