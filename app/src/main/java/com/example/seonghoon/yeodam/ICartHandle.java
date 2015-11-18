package com.example.seonghoon.yeodam;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public interface ICartHandle {
	
	
	// 현재 장바구니를 하나의 플랜으로 만들고, 카트를 초기화 시킴
	public Plan makePlan(String planName, int planCode, Date startDate, Date endDate) throws ParseException, IOException;
	// 장바구니에 씬을 추가함
	public int add(int sceneCode);	
	// 장바구니에서 씬을 삭제함
	public int del(int sceneCode);	
	
	
}

