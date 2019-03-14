package com.his.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.his.resources.Config;

/**
 * 根据身份证得到性别和年龄
 * @author lsy
 *
 */
public class IDUtil {

	/**
	 * 
	 * @param id
	 * @return {性别(0男，1女)，年龄}
	 */
	public static int[] getInfo(String id) {
		if (id == null || (id.length() != 15 && id.length() != 18)) 
			throw new RuntimeException("Illegal id - " + id);
		
		if (id.length() == 15)
			return getInfo15(id);
		if (id.length() == 18)
			return getInfo18(id);
		
		throw new RuntimeException("Illegal id - " + id);
	}
	
	/**
	 * <p>
	 * 判断18位身份证的合法性
	 * </p>
	 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
	 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
	 * <p>
	 * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
	 * </p>
	 * <p>
	 * 1.前1、2位数字表示：所在省份的代码；
	 * 2.第3、4位数字表示：所在城市的代码； 
	 * 3.第5、6位数字表示：所在区县的代码；
	 * 4.第7~14位数字表示：出生年、月、日； 
	 * 5.第15、16位数字表示：所在地的派出所的代码；
	 * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
	 * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
	 * </p>
	 * <p>
	 * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	 * 2.将这17位数字和系数相乘的结果相加。
	 * </p>
	 * @param id
	 * @return [性别，年龄]， 性别：男（0），女（1）
	 */
	public static int[] getInfo18(String id) {
		int[] res = new int[2];
		String gender = id.substring(16, 17);
		if (Integer.parseInt(gender) % 2 == 0) {
			res[0] = Config.FEMALE;
		} else {
			res[0] = Config.MALE;
		}
		String date = id.substring(6, 14);
		LocalDate now = LocalDate.now();
		LocalDate birthday = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
//		int age = (int)birthday.until(now, ChronoUnit.YEARS);
		int age = now.getYear() - birthday.getYear();
		res[1] = age;
		return res;
	}
	
	/**
	 * 15位身份证号码各位的含义:
		1-2位省、自治区、直辖市代码；
		3-4位地级市、盟、自治州代码；
		5-6位县、县级市、区代码；
		7-12位出生年月日,比如670401代表1967年4月1日,与18位的第一个区别；
		13-15位为顺序号，其中15位男为单数，女为双数；
		与18位身份证号的第二个区别：没有最后一位的验证码。
	 * 15位身份证
	 * @param id
	 * @return
	 */
	public static int[] getInfo15(String id) {
		int[] res = new int[2];
		String gender = id.substring(14, 15);
		if (Integer.parseInt(gender) % 2 == 0) {
			res[0] = Config.FEMALE;
		} else {
			res[0] = Config.MALE;
		}
		String date = "19" + id.substring(6, 12);
//		LocalDate now = LocalDate.now();
		LocalDate birthday = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
		int birthYear = birthday.getYear();
//		int age = (int)birthday.until(now, ChronoUnit.YEARS);
		int age = LocalDate.now().getYear() - birthYear;
		res[1] = age;
		return res;
	}
	
	public static String getUUID32(){
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		return uuid;
	}
	
}
