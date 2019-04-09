package com.quanlehui.servicebase.base.util;

import com.github.pagehelper.PageInfo;

import com.quanlehui.servicebase.base.vo.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Desc    : 返回数据工具类
 * Date    : 2018-01-08
 *
 * @author : yxy
 */
public class VOUtils {

    /**
     * 返回成功基本VO
     * @return
     */
    public static BaseVO returnBaseVOSuccess(){
        return new BaseVO(CodeEnum.SUCCESS);
    }

    /**
     * 返回失败基本VO
     * @param codeEnum
     * @return
     */
    public static BaseVO returnBaseVOError(CodeEnum codeEnum){
        if(codeEnum == null){
            return new BaseVO(CodeEnum.ERROR);
        }
        return new BaseVO(codeEnum);
    }

    /**
     * 返回动态基本VO
     * @param codeEnum
     * @param message
     * @return
     */
    public static BaseVO returnBaseVODynamic(CodeEnum codeEnum,String message){
        if(codeEnum == null){
            return new BaseVO(CodeEnum.ERROR);
        }
        return new BaseVO(CodeEnum.DYNAMIC_CODE.setDynamic(codeEnum,message));
    }

    /**
     * 返回动态基本VO,自定义code
     * @param code
     * @param message
     * @return
     */
    public static BaseVO returnBaseVODynamicCode(Integer code,String message){
        if(code == null){
            return new BaseVO(CodeEnum.ERROR);
        }
        return new BaseVO(CodeEnum.DYNAMIC_CODE.setDynamicCode(code,message));
    }

    /**
     * 返回成功扩展VO
     * @return
     */
    public static ExtendVO returnExtendVOSuccess(Object data){
        return new ExtendVO(CodeEnum.SUCCESS,data);
    }

    /**
     * 返回失败扩展VO
     */
    public static ExtendVO returnExtendVOError(CodeEnum codeEnum,Object data){
        if(codeEnum == null) {
            return new ExtendVO(CodeEnum.ERROR,data);
        }
        return new ExtendVO(codeEnum,data);
    }

    /**
     * 返回动态扩展VO
     * @param codeEnum
     * @param message
     * @param data
     * @return
     */
    public static ExtendVO returnExtendVODynamic(CodeEnum codeEnum,String message,Object data){
        if(codeEnum == null) {
            return new ExtendVO(CodeEnum.ERROR,data);
        }
        return new ExtendVO(CodeEnum.DYNAMIC_CODE.setDynamic(codeEnum,message),data);
    }

    /**
     * 返回动态扩展VO,code自定义
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ExtendVO returnExtendVODynamicCode(Integer code,String message,Object data){
        if(code == null){
            return new ExtendVO(CodeEnum.ERROR,data);
        }
        return new ExtendVO(CodeEnum.DYNAMIC_CODE.setDynamicCode(code,message),data);
    }

    /**
     * 返回成功扩展VO,以分页信息为data
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> ExtendVO returnExtendVOFillPageInfo(PageInfo<T> pageInfo){
        PageInfoData<T> data = new PageInfoData<T>();
        data.setTotal(pageInfo.getTotal());
        data.setList(pageInfo.getList());
        data.setPages(pageInfo.getPages());
        return new ExtendVO(CodeEnum.SUCCESS,data);
    }

    /**
     * 返回成功扩展VO,以分页信息为data,并增加其它扩展字段
     * @param pageInfo
     * @param otherData
     * @param <T>
     * @return
     */
    public static <T> ExtendVO returnExtendVOFillPageInfo(PageInfo<T> pageInfo,Object otherData){
        PageInfoData<T> data = new PageInfoData<T>();
        data.setTotal(pageInfo.getTotal());
        data.setList(pageInfo.getList());
        data.setPages(pageInfo.getPages());
        data.setData(otherData);
        return new ExtendVO(CodeEnum.SUCCESS,data);
    }

    /**
     * 返回成功扩展VO,以分页信息为data，处理搜索的分页数据
     * @param page
     * @param <T>
     * @return
     */
    public static <T> ExtendVO returnExtendVOFillPageInfo(Page<T> page){
        Iterator<T> iterator = page.iterator();
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        PageInfoData<T> data = new PageInfoData<T>();
        data.setTotal(page.getTotalElements());
        data.setList(list);
        data.setPages(page.getTotalPages());
        return new ExtendVO(CodeEnum.SUCCESS,data);
    }

    public static ExtendVO returnExtendVOFillParamError(String field,String errorInfo){
        ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
        invalidArgument.setDefaultMessage(errorInfo);
        invalidArgument.setField(field);
        invalidArgument.setRejectedValue("");
        return new ExtendVO(CodeEnum.ERROR_PARAM,invalidArgument);
    }

    public static Boolean isOkExtendVO(ExtendVO extendVO){
        if(extendVO !=null && extendVO.getCode() == 0){
            return true;
        }
        return false;
    }

}
