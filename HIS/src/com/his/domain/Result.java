package com.his.domain;

/**
 * Item result, 计算使用，区别于返回结果
 * @author lsy
 *
 */
public enum Result {

	F ("否", 0),		//false
	T ("是", 1),		//true
	N ("无", 2);		//null
	
	private final String desc;
	
	private final int code;

	private Result(String desc, int code) {
		this.desc = desc;
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public int getCode() {
		return code;
	}
	
	public Result result(int code) {
		if (code == -1) 
			return N;
		if (code == 0)
			return F;
		if (code == 2)
			return N;
		throw new RuntimeException("Unknown result code - " + code);
	}
}
