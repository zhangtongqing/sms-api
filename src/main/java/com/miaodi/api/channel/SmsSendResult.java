package com.miaodi.api.channel;

/**
 * 公用的短信发送返回
 * @author weinianjie
 * @date   2015年11月5日
 */
public class SmsSendResult
{
	// 暂时定义这两项，以后其他接口有需要可以扩展字段
	private String code = CODE_FAIL;// 请求结果
	private String taskId;// 短信唯一标识，有些通道没有
	
	private String desc;// 描述扩展
	private String errCode; // 通道返回的错误码
	
	public static final String CODE_SUCCESS = "00000";
	public static final String CODE_FAIL = "00001";
	
	public SmsSendResult()
	{
		this.taskId = "";
		this.desc  = "";
	}
	
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getTaskId()
	{
		return taskId;
	}
	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
