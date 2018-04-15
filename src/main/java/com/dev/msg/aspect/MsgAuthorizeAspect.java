package com.dev.msg.aspect;

import com.dev.msg.bean.UserInfoDO;
import com.dev.msg.constant.CookieConstant;
import com.dev.msg.exception.MsgAuthorizeException;
import com.dev.msg.utils.UserContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/4/15 19:53
 */
@Aspect
@Component
public class MsgAuthorizeAspect {

    @Pointcut("execution(public * com.dev.msg.controller.MsgInfoController.*(..))")
    public void verify(){}


    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        HttpSession session = request.getSession(true);
        UserInfoDO user =  (UserInfoDO)session.getAttribute(CookieConstant.TOKEN);

        if(user==null){
            throw new MsgAuthorizeException();
        }


        UserContext.setUser(user);

    }

    @After("verify()")
    public void afterVerify(){
        UserContext.remove();
    }


}
