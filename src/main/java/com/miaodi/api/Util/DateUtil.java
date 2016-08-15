package com.miaodi.api.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil
{
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);
	public static final int SECONDS_IN_DAY = 60 * 60 * 24;
	public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
	private static ThreadLocal<SimpleDateFormat> sdfMonth = new ThreadLocal<SimpleDateFormat>();
	private static ThreadLocal<SimpleDateFormat> sdfShort = new ThreadLocal<SimpleDateFormat>();
	private static ThreadLocal<SimpleDateFormat> sdfFullStr = new ThreadLocal<SimpleDateFormat>();
	private static ThreadLocal<SimpleDateFormat> sdfGeneral = new ThreadLocal<SimpleDateFormat>();
	
	private static SimpleDateFormat getSdfMonth()
	{
		SimpleDateFormat sdf = sdfMonth.get();
		if(sdf == null)
		{
			sdf = new SimpleDateFormat("yyyyMM");
			sdfMonth.set(sdf);
		}
		return sdf;
	}	
	
	private static SimpleDateFormat getSdfShort()
	{
		SimpleDateFormat sdf = sdfShort.get();
		if(sdf == null)
		{
			sdf = new SimpleDateFormat("yyyyMMdd");
			sdfShort.set(sdf);
		}
		return sdf;
	}
	
	private static SimpleDateFormat getSdfFullStr()
	{
		SimpleDateFormat sdf = sdfFullStr.get();
		if(sdf == null)
		{
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			sdfFullStr.set(sdf);
		}
		return sdf;
	}
	
	private static SimpleDateFormat getSdfGeneral()
	{
		SimpleDateFormat sdf = sdfGeneral.get();
		if(sdf == null)
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdfGeneral.set(sdf);
		}
		return sdf;
	}
	
	/**
	 * 在date的基础上加减
	 * 
	 * @param date
	 * @param count
	 * @param type
	 *            Calendar.MONTH等
	 * @return
	 */
	public static Date changTime(Date date, int count, int type)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(type, count);

		return calendar.getTime();
	}

	/**
	 * 获取day of month
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static boolean isYYYYMMDDHHMMSS(String patternString)
	{
		// 正则表达式
		Pattern a = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher b = a.matcher(patternString);
		if (b.matches())
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * 下个月的1号
	 * 
	 * @param date
	 * @return
	 */
	public static Date toNextMonthStart(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 加指定天数,可正可负
	 * 
	 * @param date
	 * @param dayCount
	 * @return
	 */
	public static Date addDay(Date date, int dayCount)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_YEAR, dayCount);

		return calendar.getTime();
	}

	/**
	 * 加指定月数,可正可负
	 * 
	 * @param date
	 * @param count
	 * @return
	 */
	public static Date addMonth(Date date, int count)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MONTH, count);

		return calendar.getTime();
	}

	/**
	 * 到与本月相隔指定月数的开始
	 * 
	 * @param date
	 * @return
	 */
	public static Date toMonthStart(Date date, int monthBiasCount)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(Calendar.MONTH, monthBiasCount);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 转为一天的开始
	 * 
	 * @param date
	 * @return
	 */
	public static Date toDateStart(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 转为一天的结束
	 * 
	 * @param date
	 * @return
	 */
	public static Date toDateEnd(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 是否同年同月
	 * 
	 * @param date
	 * @return
	 */
	public static boolean ifSameYearMonth(Date startTime, Date endTime)
	{
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(startTime);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(endTime);

		if (calStart.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR)
				&& calStart.get(Calendar.MONTH) == calEnd.get(Calendar.MONTH))
		{
			return true;
		}

		return false;
	}

	/**
	 * 本月末尾，精确到秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date toMonthEnd(Date timeInMonth)
	{
		Date nextStart = toNextMonthStart(timeInMonth);
		return new Date(nextStart.getTime() - 1000L);
	}

	// 按月分割时间段
	public static List<Map<String, Date>> splitByMonth(Date startTime, Date endTime)
	{
		List<Map<String, Date>> pairList = new ArrayList<Map<String, Date>>();
		if (ifSameYearMonth(startTime, endTime)) // 同一个月，不用分割
		{
			Map<String, Date> dateMap = new HashMap<String, Date>();
			dateMap.put("startTime", startTime);
			dateMap.put("endTime", endTime);
			pairList.add(dateMap);
		} else
		{
			Map<String, Date> dateMap = new HashMap<String, Date>();
			dateMap.put("startTime", startTime);
			dateMap.put("endTime", toMonthEnd(startTime));
			pairList.add(dateMap);

			pairList.addAll(splitByMonth(toNextMonthStart(startTime), endTime)); // 循环调自己
		}

		return pairList;
	}

	/**
	 * 比较时间部分
	 * 
	 * @param dateOne
	 * @param dateTwo
	 * @return dateOne 是否大于等于 dateTwo
	 */
	public static boolean compareTime(Date dateOne, Date dateTwo)
	{
		Calendar calOne = Calendar.getInstance();
		calOne.setTime(dateOne);
		Calendar calTwo = Calendar.getInstance();
		calTwo.setTime(dateTwo);

		// 年月日设为相同值
		calOne.set(2000, 1, 1);
		calTwo.set(2000, 1, 1);

		return calOne.getTimeInMillis() >= calTwo.getTimeInMillis();
	}

	/**
	 * 速度控制
	 * 
	 * @param now
	 * @param lastTime
	 * @param minTime
	 */
	public static void speedControl(long end, long start, long minTime)
	{
		if ((end - start) < minTime)
		{
			try
			{
				Thread.sleep(minTime - end + start);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 以yyyy-MM-dd HH:mm:ss格式解析字符串为日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseGeneral(String str)
	{
		try
		{
			return getSdfGeneral().parse(str);
		} catch (ParseException e)
		{
			log.error("parseGeneral error", e);
		}
		return null;
	}

	/**
	 * 以yyyyMMdd HH:mm格式解析字符串为日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseOne(String str)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
		try
		{
			return sdf.parse(str);
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
		}
		return null;
	}

	/**
	 * 以yyyyMMdd HH:mm:ss格式解析字符串为日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseTwo(String str)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		try
		{
			return sdf.parse(str);
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
		}
		return null;
	}

	/**
	 * 以yyyy-MM-dd格式解析字符串为日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date parse(String str)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return sdf.parse(str);
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
		}
		return null;
	}

	/**
	 * date转为字符串
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseDate(String str)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try
		{
			return sdf.parse(str);
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
		}
		return null;
	}


	/**
	 * 已yyyy-MM-dd HH:mm:ss格式返回字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String formateGeneral(Date date)
	{
		return getSdfGeneral().format(date);
	}

	/**
	 * 以yyyyMMddHHmmss格式返回字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String formateFullStr(Date date)
	{
		return getSdfFullStr().format(date);
	}

	/**
	 * 以yyyyMMddHHmmss格式解析字符串
	 * 
	 * @param str
	 * @return
	 */
	public static Date parseFullStr(String dateStr)
	{
		try
		{
			return getSdfFullStr().parse(dateStr);
		} catch (ParseException e)
		{
			log.error("parseFullStr error", e);
			return null;
		}
	}

	/**
	 * 获取格式字符串yyyyMM
	 * @param date
	 * @return
	 */
	public static String getMonthString(Date date)
	{
		return getSdfMonth().format(date);
	}	
	
	/**
	 * 获取格式字符串 yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date)
	{
		return getSdfShort().format(date);
	}
	
	/**
	 * 到指定年份的末尾
	 * 
	 * @param date
	 *            初始年
	 * @param yearDelta
	 *            年的变化数，支持正负数
	 * @return
	 */
	public static Date toYearEnd(Date date, int yearDelta)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, yearDelta + 1); // 先往前一年

		calendar.add(Calendar.DAY_OF_YEAR, -(calendar.get(Calendar.DAY_OF_YEAR) + 1)); // 减去天数

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * 将秒数格式化为 x小时x分x秒
	 * 
	 * @param count
	 * @return
	 */
	public static String formatTime(int count)
	{
		int hour = 0;
		int min = 0;
		int second = 0;

		if (count >= 3600)
		{
			int temp = count % 3600;
			hour = count / 3600;
			if (temp != 0)
			{
				if (temp >= 60)
				{
					min = temp / 60;
					second = temp % 60;
				} else
				{
					second = temp;
				}
			}
			return hour + "时" + min + "分" + second + "秒";
		} else if (count >= 60)
		{
			min = count / 60;
			second = count % 60;
			return min + "分" + second + "秒";
		} else
		{
			return count + "秒";
		}
	}

	/**
	 * 当前时间减去指定时间，得到天数
	 * 
	 * @param date
	 *            指定时间
	 * @return
	 */
	public static long subtractionDay(String date)
	{
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间

		String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串

		try
		{
			long result = (d.parse(nowtime).getTime() - d.parse(date).getTime()) / 86400000;// 当前时间减去测试时间
																							// 这个的除以1000得到秒，相应的60000得到分，3600000得到小时，86400000得到天
			log.info("当前时间-指定时间 = " + result + "天");
			return result;
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
			return 0;

		}
	}

	/**
	 * 指定时间减去2小时的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date before2Hours(Date date)
	{
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间

		try
		{
			long time = d.parse(d.format(date)).getTime();// 当前系统时间戳

			long pointtime = time - 7200000;

			Date current = new Date(pointtime);// 减去2小时后的时间对象

			String currstr = d.format(current);

			log.info("系统2小时前的时间：" + currstr);

			return current;

		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取上周第一天的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String monday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周二的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String tuesday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周三的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String wednesday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周四的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String thursday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周五的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String friday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周六的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String saturday()
	{
		Calendar cal = Calendar.getInstance();
		// n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		int n = -1;
		String monday;
		cal.add(Calendar.DATE, n * 7);
		// 想周几，这里就传几Calendar.MONDAY（MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,STATURDAY,SUNDAY）
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		monday = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
		return monday;
	}

	/**
	 * 获取上周日的日期，日期格式为 20151103
	 * 
	 * @return
	 */
	public static String sunday()
	{
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		c.add(Calendar.WEEK_OF_MONTH, -1);
		String monday = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
		return monday;
	}

	/**
	 * 上个月第一天
	 * 
	 * @return
	 */
	public static String MonthFirstDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String month = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		return month;
	}

	/**
	 * 上个月最后一天
	 * 
	 * @return
	 */
	public static String MonthLastDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		String month = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		return month;
	}

	/**
	 * date月第一天
	 * 
	 * @return
	 */
	public static String MonthFirstDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String month = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		return month;
	}

	/**
	 * date月最后一天
	 * 
	 * @return
	 */
	public static String MonthLastDay(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		// 最后一天
		String month = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		return month;
	}

	/**
	 * 获取某月的天数
	 * 
	 * @param dyear
	 * @param dmouth
	 * @return
	 */
	public static int calDayByYearAndMonth(String dyear, String dmouth)
	{
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
		Calendar rightNow = Calendar.getInstance();
		try
		{
			rightNow.setTime(simpleDate.parse(dyear + "/" + dmouth));
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);// 根据年月 获取月份天数
	}

	/**
	 * 获取2个时间差，分钟数
	 */
	public static long getMunites(String fixDate)
	{

		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");// 格式化时间
		String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串

		try
		{
			long result = (d.parse(nowtime).getTime() - d.parse(fixDate).getTime()) / 60000;// 当前时间减去测试时间
																							// 这个的除以1000得到秒，相应的60000得到分，3600000得到小时，86400000得到天
			log.info("当前时间-指定时间 = " + result + "分钟");
			return result;
		} catch (ParseException e)
		{
			log.error(e.toString(), e);
			return 0;

		}
	}
	
	/**
	 * 判断是否是同一天
	 * @param ms1
	 * @param ms2
	 * @return
	 */
	public static boolean isSameDayOfMillis(final long ms1, final long ms2) 
	{
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }
	
	private static long toDay(long millis) 
	{
		return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
	}

	public static void main(String[] args)
	{
		getMunites("20150227104718");
	}
}