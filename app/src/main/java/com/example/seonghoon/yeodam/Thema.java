package com.example.seonghoon.yeodam;

import java.util.ArrayList;

public class Thema {

	
	//aseet 을 불러오는 부분을 Activity 에서 -> 백엔드 처리 ->  Activity 에서 동작  
	// 안에서 쓰레드를 하나 만들어서 처리 
	
	// Context 를 선언해서 동작 <bad> 
	private String themaName;		// 이름
	private int themaId; 			// 코드
	private String themaReward;		// 테마 리워드
	ArrayList<Integer> sceneCodeList = new ArrayList<Integer>();	//씬 코드 집합
	
	
	public String getThemaName() {
		return themaName;
	}
	public void setThemaName(String themaName) {
		this.themaName = themaName;
	}
	public int getThemaId() {
		return themaId;
	}
	public void setThemaId(int themaId) {
		this.themaId = themaId;
	}
	public String getThemaReward() {
		return themaReward;
	}
	public void setThemaReward(String themaReward) {
		this.themaReward = themaReward;
	}
	
	public void addSceneCode(Integer sceneCode) { 
		sceneCodeList.add(sceneCode);
	}
	
}
