package com.example.seonghoon.yeodam;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class UserData implements ICartHandle{
	//+++기타 유저의 개인적인 정보를 추가예정	
	
	
	//유저의 장바구니 정보 
	private ArrayList<Integer> cartList;
	

	public UserData(){
		cartList = new ArrayList<Integer>();
		
	}
	public ArrayList<Integer> getCartList() {
		return cartList;
	}
	
	@Override
	public Plan makePlan(String planName,int planCode,Date startDate,Date endDate) throws ParseException, IOException {
		
		//플랜 만들기 
		Plan bufPlan = new Plan(planName,planCode,startDate,endDate);
	
		for(int i : cartList) { 
			bufPlan.addSceneCode(i);
		}
		//카트 초기화
		cartList.clear();
		
		return bufPlan;
	}
	@Override
	public int add(int sceneCode) {
		//중복검사
		for( int i : cartList ) { 
			if(cartList.get(i)==sceneCode){
				return -1;
			}
		}	
		
		cartList.add(sceneCode);
		return 0;
	}
	@Override
	public int del(int sceneCode) {
		
		for( int i : cartList ) { 
			if(cartList.get(i) == sceneCode) { 
				cartList.remove(i);
				return 0;
			}
		}
		//not found;
		return -1;

	}



}
