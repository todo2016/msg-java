package com.dev.msg.service;

import com.dev.msg.bean.MsgInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 01:15
 */

public interface MsgInfoService {

    MsgInfoDO save(MsgInfoDO msgInfoDO);

    Page<MsgInfoDO> findList(String userId, Pageable pageable);

}
