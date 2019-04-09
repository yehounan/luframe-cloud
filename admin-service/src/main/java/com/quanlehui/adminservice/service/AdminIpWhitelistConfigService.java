package com.quanlehui.adminservice.service;



import com.quanlehui.allserviceapi.admin.domain.AdminIpWhitelistConfig;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigPageParam;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigParam;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.ExtendVO;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminIpWhitelistConfigService {

    /**
     * 添加ip白名单
     *
     * @param param
     * @return
     */
    BaseVO insert(AdminIpWhitelistConfigParam param);

    /**
     * 删除ip白名单
     *
     * @param id
     * @return
     */
    BaseVO delete(Long id);

    /**
     * 分页查询白名单信息
     *
     * @param param
     * @return
     */
    ExtendVO findByPage(AdminIpWhitelistConfigPageParam param);

    /**
     * 白名单列表
     *
     * @return
     */
    List<AdminIpWhitelistConfig> findAll();

    /**
     * 获取ip列表
     *
     * @return
     */
    List<String> getIps();

}
