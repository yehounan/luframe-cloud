package com.quanlehui.servicebase.base.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * Desc   : 数据库对象根DO
 * @author : yxy
 * @date   : 2017-12-24
 */
@Data
public class BaseDomain {
    /**
     * 主键id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    /**
     * 创建时间
     */
    protected Date createTime;

}
