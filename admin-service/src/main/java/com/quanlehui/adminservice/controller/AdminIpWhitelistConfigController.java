package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminIpWhitelistConfigService;
import com.quanlehui.adminservice.util.AdminLoginUserUtils;
import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigPageParam;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigParam;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Description: 白名单控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
@Slf4j
public class AdminIpWhitelistConfigController {

    @Autowired
    private AdminIpWhitelistConfigService aminIpWhitelistConfigService;

    @RecordLog
    @PostMapping(URIConstants.AdminIpWhitelistConfigURL.INSERT)
    public BaseVO insert(@RequestBody AdminIpWhitelistConfigParam param, HttpServletRequest request){
        if(param!=null){
            param.setCreatorId(AdminLoginUserUtils.getAdminUserId(request));
            param.setCreator(AdminLoginUserUtils.getAdminUsername(request));
        }
        return aminIpWhitelistConfigService.insert(param);
    }

    @RecordLog
    @GetMapping(URIConstants.AdminIpWhitelistConfigURL.DELETE)
    public BaseVO delete(Long id){
        return aminIpWhitelistConfigService.delete(id);
    }


    @PostMapping(URIConstants.AdminIpWhitelistConfigURL.PAGE)
    public ExtendVO findByPage(@RequestBody AdminIpWhitelistConfigPageParam param){
        return aminIpWhitelistConfigService.findByPage(param);
    }

    @GetMapping("/ipwhitelist/ips")
    public ExtendVO getIps(){
        List<String> list=aminIpWhitelistConfigService.getIps();
        return VOUtils.returnExtendVOSuccess(list);
    }
}
