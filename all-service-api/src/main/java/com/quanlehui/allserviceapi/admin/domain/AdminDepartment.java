package com.quanlehui.allserviceapi.admin.domain;

import com.quanlehui.servicebase.base.domain.BaseDomain;
import lombok.Data;

/**
 * Description 部门表数据库对象
 *
 * @author yxy
 * @date 2018/12/12
 */
@Data
public class AdminDepartment  extends BaseDomain {
    private String deptName;

}