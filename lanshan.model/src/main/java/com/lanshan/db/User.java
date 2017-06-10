package com.lanshan.db;

import lombok.Data;

/**
 * 用户信息表
 * @author Minko
 *
 */
@Data
public class User {
	
	private String id;	// 用户id
	private String account;	// 用户帐号
	private String password; // 用户密码
	private int passworderr; // 密码错误次数
	private String lastlogintime; // 上次登录时间
	private String createtime; // 创建时间
	
	
	// vo
	private String confirmpassword; // 重复密码
}
