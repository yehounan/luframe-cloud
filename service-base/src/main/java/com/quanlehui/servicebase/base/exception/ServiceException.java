package com.quanlehui.servicebase.base.exception;


import com.quanlehui.servicebase.base.vo.CodeEnum;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	Integer errorCode;
	String errorMsg;
	CodeEnum codeEnum;

	public ServiceException(Integer errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public ServiceException(CodeEnum codeEnum) {
		super(codeEnum.getMessage());
		this.errorCode = codeEnum.getCode();
		this.errorMsg = codeEnum.getMessage();
		this.codeEnum = codeEnum;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public CodeEnum getCodeEnum() {
		return codeEnum;
	}

}
