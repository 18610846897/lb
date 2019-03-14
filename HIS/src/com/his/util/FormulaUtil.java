package com.his.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

import com.his.exception.FormulaHandlerException;

/**
 * 解析excel公式
 * java中的公式以CaculateScore中的公式为准
 * @author lsy
 */
public class FormulaUtil {
	
	/**
	 * 左括号 
	 */
	public static final String LB = "(";
	
	/**
	 * right bracket
	 */
	public static final String RB = ")";
	
	/**
	 * comma
	 */
	public static final String CM = ",";
	
	/**
	 * 冒号：colon
	 */
	public static final String CL = ":";
	
	
	/**
	 * 公式名称
	 * 大写为excel
	 * 小写为Java方法
	 */
	
	public static final String MAX = "MAX";
	public static final String max = "max(";
	
	public static final String MIN = "MIN";
	public static final String min = "min(";
	
	public static final String SUM = "SUM";
	public static final String sum = "sum(";
	
	public static final String AND = "AND";
	public static final String and = "and(";
	
	public static final String IF = "IF";
	public static final String _if = "if(";
	
	public static final String PLUS = "+";
	
	public static final String P = "MSAI";		//max/min sum and if
	
	/**
	 * 各项得分结果，包括项目0
	 */
	public static final String result = "result";
	
	public static final String col = "E";
	
	/**
	 * 将excel公式解析成java代码。计算中不含项目0
	 * excel中的表示行的数字应该和result保持一致，即E186对应result[186]的分数
	 * @param excelFormula
	 * @return
	 */
	public static String excelToJava(String excelFormula) {
		//列号
		
		
		return "";
	}
	
	/**
	 * @param str
	 * @param col
	 * @return
	 * @throws FormulaHandlerException
	 */
	public static String convert(String str, char col) throws FormulaHandlerException {
		String ret = "";
		int header = 0;	//首指针
		int len = str.length();
		int tail = len;	//尾指针
		if (isCell(str)) {
			System.out.println("cell...");
		} else {
			String formula = formula(str);
			switch (formula) {
			case MAX:
				ret = max;
				header = 4;
				break;
			case SUM:
				ret = sum;
				header = 4;
				break;
			case MIN:
				ret = min;
				header = 4;
				break;
			case AND:
				ret = and;
				header = 4;
				break;
			case IF:
				header = 3;
				ret = _if;
				break;
			default:
				throw new FormulaHandlerException("Cannot handle this formula - " + str);
			}
			
			
			while(header <= len) {
				String substr = "";
			}
		}
		return "";
	}
	
	public static String convert(String input, String cur) throws FormulaHandlerException {
		String[] arr = input.split(CM);
		for (int i = 0; i < arr.length; i++) {
			String f = formula(arr[0]);
			if (null != f) {
				switch (f) {
				case MAX:
					cur += max;
					break;
				case SUM:
					cur = cur + sum + result + ",";
					break;
				case MIN:
					cur += min;
					break;
				case AND:
					cur += and;
					break;
				case IF:
					cur += _if;
					break;
				default:
					throw new FormulaHandlerException("Cannot handle this formula - " + cur);
				}
			}
		}
		return cur;
	}
	
	public static boolean stop(String s) {
		return CM.equals(s) || RB.equals(s);
	}
	
	public static String formula(String input) {
		Pattern p = Pattern.compile("(max|sum|if|and)\\(.*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(input);
		if (matcher.find())
			return matcher.group(1).toUpperCase();
		return null;
	}
	
	public static boolean isCell(String input) {
		Pattern p = Pattern.compile(col + "\\d+", Pattern.CASE_INSENSITIVE);
		return p.matcher(input).find();
	}
	
	
	public static void main(String[] args) {
		String col = "e";
		String p = col + "\\d+";
		String p1 = "(max|sum|if|and)\\(.*";
		String e1 = "\\w*E\\d+\\w*";
		Pattern pt = Pattern.compile(p1);
		String s1 = "MAX(SUM(E23:E27)";
		String m1 = "max(max";
		System.out.println(Pattern.matches(e1, s1));
//		while(mather.find()) {
//			System.out.println(mather.group(2));
//		}
		
		
//		System.out.println(isMax(s));
		
	}
	
	
	
}