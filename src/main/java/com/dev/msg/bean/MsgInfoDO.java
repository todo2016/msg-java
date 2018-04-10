package com.dev.msg.bean;

import com.dev.msg.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: wangwei
 * @Description: 帮助类
 * @date: 2018/3/31 00:20
 */
@Entity
@Table(name = "msg_info", schema = "msg-dev", catalog = "")
public class MsgInfoDO {
    private String msgId;
    private String msgDesc;
    private String msgImg;
    private Integer msgLike;
    private Integer msgStatus;
    private String userId;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    private Date updateTime;

    @Id
    @Column(name = "msg_id")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Basic
    @Column(name = "msg_desc")
    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    @Basic
    @Column(name = "msg_img")
    public String getMsgImg() {
        return msgImg;
    }

    public void setMsgImg(String msgImg) {
        this.msgImg = msgImg;
    }

    @Basic
    @Column(name = "msg_like")
    public Integer getMsgLike() {
        return msgLike;
    }

    public void setMsgLike(Integer msgLike) {
        this.msgLike = msgLike;
    }

    @Basic
    @Column(name = "msg_status")
    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgInfoDO msgInfoDO = (MsgInfoDO) o;

        if (msgId != null ? !msgId.equals(msgInfoDO.msgId) : msgInfoDO.msgId != null) return false;
        if (msgDesc != null ? !msgDesc.equals(msgInfoDO.msgDesc) : msgInfoDO.msgDesc != null) return false;
        if (msgImg != null ? !msgImg.equals(msgInfoDO.msgImg) : msgInfoDO.msgImg != null) return false;
        if (msgLike != null ? !msgLike.equals(msgInfoDO.msgLike) : msgInfoDO.msgLike != null) return false;
        if (msgStatus != null ? !msgStatus.equals(msgInfoDO.msgStatus) : msgInfoDO.msgStatus != null) return false;
        if (userId != null ? !userId.equals(msgInfoDO.userId) : msgInfoDO.userId != null) return false;
        if (createTime != null ? !createTime.equals(msgInfoDO.createTime) : msgInfoDO.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(msgInfoDO.updateTime) : msgInfoDO.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msgId != null ? msgId.hashCode() : 0;
        result = 31 * result + (msgDesc != null ? msgDesc.hashCode() : 0);
        result = 31 * result + (msgImg != null ? msgImg.hashCode() : 0);
        result = 31 * result + (msgLike != null ? msgLike.hashCode() : 0);
        result = 31 * result + (msgStatus != null ? msgStatus.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
