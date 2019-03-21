package com.his.calc;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.his.domain.Result;
import com.his.domain.User;
import com.his.exception.FormulaHandlerException;
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
	
	public static String calculate(String json) throws FormulaHandlerException {
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
		//i：项目序号
		for (int i = 0; i < Config.ITEM_LEN; i++) {
			int r = valArr.getIntValue(i);
			if (r < 0) {
				r = 2;
			}
			int[][] item = itemList.get(i);
			int sc = item[r][gender];
			
			//单独处理年龄
			if (i == 109 && r == 2 && gender == Config.MALE && age > 40) {
				//=IF(AND($O$3="男性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 110 && r == 2 && gender == Config.MALE && age > 40) {
				//=IF(AND($O$3="男性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 189 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),11,0)
				sc = 11;
			} else if (i == 215 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),26,0)
				sc = 26;
			} else if (i == 239 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),10,0)
				sc = 10;
			} else if (i == 248 && r == Result.T.getCode() && gender == Config.FEMALE && age > 40) {
				//=IF(AND($O$3="女性",$O$4>40),10,0)
				sc = 10;
			} else if (i == 254 && r == Result.T.getCode() && age > 40) {
				if (gender == Config.MALE) {
					sc = 11;
				} else {
					sc = 5;
				}
			} 
				
			result[i] = sc;
		}
		user.setResult(result);
		int score = formula(result, valArr);
		user.setScore(score);
		user.rank();
		long end = System.currentTimeMillis();
		long cost = end - start;
//		System.out.println(user.printScore());
		log.info(user.printLog(cost));
		FileUtil.resultToZip(user);
		return JSONUtil.resultString(user); 
		
		
	}
	
	public static int formula(int[] result, JSONArray valArr) throws FormulaHandlerException {
		int f1 = max(max(result, 1, 4), result[5], result[6], max(result, 71, 75), max(result, 77, 80), result[7], max(result, 27, 37), max(result, 39, 47), result[8], result[9], result[10], result[11], result[12], result[26], result[38], result[48], result[55], result[61], result[64], result[70], result[76], result[81], result[109], result[110], result[122], result[130], result[146], result[158], result[163], result[167], result[181], result[189], result[200], result[215], result[232], min(result[239], result[248]),result[254], result[266], result[277], result[284], result[293], result[304], result[312], result[317], result[322], result[326], result[331], result[336], result[339], result[345], result[351], result[357], result[363], result[369], result[375], result[381]);
		
		int f2 = max(max(result, 13, 25), max(result, 340, 344), max(result, 346, 350), max(result, 352, 356), max(result, 358, 362), max(result, 364, 368), max(result, 370, 374), max(result, 376, 380)) + max(max(result, 49, 54), max(result, 56, 60), max(result, 62, 63), max(result, 65, 69)) + max(max(result, 267, 271), max(result, 272, 276)) + max(max(result, 285, 292), max(result, 294, 303))+max(max(result, 313, 316), max(result, 318, 321), max(result, 323, 325), max(result, 327, 330), max(result, 332, 335)) + sum(result[108], sum(result, 111, 121), sum(result, 388, 391), sum(result, 278, 283), sum(result, 305, 311), sum(result, 337, 338));
		
		int f3 = max(max(result, 82, 107), max(result, 123, 129), max(result, 131, 145), max(result, 147, 157), max(result, 159, 162), max(result, 164, 166), max(result, 168, 180), max(result, 182, 188), max(result, 190, 199), max(result, 201, 214), max(result, 216, 231), max(result, 233, 238), max(result, 240, 247), max(result, 249, 253), max(result, 255, 265));
		
		int f4 = 0;
		//IF(H395=1,I395,MAX(I396,I399)+I398+I397+I394)
		if (valArr.getInteger(383) == 1 ) {
			f4 = result[383];
		} else {
			f4 = max(result[384], result[387]) + result[386] +result[385] + result[382];
		} 
		System.out.println("f4 == " + f4);
		
		//IF(AND(H18=1,H88=1),30,0)
		int f5 = 0;
		if (valArr.getInteger(6) == 1 && valArr.getInteger(76) == 1) {
			f5 = 30;
		}
		System.out.println("f5 == " + f5);
		
		int f6 = 0;
		//=IF(AND(H19=1,OR(H38=1,H50=1)),30,0)
		if (valArr.getInteger(7) == 1 && (valArr.getInteger(26) == 1 || valArr.getInteger(38) == 1)) {
			f6 = 30;
		}
		System.out.println("f6 == " + f6);
		return f1 + f2 + f3 + f4 + f5 + f6; 
	}
	
	public static int[] toValArr(JSONArray ja) {
		int[] val = new int[Config.ITEM_LEN];
		for (int i = 0; i < Config.ITEM_LEN; i++) {
			int sc = ja.getIntValue(i);
			if (sc < 0) {
				sc = 2;
			}
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
			if (max < args[i]) {
				max = args[i];
			}
		}
		return max;
	}
	
	public static int max(int[] arr, int start, int end) throws FormulaHandlerException {
		if (start > end) {
			throw new FormulaHandlerException("Formula max() error -- start index greater than end index");
		}
		int max = arr[start];
		for (int i = start + 1; i < end + 1; i++) {
			max = Math.max(arr[i], max);
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
	
	public static int min(int[] arr, int start, int end) throws FormulaHandlerException {
		if (start > end) {
			throw new FormulaHandlerException("Formula min() error -- start index greater than end index");
		}
		int min = arr[start];
		for (int i = start + 1; i < end + 1; i++) {
			min = Math.min(arr[i], min);
		}
		return min;
	}
	
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
}
