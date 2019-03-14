package com.his.calc;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.his.domain.Result;
import com.his.domain.User;
import com.his.resources.Config;
import com.his.resources.JSONConst;
import com.his.resources.Parameter;
import com.his.util.JSONUtil;
import com.his.util.FileUtil;

/**
 * 	计算项目得分
 * @author lsy
 *
 */
public class CalculateScore {

	private static Logger log = Logger.getLogger(CalculateScore.class);
	
	public static String calculate(String json) {
		long start = System.currentTimeMillis();
		JSONObject jo = JSON.parseObject(json);
		User user = new User(jo.getString(JSONConst.NAME), jo.getString(JSONConst.TEL), jo.getString(JSONConst.ID));
		user.setAgeAndGender();
		int gender = user.getGender();
		int age = user.getAge();
		JSONArray noArr = jo.getJSONArray(JSONConst.NO);
		JSONArray valArr = jo.getJSONArray(JSONConst.VAL);
		user.setItem(valArr);
		if (noArr.size() != valArr.size()) {
			log.error("Recieved data error -- no length(" + noArr.size() + " ) != val length(" + valArr.size() +  "). Return error msg - " + JSONUtil.err2());
//			throw new RuntimeException("返回数据错误 -- 项目编号(" + noArr.size() + " )和数据值(" + valArr.size() +  ")长度不一样");
			return JSONUtil.err2();
		}
		
		//当项目0返回(或无)否时，后面算法。返回异常err:3
		if (valArr.getInteger(0) == 0 || valArr.getInteger(0) == -1) {
			user.setScore(Parameter.ITEM0[0][gender]);
			user.rank();
			log.info("Item0 is 0. Finished. Return error msg - " + JSONUtil.err3());
			FileUtil.item0ToZip(user);
			return JSONUtil.err3();
		}
		
		List<int[][]> itemList = Parameter.ITEM_LIST;
		
		//各项得分
		int result[] = new int[Config.ITEM_LEN];
		for (int i = 0; i < Config.ITEM_LEN; i++) {
			int r = valArr.getIntValue(i);
			if (r < 0)
				r = 2;
			int[][] item = itemList.get(i);
			int sc = item[r][gender];
			
			//单独处理年龄
			if (i == 108 && r == 2 && gender == Config.MALE && age > 40) {
				//=IF(AND($O$3="男性",$O$4>40),30,0)
				sc = 30;
			} else if (i == 109 && r == 2 && gender == Config.MALE && age > 40) {
				//=IF(AND($O$3="男性",$O$4>40),30,0)
				sc = 30;
			} else if (i == 184 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 208 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 232 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 240 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 246 && r == Result.T.getCode() && age > 40) {
				//=IF($O$4>40,26,0)
				sc = 26;
			} 
				
			result[i] = sc;
		}
		user.setResult(result);
		
		//总分total
		int f1 = max(sum(result, 1, 4), result[5], result[6], sum(result, 71, 75), sum(result, 77, 80), result[7]
				, sum(result,27,37), sum(result, 39, 47), result[8], result[9], result[10], result[11], result[12]
				, result[26], result[38], result[48], result[55], result[61], result[64], result[70], result[76], result[81]
				, result[108], result[109], result[121], result[128], result[144], result[156], result[160], result[163]
				, result[176], result[184], result[195], result[208], result[225], min(result[232], result[240]), result[246]
				, result[257], result[268], result[275], result[284], result[295], result[303], result[308], result[313]
				, result[317], result[322], result[327], result[330], result[336], result[342], result[348], result[354]
				, result[360], result[366], result[372]);
//		System.out.println("formula 1 == " + f1);
					
		int f2 = max(sum(result, 21, 25), sum(result, 130, 133), max(sum(result, 331, 335), sum(result, 337, 341), sum(result, 343, 347), sum(result, 349, 353), sum(result, 355, 359), sum(result, 361, 365), sum(result, 367, 371))) 
				+ max(sum(result, 49, 54), sum(result, 56, 60), sum(result, 62, 63), sum(result, 65, 69)) 
				+ max(result[165], result[169], sum(result, 258, 262), sum(result, 263, 267)) 
				+ max(sum(result, 233, 239), sum(result, 241, 245)) 
				+ max(sum(result, 276, 283), sum(result, 285, 294)) 
				+ max(sum(result, 304, 307), sum(result, 309, 312), sum(result, 314, 316), sum(result, 318, 321), sum(result, 323, 326));
//		System.out.println("formual 2 == " + f2);
		
		int f3 = sum(sum(result, 13, 20), sum(result, 82, 107), sum(result, 110, 120), sum(result, 122, 127), result[129]
				, sum(result, 134, 143), sum(result, 145, 155), sum(result, 157, 159), sum(result, 161, 162), result[164]
				, sum(result, 166, 168), sum(result, 170, 175), sum(result, 177, 183), sum(result, 185, 194)
				, sum(result, 196, 207), sum(result, 209, 224), sum(result, 226, 231), sum(result, 247, 256)
				, sum(result, 269, 274), sum(result, 296, 302), sum(result, 328, 329), sum(result, 379, 382));
		
//		System.out.println("formula 3 == " + f3);
		//公式4: IF(D374="是",E374,MAX(E375,E378)+E377+E376+E373)
		int f4 = 0;
		if (valArr.getInteger(374) == Result.T.getCode()) {
			f4 = result[374];
		} else {
			f4 = max(result[375], result[378]) + result[377] + result[376] + result[373];
		}
//		System.out.println("formula 4 == " + f4);
		
		//max1 = MAX(SUM(E331:E335),SUM(E337:E341),SUM(E343:E347),SUM(E349:E353),SUM(E355:E359),SUM(E361:E365),SUM(E367:E371))
		int max1 = max(sum(result, 331, 335), sum(result, 337, 341), sum(result, 343, 347), sum(result, 349, 353)
				, sum(result, 355, 359), sum(result, 361, 365), sum(result, 367, 371));
		
		//公式5 if(if5>0,25,0)
		int f5 = 0;
		int if5 = min(sum(result, 21, 25) + sum(result, 130, 133), sum(result, 21, 25) + max1, sum(result, 130, 133) + max1);
		if (if5 > 0) {
			f5 = 25;
		}
//			System.out.println("formula 5 == " + f5);
		//公式6
		int f6 = 0;
		if (min(max1, f4) > 0) {
			f6 = 25;
		}
//		System.out.println("formula 6 == " + f6);
		//公式7=IF(AND(D6="是",D76="是"),30,0)
		int f7 = 0;
		if (valArr.getInteger(6) == Result.T.getCode() && valArr.getInteger(76) == Result.T.getCode()) {
			f7 = 30;
		}
//		System.out.println("formula 7 == " + f7);
		
		int f8 = 0;
		//公式8=IF(AND(D7="是",OR(D26="是",D38="是")),30,0)
		if (valArr.getInteger(7) == Result.T.getCode() && (valArr.getInteger(26) == Result.T.getCode() || valArr.getInteger(38) == Result.T.getCode())) {
			f8 = 30;
		}
//		System.out.println("formula 8 == " + f8);
		
		user.setScore(f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8);
		user.rank();
//		System.out.println("user : " + user.printAllInfo());
		long end = System.currentTimeMillis();
//		System.out.println("cost time : " + (end - start) + "(ms)");
		long cost = end - start;
		log.info(user.printLog(cost));
		FileUtil.resultToZip(user);
		return JSONUtil.resultString(user); 
		
		
	}
	
	public static int[] toValArr(JSONArray ja) {
		int[] val = new int[Config.ITEM_LEN];
		for (int i = 0; i < Config.ITEM_LEN; i++) {
			int sc = ja.getIntValue(i);
			if (sc < 0)
				sc = 2;
			val[i] = sc;
		}
		return val;
	}
	
	

	public static int sum(int...args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
	
	
	/**
	 * sum: arr[start, end]
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int sum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static int max(int...args) {
		int max = args[0];
		for (int i = 1; i < args.length; i++) {
			if (max < args[i])
				max = args[i];
		}
		return max;
	}
	
	public static int min(int a, int b) {
		return Math.min(a, b);
	}
	
	public static int min(int...args) {
		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			min = Math.min(min, args[i]);
		}
		return min;
	}
	
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
}
