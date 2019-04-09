package com.quanlehui.adminservice.service;



import com.quanlehui.allserviceapi.admin.domain.AdminDepartment;
import com.quanlehui.servicebase.base.vo.BaseVO;

import java.util.List;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
public interface AdminDepartmentService {


    /**
     * 分页查询
     *
     * @return
     */
    List<AdminDepartment> listAdminDepartment();

    /**
     * 新增
     *
     * @param deptName
     * @return
     */
    void insertDepartment(String deptName);


    /**
     * 修改
     *
     * @param deptName
     * @param id
     * @return
     */
    void updateDepartment(String deptName, Long id);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    BaseVO deleteDepartment(Long id);


}
