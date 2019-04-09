package com.quanlehui.adminservice.controller;


import com.quanlehui.adminservice.annotation.RecordLog;
import com.quanlehui.adminservice.service.AdminDepartmentService;
import com.quanlehui.allserviceapi.admin.domain.AdminDepartment;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 部门控制器
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@RestController
@SuppressWarnings("all")
@Slf4j
public class AdminDepartmentController {

    @Autowired
    private AdminDepartmentService adminDepartmentService;


    /**
     * 列表查询
     * @return
     */
    @GetMapping("/list/department")
    public ExtendVO listAdminDepartment(){
        try {
            List<AdminDepartment> page=   adminDepartmentService.listAdminDepartment();
            return  VOUtils.returnExtendVOSuccess(page);
        }catch (Exception e){
            log.error("",e);
            return  VOUtils.returnExtendVOError(CodeEnum.ERROR ,"系统错误");
        }
    }

    /**
     * 新增
     * @return
     */
    @RecordLog
    @GetMapping("/insert/department")
    public BaseVO insertDepartment(@RequestParam("deptName") String deptName){
        try {
            adminDepartmentService.insertDepartment(deptName);
            return  VOUtils.returnBaseVOSuccess();
        }catch (Exception e){
            log.error("",e);
            return  VOUtils.returnBaseVOError(CodeEnum.ERROR );
        }
    }


    /**
     * 修改
     * @return
     */
    @RecordLog
    @GetMapping("/update/department")
    public BaseVO   updateDepartment(@RequestParam("deptName") String deptName,@RequestParam("id") Long id){
        try {
            adminDepartmentService.updateDepartment(deptName,id);
            return  VOUtils.returnBaseVOSuccess();
        }catch (Exception e){
            log.error("",e);
            return  VOUtils.returnBaseVOError(CodeEnum.ERROR );
        }
    }


    /**
     * 删除
     * @return
     */
    @RecordLog
    @GetMapping("/delete/department")
    public    BaseVO deleteDepartment(@RequestParam("id")  Long id){
        try {
            BaseVO vo= adminDepartmentService.deleteDepartment(id);
            return  vo;
        }catch (Exception e){
            log.error("",e);
            return  VOUtils.returnBaseVOError(CodeEnum.ERROR );
        }
    }


}
