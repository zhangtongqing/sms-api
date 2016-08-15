package com.miaodi.api.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机号码
 * 
 * @author qinquan
 * 
 */
public class PhoneUtil
{
	private static List<String> yiDongList = new ArrayList<String>();
	private static List<String> lianTongList = new ArrayList<String>();
	private static List<String> dianXinList = new ArrayList<String>();

	static
	{
		// 移动
		yiDongList.add("134");
		yiDongList.add("135");
		yiDongList.add("136");
		yiDongList.add("137");
		yiDongList.add("138");
		yiDongList.add("139");
		yiDongList.add("147");
		yiDongList.add("150");
		yiDongList.add("151");
		yiDongList.add("152");
		yiDongList.add("157");
		yiDongList.add("158");
		yiDongList.add("159");
		yiDongList.add("178");
		yiDongList.add("182");
		yiDongList.add("183");
		yiDongList.add("184");
		yiDongList.add("187");
		yiDongList.add("188");
		yiDongList.add("1705");
		yiDongList.add("1706");

		// 联通
		lianTongList.add("130");
		lianTongList.add("131");
		lianTongList.add("132");
		lianTongList.add("145");
		lianTongList.add("146");
		lianTongList.add("154");
		lianTongList.add("155");
		lianTongList.add("156");
		lianTongList.add("185");
		lianTongList.add("186");
		lianTongList.add("176");
		lianTongList.add("1707");
		lianTongList.add("1708");
		lianTongList.add("1709");
		lianTongList.add("1718");
		lianTongList.add("1719");

		// 电信
		dianXinList.add("133");
		dianXinList.add("153");
		dianXinList.add("180");
		dianXinList.add("181");
		dianXinList.add("189");
		dianXinList.add("177");
		dianXinList.add("173");
		dianXinList.add("1700");
		dianXinList.add("1701");
		dianXinList.add("1702");
	}

	/**
	 * 是否移动手机号码
	 * 
	 * @param phone
	 * @return 是移动返回true
	 */
	public static boolean isYiDong(String phone)
	{
		if (phone == null || phone.length() < 11)
			return false;

		return yiDongList.contains(phone.substring(0, 3)) || yiDongList.contains(phone.substring(0, 4));
	}

	/**
	 * 是否联通手机号码
	 * 
	 * @param phone
	 * @return 是联通返回true
	 */
	public static boolean isLianTong(String phone)
	{
		if (phone == null || phone.length() < 11)
			return false;

		return lianTongList.contains(phone.substring(0, 3)) || lianTongList.contains(phone.substring(0, 4));
	}

	/**
	 * 是否电信手机号码
	 * 
	 * @param phone
	 * @return 是电信返回true
	 */
	public static boolean isDianXin(String phone)
	{
		if (phone == null || phone.length() < 11)
			return false;

		return dianXinList.contains(phone.substring(0, 3)) || dianXinList.contains(phone.substring(0, 4));
	}


	// 干掉86头，不做检验
	public static String fuck86(String phone)
	{
		if(phone.startsWith("86"))
		{
			return phone.substring(2);
		}else
		{
			return phone;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(fuck86("8613503988767"));
	}
}