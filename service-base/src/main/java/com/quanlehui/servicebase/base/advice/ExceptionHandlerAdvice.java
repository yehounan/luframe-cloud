package com.quanlehui.servicebase.base.advice;


import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.ArgumentInvalidResult;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc    : 统一异常处理
 * Date    : 2018-01-12
 *
 * @author : yxy
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value=Throwable.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                Throwable throwable)
    {
        log.error("",throwable);
        //POST请求参数异常处理
        if(throwable instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) throwable;
            //按需重新封装需要返回的错误信息
            //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
            for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
                ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
                invalidArgument.setDefaultMessage(error.getDefaultMessage());
                invalidArgument.setField(error.getField());
                invalidArgument.setRejectedValue(error.getRejectedValue());
                log.info("参数异常:"+error.getField()+error.getDefaultMessage());
                return VOUtils.returnExtendVOError(CodeEnum.DYNAMIC_CODE.setDynamic(CodeEnum.ERROR_PARAM,
                        error.getDefaultMessage()), null);
            }
            return VOUtils.returnExtendVOError(CodeEnum.ERROR_PARAM, null);
        }
        //GET请求参数异常处理
        if(throwable instanceof MissingServletRequestParameterException){
            return VOUtils.returnExtendVODynamic(CodeEnum.ERROR_PARAM,
                    "参数异常:"+((MissingServletRequestParameterException) throwable).getParameterName()+"不能为空！" ,null);
        }
        return VOUtils.returnExtendVOError(CodeEnum.ERROR,throwable.getMessage());

    }
}
