package com.example.seonghoon.yeodam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Plan {

	private ArrayList<Integer> sceneCodeList;	//씬 코드 집합	
	private String planName;		// 이름
	private int planCode; 			// 코드
	private Date startDate;				//여행 시작날짜
	private Date endDate;				//여행 종료날짜
	
	public Plan() { 
		sceneCodeList = new ArrayList<Integer>();
		startDate = new Date();
		endDate = new Date();
	}
	
	public Plan(String planName , int planCode, Date startDate, Date endDate){
		
		sceneCodeList = new ArrayList<Integer>();
		this.planName = planName;
		this.planCode = planCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	//복사 생성자
	public Plan(Plan cartList) {
		planName = cartList.getPlanName();
		planCode = cartList.getPlanCode();
		startDate = cartList.getStartDate();
		endDate = cartList.getEndDate();
		sceneCodeList = cartList.getSceneCodeList();
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getPlanCode() {
		return planCode;
	}
	public void setPlanCode(int planCode) {
		this.planCode = planCode;
	}
	public Date getStartDate() {
		return startDate;
	}
	
	public int addSceneCode(Integer sceneCode) { 
		// 중복을 검사
		for(int i : sceneCodeList) {
			
			if(sceneCodeList.get(i)==sceneCode);
			return -1;
		}
		//씬 코드를 등록함
		sceneCodeList.add(sceneCode);
		return 0;
	}
	
	public void setStartDate(Long Date) throws ParseException { 
		
		startDate.setTime(Date); ;

	}
	public Date getEndDate() {
		return endDate;
	}
	
	public ArrayList<Integer> getSceneCodeList() {
		return sceneCodeList;
	}

	public void setEndDate(Long Date) throws ParseException { 

		endDate.setTime(Date);
	}
}
