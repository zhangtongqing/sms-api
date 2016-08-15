package com.miaodi.api.channel;

import java.util.Date;

/**
 * 公用的上行数据项
 *
 * @author weinianjie
 * @date 2015年11月5日
 */
public class MoSmsData {
    // 标准返回
    private String phone;
    private String subMark;// 对应sms系统的developer_mo_config表里的subMakr，有些通道根据端口来识别，有些通道根据子账号来识别
    private String port;
    private long channelId;
    private String content;
    private Date moTime;

    // 扩展返回
    private String taskId;// 给一些特殊通道根据下行的taskId来识别，有些提供下行内容的，就把下行内容md5来作为taskId（无法解决绝对唯一性的问题）

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubMark() {
        return subMark;
    }

    public void setSubMark(String subMark) {
        this.subMark = subMark;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getMoTime() {
        return moTime;
    }

    public void setMoTime(Date moTime) {
        this.moTime = moTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MoSmsData [phone=" + phone + ", subMark=" + subMark + ", port=" + port + ", channelId=" + channelId
                + ", content=" + content + ", moTime=" + moTime + ", taskId=" + taskId + "]";
    }

}
