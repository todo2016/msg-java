package com.dev.msg.utils;

import com.dev.msg.vo.ResultVO;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 11:05
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);

        return resultVO;
    }
}
