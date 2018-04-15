package com.dev.msg.handler;

import com.dev.msg.exception.MsgAuthorizeException;
import com.dev.msg.utils.ResultVOUtil;
import com.dev.msg.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/4/15 21:11
 */
@ControllerAdvice
public class MsgExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(MsgExceptionHandler.class);

    @ExceptionHandler(value = MsgAuthorizeException.class)
    @ResponseBody
    public ResultVO authHandle(Exception e) {
        logger.error("【登录异常】{}", e);
        return ResultVOUtil.error(-1, "未登录");
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        logger.error("【系统异常】{}", e);
        return ResultVOUtil.error(-2, "未知错误");
    }
}
