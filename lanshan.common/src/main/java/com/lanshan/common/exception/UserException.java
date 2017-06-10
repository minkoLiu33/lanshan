package com.lanshan.common.exception;


public class UserException extends SysException {
	
	private static final long serialVersionUID = 1L;
	
	public UserException(String msg){
		super(msg);
	}
	
	public UserException(String code, String msg){
		super(code, msg);
	}
	
	public UserException(UserErrorCode ec){
		super(ec.getCode(), ec.getMsg());
	}
}
