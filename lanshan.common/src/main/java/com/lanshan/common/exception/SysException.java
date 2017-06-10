package com.lanshan.common.exception;

public class SysException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	private String code = "9999";
	
	public SysException(String msg){
		super(msg);
	}
	
	public SysException(String code, String msg){
		super(msg);
		this.code = code;
	}
	
	public SysException(SysErrorCode ec){
		super(ec.getMsg());
		this.code = ec.getCode();
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		//return code+"-"+super.getMessage();
		return super.getMessage();
	}
	
	

}
