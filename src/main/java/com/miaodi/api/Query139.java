package com.miaodi.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Query139
{
	public static void main(String[] args)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH:mm");
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, -1);
		String reqTime = sdf.format(cal.getTime());
		String url  = "http://121.15.167.240:48080/coremailNotifyThree/qmySmsStatusQuery?" + "?RequestTime=" + reqTime + "&SpNumber=" + "1065813911111";
		String rs = "";
		try
		{
			rs = get(url);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("rs=" + rs);
	}
	
	// 发送请求
    public static String get(String url) throws Exception
    {
        String result = "";
        BufferedReader in = null;
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setRequestProperty("accept", "*/*");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(20000);
        in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
        String line = "";
        while ((line = in.readLine()) != null)
        {
            result += line;
            result += "\n";
        }
        // 删除最后多余的换行符
        if (!result.equals(""))
            result = result.substring(0, result.lastIndexOf("\n"));
        return result;
    }
}
