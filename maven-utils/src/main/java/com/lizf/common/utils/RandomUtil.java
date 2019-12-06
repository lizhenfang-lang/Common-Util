package com.lizf.common.utils;

import java.util.Random;

public class RandomUtil {
	/**
	 * 获得最大数和最小数之间的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min,int max) {
		Random random=new Random();
		return min+random.nextInt(max-min+1);
	}
	/**
	 * 获得最大数和最小数之间的多个随机数
	 * @param min
	 * @param max
	 * @param num
	 * @return
	 */
	public static int[] random(int min,int max,int num) {
		int[] intArray=new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i]=random(min, max);
		}
		return intArray;
	}
}
