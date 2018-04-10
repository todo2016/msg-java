package com.dev.msg.service.impl;

import com.dev.msg.bean.MsgInfoDO;
import com.dev.msg.repository.MsgInfoRepository;
import com.dev.msg.service.MsgInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 01:26
 */

@Service
public class MsgInfoServiceImpl implements MsgInfoService {

    @Autowired
    MsgInfoRepository msgInfoRepository;


    @Override
    public MsgInfoDO save(MsgInfoDO msgInfoDO) {
        return msgInfoRepository.save(msgInfoDO);
    }

    @Override
    public Page<MsgInfoDO> findList(String userId, Pageable pageable) {
        return msgInfoRepository.findByUserId(userId, pageable);
    }
}
