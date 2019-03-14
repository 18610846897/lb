package com.his.domain;

public enum Rank {
	A ("超优体"),
	B ("优选体"),
	C ("标准体"),
	D ("临近标准体"),
	E ("不接受");
	
	
	
	private final String desc;
	
	
	private Rank(String desc) {
		this.desc = desc;
	}


	public String getDesc() {
		return desc;
	}
}
