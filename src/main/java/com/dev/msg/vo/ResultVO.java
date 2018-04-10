package com.dev.msg.vo;

import java.io.Serializable;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 01:41
 */
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -4489816097178791466L;

    private Integer code;
    private String msg;
    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
