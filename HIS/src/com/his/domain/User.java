package com.his.domain;

import com.alibaba.fastjson.JSONArray;
import com.his.resources.Config;
import com.his.util.IDUtil;

public class User {

	private String name;
	
	private String tel = "";
	
	private String id;
	
	private int age;
	
	private int score;
	
	private int gender = 0;					//male=0; female=1;
	
	private Rank rank;

	private JSONArray item;					//各项返回值(0,1,-1); 共354项，包括项目0
	
	private int[] result;					//各项得分， 共353项，不包括项目0。
	
	public User() {
		super();
	}
	

	public User(String name, String tel, String id) {
		super();
		this.name = name;
		this.tel = tel;
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


	public JSONArray getItem() {
		return item;
	}

	public void setItem(JSONArray item) {
		this.item = item;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}


	/**
	 *	 根据score结果获取rank评分
	 * @return Rank.A/B/C/D/E
	 */
	public Rank rank() {
		if (score < 0)
			throw new RuntimeException("Score error - " + score);
		
		if (score < 11) {
			//[0, 10]
			this.rank = Rank.A;
		} else if (score < 26) {
			//[11, 25]
			this.rank = Rank.B;
		} else if (score < 51) {
			//[26, 50]
			this.rank = Rank.C;
		} else if (score < 76) {
			//[51, 75]
			this.rank = Rank.D;
		} else {
			//>=75
			this.rank = Rank.E;
		}
		return this.rank;
	}
	
	public void setAgeAndGender() {
		int[] info = IDUtil.getInfo(this.id);
		this.age = info[1];
		this.gender = info[0];
	}
	
	public String printAllInfo() {
		String g = gender == Config.MALE ? "男" : "女";
		return "User: " + this.name + ", age: " + this.age + ", gender: " + g + ", score: " + this.score + ", rank: " + rank + "(" + rank.getDesc() + ")"
				+ ", item:" + item.toJSONString() + ", result:" + printArr(result);
	}
	
	public String printLog(long costTime) {
		return "User: " + this.name + ", id: " + this.id + ", cost: " + costTime + "(ms)";
	}
	
	public String printUserBase() {
		String g = gender == Config.MALE ? "男" : "女";
		return "name: " + this.name + ", id: " + this.id + ", tel: " + this.tel + ", gender: " + g + ", age: " + this.age;
	}
	
	public String printScore() {
		return "score: " + this.score + ", rank: " + this.rank + "(" + this.rank.getDesc() + ")";
	}
	
	public String printTestResult() {
		String g = gender == Config.MALE ? "男" : "女";
		return this.name + "," + this.id + "," + this.age + "," + g + "," + this.score + "," + this.rank + "(" + this.rank.getDesc() + ")";
	}
	
	public static String printArr(int[] arr) {
		String s = "[";
		for (int i = 0; i < arr.length; i++) {
			s = s + arr[i] + ", ";
		}
		return s.substring(0, s.length() - 2) + "]";
	}
	
	public String printResult() {
		String s = "" + result[0];
		for (int i = 1; i < result.length; i++) {
			s = "," + result[i];
		}
		return s;
	}
	
}
