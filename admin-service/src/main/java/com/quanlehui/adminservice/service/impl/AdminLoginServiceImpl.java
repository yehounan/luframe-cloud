package com.quanlehui.adminservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import com.quanlehui.adminservice.mapper.AdminUserMapper;
import com.quanlehui.adminservice.mapper.AdminUserOperateLogMapper;
import com.quanlehui.adminservice.service.AdminIpWhitelistConfigService;
import com.quanlehui.adminservice.service.AdminLoginService;
import com.quanlehui.adminservice.service.AdminUserService;
import com.quanlehui.adminservice.util.AdminLoginUserUtils;
import com.quanlehui.allserviceapi.admin.constant.Constants;
import com.quanlehui.allserviceapi.admin.domain.AdminIpWhitelistConfig;
import com.quanlehui.allserviceapi.admin.domain.AdminUser;
import com.quanlehui.allserviceapi.admin.dto.AdminUserMyTokenDTO;
import com.quanlehui.allserviceapi.admin.dto.AdminUserOperateLogDTO;
import com.quanlehui.allserviceapi.admin.dto.AdminUserPayloadDTO;
import com.quanlehui.allserviceapi.admin.param.AdminLoginParam;
import com.quanlehui.allserviceapi.admin.param.AdminOperateLogQueryParam;
import com.quanlehui.servicebase.base.cache.RedisCache;
import com.quanlehui.servicebase.base.constant.RedisKeyConstants;
import com.quanlehui.servicebase.base.util.IpUtil;
import com.quanlehui.servicebase.base.util.JwtUtils;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 登录service
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AdminUserOperateLogMapper adminUserOperateLogMapper;

    @Autowired
    private AdminIpWhitelistConfigService adminIpWhitelistConfigService;


    @Override
    public ExtendVO getTokenByAdminUserPassword(AdminLoginParam adminLoginParam, HttpServletRequest httpServletRequest) {
        String ip = IpUtil.getIpAddr(httpServletRequest);
        log.info("登录Ip：" + ip);
        if (Strings.isNullOrEmpty(ip)) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IP_NOT_EXISTS, null);
        }
        List<AdminIpWhitelistConfig> ips = adminIpWhitelistConfigService.findAll();
        if (ips.size() == 0) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IP_IS_NOT_WHITELIST, null);
        }
        List<String> ipWhiteLists = Lists.newArrayList();
        List<String> ipBlackLists = Lists.newArrayList();
        String yesValue = "yes";
        ips.forEach(s -> {
            if (yesValue.equals(s.getIsWhitelist())) {
                ipWhiteLists.add(s.getIpAddr());
            } else {
                ipBlackLists.add(s.getIpAddr());
            }
        });
        if (ipBlackLists.contains(ip)) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IP_IS_NOT_WHITELIST, null);
        }
        if (!ipWhiteLists.contains(ip)) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IP_IS_NOT_WHITELIST, null);
        }

        String cacheCode = redisCache.getCacheValue(RedisKeyConstants.USER_IMAGE_CDOE + adminLoginParam.getImgCodeId(), new RedisCache.RedisCacheValueNotFound<String>() {
            @Override
            public String getValue() {
                return null;
            }
        });
        if (cacheCode == null) {
            // 返回异常
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IMAGE_CODE_EXPIRED, null);
        }
        if (!cacheCode.toUpperCase().equals(adminLoginParam.getImgCode().toUpperCase())) {
            // 验证码错误
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_IMAGE_CODE_ERROR, null);
        }
        AdminUser adminUser = adminUserMapper.selectByUsername(adminLoginParam.getUsername());
        if (adminUser == null) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_NOT_EXISTS, null);
        }
        if (adminUser.getState() != 1) {
            return VOUtils.returnExtendVOError(CodeEnum.ADMIN_USER_LOCKED, null);
        }
        if (adminLoginParam.getPassword().equals(adminUser.getPassword())) {
            AdminUserPayloadDTO adminUserPayloadDTO = new AdminUserPayloadDTO();
            adminUserPayloadDTO.setId(adminUser.getId());
            adminUserPayloadDTO.setUsername(adminUser.getUsername());
            String myToken = JwtUtils.sign(adminUserPayloadDTO, Constants.TOKEN_EXPIRED);
            AdminUserMyTokenDTO adminUserMyTokenDTO = new AdminUserMyTokenDTO();
            adminUserMyTokenDTO.setMyToken(myToken);
            //把用户相关信息返回给前端
            Map reust = new HashMap<>(16);
            reust.put("user", adminUserService.getAdminUser(adminUser.getId()));
            reust.put("token", adminUserMyTokenDTO);
            //加入到属性供操作日志切面使用
            httpServletRequest.setAttribute(Constants.ADMIN_USER_ID, adminUser.getId());
            httpServletRequest.setAttribute(Constants.ADMIN_USERNAME, adminUser.getUsername());
            return VOUtils.returnExtendVOSuccess(reust);
        }
        return VOUtils.returnExtendVOError(CodeEnum.ADMIN_PASSWORD_ERROR, null);
    }

    @Override
    public ExtendVO operateLogQuery(AdminOperateLogQueryParam adminOperateLogQueryParam) {
        PageHelper.startPage(adminOperateLogQueryParam.getPageNum(), adminOperateLogQueryParam.getPageSize());
        List<AdminUserOperateLogDTO> adminUserOperateLogList = adminUserOperateLogMapper.getAdminUserOperateLogList(adminOperateLogQueryParam);
        PageInfo<AdminUserOperateLogDTO> pageInfo = new PageInfo<>(adminUserOperateLogList);
        return VOUtils.returnExtendVOFillPageInfo(pageInfo);
    }

    @Override
    public ExtendVO getSelfInfo(HttpServletRequest httpServletRequest) {
        //把用户相关信息返回给前端
        Map reust = new HashMap<>(16);
        reust.put("user", adminUserService.getAdminUser(AdminLoginUserUtils.getAdminUserId(httpServletRequest)));
        return VOUtils.returnExtendVOSuccess(reust);
    }
}
