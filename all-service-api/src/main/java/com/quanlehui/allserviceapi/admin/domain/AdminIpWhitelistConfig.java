package com.quanlehui.allserviceapi.admin.domain;


import com.quanlehui.servicebase.base.domain.BaseDomain;
import lombok.Data;

/**
 * Description IP白名单表数据库对象
 *
 * @author yxy
 * @date 2018/12/12
 */
@Data
public class AdminIpWhitelistConfig extends BaseDomain {

    private String ipAddr;

    private String ipRegion;

    private String creator;

    private Long creatorId;

    private String isWhitelist="yes";

}
