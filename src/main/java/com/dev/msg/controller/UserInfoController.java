package com.dev.msg.controller;

import com.dev.msg.bean.UserInfoDO;
import com.dev.msg.constant.CookieConstant;
import com.dev.msg.service.UserInfoService;
import com.dev.msg.service.impl.UserInfoServiceImpl;
import com.dev.msg.utils.CookieUtil;
import com.dev.msg.utils.ResultVOUtil;
import com.dev.msg.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 11:36
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


    @PostMapping("/login")
    @ApiOperation("登录")
    public ResultVO login(@RequestBody HashMap<String, String> user, HttpServletRequest request,HttpServletResponse response) {

        String userId = user.get("userId");
        String userPwd = user.get("userPwd");


        UserInfoDO userInfoDO = userInfoService.login(userId, userPwd);
        if (userInfoDO == null) {
            ResultVOUtil.error(1, "登录失败");
        }

        //Cookie...
        String token = UUID.randomUUID().toString();
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        //Session
        HttpSession session = request.getSession(true);
        session.setAttribute(CookieConstant.TOKEN, userInfoDO);

        userInfoDO.setUserPwd("");

        return ResultVOUtil.success(userInfoDO);

    }

    @PostMapping("/logout")
    @ApiOperation("登出")
    public ResultVO logout(HttpServletRequest request,
                           HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        HttpSession session = request.getSession(true);
        session.invalidate();

        return ResultVOUtil.success("登出成功");
    }

}
