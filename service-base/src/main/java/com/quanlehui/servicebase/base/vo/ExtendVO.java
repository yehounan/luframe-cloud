package com.quanlehui.servicebase.base.vo;

import lombok.Data;

/**
 * Desc   : 响应JSON扩展模型
 * Author : yxy
 * Date   : 2017-12-20
 */
@Data
public class ExtendVO<T> extends BaseVO {

    /**
     * 响应数据
     */
    protected T data;

    public ExtendVO() {
    }

    public ExtendVO(CodeEnum codeEnum,T data) {
        super(codeEnum);
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExtendVO{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", cost=" + cost +
                '}';
    }
}
