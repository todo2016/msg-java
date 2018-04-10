package com.dev.msg.repository;

import com.dev.msg.bean.MsgInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 00:26
 */
public interface MsgInfoRepository extends JpaRepository<MsgInfoDO, String> {
    Page<MsgInfoDO> findByUserId(String userId, Pageable pageable);
}
