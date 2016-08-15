package com.miaodi.api.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 字符串是否为空，有一个为空就返回true
	 * 
	 * @param strs
	 * @return 为空-true
	 */
	public static boolean empty(String... strs) {
		for (String str : strs) {
			if (str == null || str.trim().equals(""))
				return true;
		}

		return false;
	}



	/**
	 * 以yyyyMMddHHmmss格式化当前时间
	 */
	public static String formatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}

	/**
	 * 组合列表
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String join(List list, boolean useComma) {
		if (list != null && list.size() != 0) {
			String li = useComma ? "'" : "";
			StringBuilder sb = new StringBuilder();
			for (Object o : list) {
				sb.append(",").append(li).append(o).append(li);
			}
			sb.deleteCharAt(0);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组合列表
	 * 
	 * @param list
	 * @return
	 */
	public static String join(String[] arr, boolean useComma) {
		if (arr != null && arr.length != 0) {
			String li = useComma ? "'" : "";
			StringBuilder sb = new StringBuilder();
			for (String o : arr) {
				sb.append(",").append(li).append(o).append(li);
			}
			sb.deleteCharAt(0);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 解析xml body获取其中某个字段的值
	 * 
	 * @param data
	 * @param fieldLength
	 *            字段名长度加2
	 * @return
	 */
	public static String getXmlField(String data, String fieldStart,
			String fieldEnd, int fieldLength) {
		int start = data.indexOf(fieldStart);
		if (start == -1)
			return null;
		return data.substring(start + fieldLength, data.indexOf(fieldEnd));
	}

	/**
	 * 解析json body获取其中某个字段的值
	 * 
	 * @param data
	 * @param fieldName
	 * @param fieldLength
	 *            字段名长度加1
	 * @return
	 */
	public static String getJsonField(String data, String fieldName,
			int fieldLength) {
		int fieldPos = data.indexOf(fieldName);
		if (fieldPos == -1)
			return null;
		int doubleQuota1 = data.indexOf("\"", fieldPos + fieldLength);
		int doubleQuota2 = data.indexOf("\"", doubleQuota1 + 1);
		return data.substring(doubleQuota1 + 1, doubleQuota2);
	}


	public static final String replaceMultiToOne(String oldChar) {
		if (StringUtil.empty(oldChar)) {
			return oldChar;
		}
		// 1. 替换全角空格为半角空格
		Pattern p = Pattern.compile("\\u3000");
		Matcher m = p.matcher(oldChar);
		oldChar = m.replaceAll(" ");

		// 2. 多个连续空格处理为单个空格
		p = Pattern.compile("[\\s\\r\\n]{2,}");
		m = p.matcher(oldChar);
		oldChar = m.replaceAll(" ");
		return oldChar;
	}

	public static final Double parseDouble(String src, Double defaultValue)
	{
		try
		{
			if (StringUtil.empty(src) || src.equals("null"))
			{
				return defaultValue;
			}
			return Double.parseDouble(src);
		} catch (NumberFormatException e)
		{
		}
		return defaultValue;
	}

	public static final Double parseDouble(String src) {
		return parseDouble(src, 0d);
	}
	
	public static final int parseInt(String src, int defaultValue)
	{
		if (StringUtil.empty(src) || src.equals("null"))
		{
			return defaultValue;
		}
		try
		{
			return Integer.parseInt(src);
		} catch (NumberFormatException e)
		{
		}
		return defaultValue;
	}

	public static final int parseInt(String src)
	{
		try
		{
			return parseInt(src, 0);
		} catch (Exception e)
		{
			
		}
		return 0;
	}

	public static final Long parseLong(String src, Long defaultValue) {
		try
		{
			if (StringUtil.empty(src) || src.equals("null")) {
				return defaultValue;
			}
			return Long.parseLong(src);
		} catch (NumberFormatException e)
		{
		}
		return defaultValue;
	}

	public static final Long parseLong(String src) {
		return parseLong(src, 0l);
	}
	
}