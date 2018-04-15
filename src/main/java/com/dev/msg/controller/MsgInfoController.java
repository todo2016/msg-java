package com.dev.msg.controller;

import com.dev.msg.bean.MsgInfoDO;
import com.dev.msg.service.MsgInfoService;
import com.dev.msg.utils.ResultVOUtil;
import com.dev.msg.utils.UserContext;
import com.dev.msg.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 01:33
 */
@RestController
@RequestMapping("/msg")
@CrossOrigin
public class MsgInfoController {


    @Autowired
    MsgInfoService msgInfoService;

    @GetMapping("/list")
    @ApiOperation("留言板列表")
    public ResultVO list(@RequestParam("userId") String userId,
                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(userId)) {

        }
        PageRequest pageRequest = new PageRequest(page - 1, size, Sort.Direction.DESC, "createTime");
        Page<MsgInfoDO> msgInfoDOPage = msgInfoService.findList(userId, pageRequest);


        return ResultVOUtil.success(msgInfoDOPage);
    }

    //@PostMapping("/create")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ApiOperation("留言")
    public ResultVO create(@RequestBody MsgInfoDO msgInfoDO) {

        msgInfoDO.setMsgId(UUID.randomUUID().toString());
        msgInfoDO.setCreateTime(new Date());
        msgInfoDO.setUserId(UserContext.getUser().getUserName());
        return ResultVOUtil.success(msgInfoService.save(msgInfoDO));
    }
}
