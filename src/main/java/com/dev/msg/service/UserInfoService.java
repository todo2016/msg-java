package com.dev.msg.service;

import com.dev.msg.bean.UserInfoDO;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/4/15 19:29
 */
public interface UserInfoService {

    UserInfoDO login(String userName,String userPwd);
}
