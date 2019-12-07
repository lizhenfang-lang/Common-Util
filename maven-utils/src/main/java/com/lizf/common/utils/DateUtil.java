package com.lizf.common.utils;


import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/** 
	 * 根据生日计算年龄
	 * @param birthDate
	 * @return
	 */
	public static int getAge(Date birthDate) {
		//获得日历控件
		Calendar calendar=Calendar.getInstance();
		//获得年、月、日
		int nowYear=calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//设置日历控件为生日的时间
		calendar.setTime(birthDate);
		int birthYear = calendar.get(Calendar.YEAR);
	    int birthMonth = calendar.get(Calendar.MONTH);
	    int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
	    //计算年龄
	   int age= nowYear-birthYear;
	   //如果生日的月份大于当前月份时，年龄-1
	   if (birthMonth>nowMonth) {
		       age--;
	       }
	   //如果月份相等，判断日期
	   if (birthMonth==nowMonth && nowDay<birthDay) {
		       age--;
	       }
		return age;
	}
	
	/**
	 * 根据出生日期计算年龄
	 * @param birthDateStr
	 * @return
	 */
	public static int getAge(String birthDateStr) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate=null;
		try {
			//解析日期字符串为Date对象
			birthDate=simpleDateFormat.parse(birthDateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAge(birthDate);
	}
	

	/**
	 * 获取开始日期和结束日期之间有多少天
	 * @param dele1
	 * @param date2
	 * @return int
	 */
	public static int getDayNum(Date dele1,Date date2) {
		//一天有多少毫秒
		Long dayTime=1000*60*60*24L;
		Long startTime=dele1.getTime();
		System.out.println(startTime);
		Long endTime=date2.getTime();
		System.out.println(endTime);
		Double dayNum = Math.abs(((endTime-startTime)/dayTime*1.0));
		System.out.println(dayNum);
		return dayNum.intValue()+1;
	}
	
	/**
	 * 计算指定日期距离今天，过去了多少天或还有多少天
	 * @param date
	 * @return
	 */
	public static int getDayNum(Date date) {
		Date date2=new Date();
		return getDayNum(date,date2);
	}
	
//	public static void main(String[] args) throws ParseException {
//		Date endDate = simpleDateFormat.parse("2019-11-32");
//		System.out.println(getDayNum(endDate));
//	}
	/**
	 * 验证指定日期是否为今天
	 * @param theDate
	 * @return
	 */
	public static boolean isToday(Date theDate) {
		Date nowDate=new Date();
		String nowDateStr=dateFormat.format(nowDate);
		String theDateStr=dateFormat.format(theDate);
		return nowDateStr.equals(theDateStr);
	}
	public static boolean isToday(String theDateStr) {
		try {
			Date theDate=dateFormat.parse(theDateStr);
			return isToday(theDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 判断指定日期是否在本周
	 * @param theDate
	 * @return
	 */
	public static boolean isInWeek(Date theDate) {
		Calendar c=Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowWeek = c.get(Calendar.WEEK_OF_YEAR);
		c.setTime(theDate);
		int theYear = c.get(Calendar.YEAR);
		int theWeek = c.get(Calendar.WEEK_OF_YEAR);
		return nowYear==theYear && nowWeek==theWeek;
	}
	/**
	 * 获取指定日期月份的第一天
	 * @param theDate
	 * @return
	 */
	public static Date getFirstDaateInMonth(Date theDate) {
		Calendar c=Calendar.getInstance();
		c.setTime(theDate);
		c.set(Calendar.DAY_OF_MONTH,1);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		
		return c.getTime();
	}
	/**
	 * 获取指定日期月份的最后一天
	 */
	public static Date getLastDateInMonth(Date theDate) {
		Calendar c=Calendar.getInstance();
		c.setTime(theDate);
		c.add(Calendar.MONTH,1);
		Date firstDateInMonth=getFirstDaateInMonth(c.getTime());
		c.setTime(firstDateInMonth);
		c.add(Calendar.SECOND,-1);
		return c.getTime();
		
	}
	/**
	 * 时间比较
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareTime(Date date1,Date date2) {
		long time1=date1.getTime();
		long time2=date2.getTime();
		if (time1==time2) {
			return 0;
		}
		if (time1>time2) {
			return 1;
		}
		return -1;
		}
	
	public static void main(String [] args) throws ParseException {
		System.out.println(getDayNum(dateFormat.parse("2001-01-01"), dateFormat.parse("2001-01-02")));
	}
}

