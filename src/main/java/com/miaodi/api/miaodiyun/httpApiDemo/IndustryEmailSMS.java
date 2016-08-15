package com.miaodi.api.miaodiyun.httpApiDemo;


import com.miaodi.api.miaodiyun.httpApiDemo.common.Config;
import com.miaodi.api.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 短信邮验证码通知短信接口
 *
 * @ClassName: IndustryEmailSMS
 * @Description: 短信邮验证码通知短信接口
 *
 */
public class IndustryEmailSMS
{
	private static String operation = "/industryEmailSMS/sendEmailSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "15013744700";
//	private static String to = "15013744700";//"徐伟：15013744700";   红梅移动：13510638584
	//private static String smsContent = "【阿里小鱼】您注册百合网网站的验证码为888，请于3分钟内正确输入验证码";
	private static String smsContent = "【滴滴打车】深圳天气预报提醒您，今天暴雨红色预警，请提前预约滴滴打船！";
	//private static String smsContent = "彩讯通道测试";

	/**
	 * 短信邮验证码通知短信
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
