package com.lizf.common.utils;

import java.util.Random;

public class StringUtil {
	// 判断字符串是否为空
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		// 去空格
		str = str.trim();
		//
		if (str.length() == 0) {
			return true;
		}
		return false;
	}

	// 字符串内容不为空，返回true
	public static boolean isNoBlank(String str) {
		return !isBlank(str);
	}

	// 判断字符串是否为手机号
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}

	// 验证是否为邮箱
	public static boolean isEmail(String str) {
		String regex = "[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
    //描述这个方法的作用
	public static boolean isLetter(String str) {
		if (isNoBlank(str)) {
			str=str.toLowerCase();
			String regex="[a-z]+";
			return str.matches(regex);
		}
		return false;
		
	}
	// 获取随机字符(a-z)
	public static char getRandomAzChar() {
		// 随机类
		Random random = new Random();
		// 开始字符在acsii码
		int startChar = 'a' + 0;
		// 生成随机字符
		char newChar = (char) (startChar + random.nextInt(26));
		return newChar;
	}

	// 获取随机字符串
	public static String getRandomLetter(int num) {
		// 保存生成字符
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			char newChar = getRandomAzChar();
			sb.append(newChar);
		}
		return sb.toString();
	}

	// 获取随机数字字符
	public static char getRandomNumberChar() {
		// 随机类
		Random random = new Random();
		// 开始字符在acsii码
		int startChar = '0' + 0;
		// 生成随机字符
		char newChar = (char) (startChar + random.nextInt(10));
		return newChar;
	}

	// 获得随机字符串(a-z0-9)
	public static String getRandomLetterAndNumberStr(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			if (random.nextInt(36) > 10) {
				sb.append(getRandomAzChar());
			} else {
				sb.append(getRandomAzChar());
			}
		}
		return sb.toString();
	}
    
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomLetterAndNumberStr(4));
		}
	}
}
