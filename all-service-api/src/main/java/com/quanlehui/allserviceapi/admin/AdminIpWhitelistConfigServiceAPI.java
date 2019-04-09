package com.quanlehui.allserviceapi.admin;


import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ip控制设置
 * Created by hmb on 2018/6/9.
 */
public interface AdminIpWhitelistConfigServiceAPI {


    @GetMapping(URIConstants.AdminIpWhitelistConfigURL.FEIGN_LIST)
    ExtendVO list();

}

