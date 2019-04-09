package com.quanlehui.allserviceapi.admin.param;

import lombok.Data;

/**
 * Created by hmb on 2018/6/7.
 * @author hmb
 */
@Data
public class AdminIpWhitelistConfigParam {

    private String ip;

    private String creator;

    private Long creatorId;

    private String isWhitelist="yes";
}
