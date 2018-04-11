package com.dev.msg.controller;

import com.dev.msg.utils.ResultVOUtil;
import com.dev.msg.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 11:36
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {


    @PostMapping("/login")
    public ResultVO login(@RequestBody HashMap<String,String> user){

        String userId= user.get("userId");
        String userPwd = user.get("userPwd");

        return ResultVOUtil.success();

    }

    public ResultVO logout(){
        return ResultVOUtil.success();
    }

}
