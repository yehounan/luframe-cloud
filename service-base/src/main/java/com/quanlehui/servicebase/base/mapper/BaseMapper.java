package com.quanlehui.servicebase.base.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Description: 依赖tk.mybatis框架的通用Mapper
 * @author : yxy
 * @date: 2018-09-19
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
