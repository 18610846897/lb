package com.his.util;

import com.alibaba.fastjson.JSONObject;
import com.his.domain.User;

public class JSONUtil {

	/**
	 * 
	 * @return
	 */
	public static String err1() {
		JSONObject jo = new JSONObject();
		jo.put("err", 1);
		return jo.toJSONString();
	}
	
	public static String err2() {
		JSONObject jo = new JSONObject();
		jo.put("err", 2);
		return jo.toJSONString();
	}
	
	/**
	 * 当项目0返回否时
	 * @return
	 */
	public static String err3() {
		JSONObject jo = new JSONObject();
		jo.put("err", 3);
		return jo.toJSONString();
	}
	
	public static String resultString(User user) {
		JSONObject jo = new JSONObject();
		jo.put("sc", user.getScore());
		jo.put("ev", user.getRank());
		jo.put("as", user.getRank().getDesc());
		return EncryptUtil.encrypt(jo.toJSONString(), EncryptUtil.DES_KEY);
	}
}
