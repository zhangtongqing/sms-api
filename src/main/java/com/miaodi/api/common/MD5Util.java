package com.miaodi.api.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
	private static ThreadLocal<MessageDigest> localMd = new ThreadLocal<MessageDigest>();
	// 十六进制下数字到字符的映射数组
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 获取md5算法实例
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	private static MessageDigest getMessageDigest() throws NoSuchAlgorithmException
	{
		MessageDigest md = localMd.get();
		if (md == null)
		{
			md = MessageDigest.getInstance("MD5");
			localMd.set(md);
		}
		return md;
	}

	/**
	 * 验证输入的密码是否正确
	 * 
	 * @param password
	 *            加密后的密码
	 * @param inputString
	 *            输入的字符串
	 * @return 验证结果，TRUE:正确 FALSE:错误
	 */
	public static boolean validatePassword(String password, String inputString)
	{
		if (password.equals(encodeByMD5(inputString)))
		{
			return true;
		} else
		{
			return false;
		}
	}

	/** 对字符串进行MD5加密 */
	public static String encodeByMD5(String originString)
	{
		if (originString != null)
		{
			try
			{
				// 创建具有指定算法名称的信息摘要
				MessageDigest md = getMessageDigest();
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes());
				// 将得到的字节数组变成字符串返回
				String resultString = byteArrayToHexString(results);
				return resultString.toLowerCase();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 转换字节数组为十六进制字符串
	 * 
	 * @param 字节数组
	 * @return 十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] b)
	{
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
		{
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/** 将一个字节转化成十六进制形式的字符串 */
	private static String byteToHexString(byte b)
	{
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args)
	{
		String data = encodeByMD5("developerId=823deef8e529477185a52179325b4a62&appId=adb69af82c124a87a8d59569c29c5ffd&callId=dc8f00b4d6c047da8cc026be635a2f4a&callerNumber=de55a07555144af0883a33b11f13b725&callerDisplayNumber=2222&calledNumber=13265581429&callDisplayNumber=666666&canCallTime=5820&ts=1416220975176&key=eIEIjsd9393**hdi#$12kd");
		System.out.print(data);
	}

}
