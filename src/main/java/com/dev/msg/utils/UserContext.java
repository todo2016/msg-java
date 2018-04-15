package com.dev.msg.utils;


import com.dev.msg.bean.UserInfoDO;

public class UserContext {
	private static final ThreadLocal<UserInfoDO> USER_HODLER = new ThreadLocal<>();
    
	public static void setUser(UserInfoDO user){
		USER_HODLER.set(user);
	}
	
	public static void remove(){
		USER_HODLER.remove();
	}
	
	public static UserInfoDO getUser(){
		return USER_HODLER.get();
	}
}
