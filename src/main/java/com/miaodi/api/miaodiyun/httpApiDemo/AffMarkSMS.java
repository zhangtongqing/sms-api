package com.miaodi.api.miaodiyun.httpApiDemo;


import com.miaodi.api.miaodiyun.httpApiDemo.common.Config;
import com.miaodi.api.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 会员营销短信接口
 * 
 * @ClassName: AffMarkSMS
 * @Description: 会员营销短信接口
 *
 */
public class AffMarkSMS
{
	private static String operation = "/affMarkSMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "15013744700";
	private static String smsContent = "【艺兮美妆】您的验证码是222，33分钟输入有效退订";

	/**
	 * 会员营销短信
	 */
	public static void execute()
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
}
