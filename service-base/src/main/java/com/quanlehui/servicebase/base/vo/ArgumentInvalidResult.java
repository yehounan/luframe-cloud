package com.quanlehui.servicebase.base.vo;

/**
 * Desc    : 参数校验异常结果
 * Date    : 2018-01-12
 *
 * @author : yxy
 */
public class ArgumentInvalidResult {
    private String field;
    private Object rejectedValue;
    private String defaultMessage;

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public Object getRejectedValue() {
        return rejectedValue;
    }
    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }
    public String getDefaultMessage() {
        return defaultMessage;
    }
    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
