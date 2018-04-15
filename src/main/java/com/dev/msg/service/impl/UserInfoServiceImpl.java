package com.dev.msg.service.impl;

import com.dev.msg.bean.UserInfoDO;
import com.dev.msg.repository.UserInfoRepository;
import com.dev.msg.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/4/15 19:33
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDO login(String userName, String userPwd) {
        return userInfoRepository.getOneByUserNameAndUserPwdAndAndUserStatus(userName,userPwd,0);
    }
}
