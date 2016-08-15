package com.miaodi.api.miaodiyun.httpApiDemo;


import com.miaodi.api.miaodiyun.httpApiDemo.common.Config;
import com.miaodi.api.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "18907844413"; //空号
	private static String to = "18126160895";
	private static String smsContent = "【艺兮美妆】您的验证码是2222，3分钟输入有效";
	//private static String smsContent = "【阿里小鱼】您注册222网站的验证码为222";  //测试环境


	/**
	 * 验证码通知短信
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
