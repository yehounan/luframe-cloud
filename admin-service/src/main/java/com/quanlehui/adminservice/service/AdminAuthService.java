package com.quanlehui.adminservice.service;


import com.quanlehui.servicebase.base.vo.ExtendVO;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminAuthService {

    /**
     * jwt是否拥有对url操作的权限的判断
     *
     * @param jwt
     * @param url
     * @return
     */
    ExtendVO checkAuthority(String jwt, String url);

}
