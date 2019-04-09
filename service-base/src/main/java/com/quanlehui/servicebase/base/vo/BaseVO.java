package com.quanlehui.servicebase.base.vo;

/**
 * Desc   : 响应JSON基本模型
 * Author : yxy
 * Date   : 2017-12-20
 */
public class BaseVO {

    /**
     * 响应码
     */
    protected Integer code;

    /**
     * 响应信息
     */
    protected String message;

    /**
     * 接口执行时间,其值通过AOP计算获取,所以在构造方法中不予以赋值
     */
    protected Long cost;

    public BaseVO() {
    }

    public BaseVO(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", cost=" + cost +
                '}';
    }
}
