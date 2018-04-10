package com.dev.msg.repository;

import com.dev.msg.bean.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 00:28
 */
public interface UserInfoRepository extends JpaRepository<UserInfoDO, String> {
}
