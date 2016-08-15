package com.miaodi.api.channel;



import com.miaodi.api.enums.SmsSendEnum;

import java.util.Date;

/**
 * 公用的状态查询数据项
 * @author weinianjie
 * @date   2015年11月5日
 */
public class QuerySmsData
{
	// 标准返回
	private String taskId;					// 短信唯一标识
	private String phone;					// 接收号码
	private Date sendTime;				// 通道、网关收到的时间
	private Date receivedTime;			// 接收时间
	private SmsSendEnum status;	// 结果状态
	private String smscStatus ;
	private long channelId;
	private long scheduleId;
	
	// 例外返回
	private String content;
	private String respDesc;
	
	public long getScheduleId()
	{
		return scheduleId;
	}

	public void setScheduleId(long scheduleId)
	{
		this.scheduleId = scheduleId;
	}

	public long getChannelId()
	{
		return channelId;
	}

	public void setChannelId(long channelId)
	{
		this.channelId = channelId;
	}

	public String getRespDesc()
	{
		return respDesc;
	}

	public void setRespDesc(String respDesc)
	{
		this.respDesc = respDesc;
	}

	public String getTaskId()
	{
		return taskId;
	}

	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Date getReceivedTime()
	{
		return receivedTime;
	}

	public void setReceivedTime(Date receivedTime)
	{
		this.receivedTime = receivedTime;
	}

	public SmsSendEnum getStatus()
	{
		return status;
	}

	public void setStatus(SmsSendEnum status)
	{
		this.status = status;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getSmscStatus()
	{
		return smscStatus;
	}

	public void setSmscStatus(String smscStatus)
	{
		this.smscStatus = smscStatus;
	}

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
