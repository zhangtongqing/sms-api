package com.miaodi.api.enums;

/**
 * 短信发送状态
 */
public enum SmsSendEnum
{
	all("", "全部"), unknow("unknow", "未知"), notSend("notSend", "未发送"), sended("sended", "已经发送"), success("success", "成功"), fail(
			"fail", "失败"), submitFail("submitFail", "提交到网关失败");

	private String code;
	private String desc;

	SmsSendEnum(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}

	public String getCode()
	{
		return code;
	}

	public String getDesc()
	{
		return desc;
	}

	/**
	 * getDesc by code
	 * 
	 * @param code
	 * @return
	 */
	public static String getDesc(String code)
	{
		SmsSendEnum[] values = SmsSendEnum.values();
		for (int i = 0, j = values.length; i < j; i++)
		{
			if (values[i].getCode().equals(code))
			{
				return values[i].getDesc();
			}
		}
		return null;
	}
}
