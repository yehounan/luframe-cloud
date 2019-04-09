package com.quanlehui.servicebase.base.constant;

/**
 * Desc    : Redis键
 *
 * @author : yxy
 * @date : 2018-12-18
 */
public interface RedisKeyConstants {

    /**
     * 权限密钥前缀
     */
    String SECRET_PREFIX = "SECRET_";

    /**
     * 客户端IP白名单前缀
     */
    String CLIENT_IP_WHITE_FORMAT = "CLIENT_IP_WHITE_%s_%s";

    /**
     * 图片验证码前缀
     */
    String USER_IMAGE_CDOE = "user_image_cdoe_";

    /**
     * 后台管理操作日志查询
     */
    String ADMIN_OPERATELOG_QUERY = "ADMIN_OPERATELOG_QUERY_";

    /**
     * 可用游戏列表KEY
     */
    String DATAITEM_ALL_GAME = "DATAITEM_ALL_GAME";
}