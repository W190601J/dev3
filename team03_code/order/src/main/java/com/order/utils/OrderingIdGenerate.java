package com.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//本类用于随机生成订单主键，共20位
public class OrderingIdGenerate {
	
	public static String generate() {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String x = sf.format(date);
		String y = random();
		y += x;
		return y;
		
	}
	
	
	public static String random() {
		//用到一个随机类，产生[100000,999999)范围共6位随机数字。
		Random random = new Random();
		String y = String.valueOf(random.nextInt(899999)+100000);
		return y;
		
	}
}
