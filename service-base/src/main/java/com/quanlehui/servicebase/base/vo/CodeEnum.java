package com.quanlehui.servicebase.base.vo;

/**
 * Desc   : 响应码枚举
 * Author : yxy
 * Date   : 2017-12-20
 */
public enum CodeEnum {

    SUCCESS(0, "操作成功"),
    /*
     * 1000-1999, 系统预留错误码
     */
    ERROR(1000, "系统开小差了，请稍后再试"),

    ERROR_PARAM(1001, "参数异常"),

    ERROR_TOKEN(1002, "TOKEN无效"),

    ERROR_TOKEN_EXPIRE(1003, "登录已过期"),

    ERROR_REQUEST(1004, "请求异常"),

    ERROR_RATE_LIMIT(1005, "超出访问限制"),

    /*
     * 9000-9999,后台管理权限错误码
     */
    ADMIN_PASSWORD_ERROR(9001, "账号或密码错误"),

    ADMIN_USER_NOT_EXISTS(9002, "账号或密码错误"),

    ADMIN_USER_NOT_ROLE(9003, "该管理员用户没有被分配角色"),

    ADMIN_USER_NOT_RESOURCE(9004, "该管理员用户没有被分配任何权限"),

    ADMIN_RESOURCE_NOT_EXISTS(9005, "该资源不存在"),

    ADMIN_NOT_LOGIN(9006, "用户未登录"),

    ADMIN_USER_IP_ERR(500, "请填写ip地址"),

    ADMIN_UDER_IP_ISEXIST(501, "ip地址已经存在，请重新添加！"),

    ADMIN_USER_IMAGE_CODE_EXPIRED(9007, "验证码已经失效"),

    ADMIN_USER_IMAGE_CODE_ERROR(9008, "验证码错误"),

    ADMIN_USER_LOCKED(9009, "该用户被锁定,请联系管理员"),

    ADMIN_USER_IP_NOT_EXISTS(90010, "你的ip没有获取到，不支持登录"),

    ADMIN_USER_IP_IS_NOT_WHITELIST(90011, "你的IP没有授权，请授权后访问"),

    ADMIN_USER_ALREADY_EXISTS(9010, "账号已经存在"),

    ADMIN_CONTACT_US_ERROR(9011, "联系我们处理异常"),

    OPEN_API_SECRET_NOT_NULL(40001, "秘钥不能为空！"),

    OPEN_API_SECRET_INVALID(40002, "您的秘钥无效！"),

    OPEN_API_IP_INVALID(40003, "您的IP未授权！"),

    /**
     * 动态码，用以暂存动态错误信息
     */
    DYNAMIC_CODE(-1, "");

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 自定义错误信息的方法
     *
     * @param message
     * @return
     */
    @Deprecated
    public CodeEnum setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 自定义错误信息的方法,使用方法:
     * CodeEnum.DYNAMIC_CODE.setDynamic(CodeEnum codeEnum,String message)
     *
     * @param codeEnum
     * @param message
     * @return
     */
    public CodeEnum setDynamic(CodeEnum codeEnum, String message) {
        this.code = codeEnum.getCode();
        this.message = message;
        return this;
    }

    /**
     * 自定义错误信息的方法,使用方法:
     * CodeEnum.DYNAMIC_CODE.setDynamicCode(Integer code,String message)
     *
     * @param code
     * @param message
     * @return
     */
    public CodeEnum setDynamicCode(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

}
