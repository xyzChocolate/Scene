package com.example.seonghoon.yeodam;

//하나의 단일 씬 정보
public class Scene {	
	
	private String sceneName;		// 이름
	private int sceneCode; 			// 코드
	private String pictAdr;			//사진주소
	private String sceneStroy;		//스토리 내용
	private String sceneInfo;		//씬 관광지 정보
	private String foodGuide;		//음식 관련 정보
	private String sceneMission;	//씬 미션 과제정보
	private String hashTag;			//간략 관광지 정보(해시태그)
	private String missionReward;	//미션보상정보
	private String missionMarker;	//GPS 정보 
	private boolean sceneFin;		//미션 완료 여부
	
	
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public String getMissionReward() {
		return missionReward;
	}
	public void setMissionReward(String missionReward) {
		this.missionReward = missionReward;
	}
	public String getMissionMarker() {
		return missionMarker;
	}
	public void setMissionMarker(String missionMarker) {
		this.missionMarker = missionMarker;
	}
	public boolean getSceneFin() {
		return sceneFin;
	}
	public void setSceneFin(boolean sceneFin) {
		this.sceneFin = sceneFin;
	}
	//getter & setter
	public String getSceneName() {
		return sceneName;
	}
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}
	public int getSceneCode() {
		return sceneCode;
	}
	public void setSceneCode(int sceneCode) {
		this.sceneCode = sceneCode;
	}
	public String getPictAdr() {
		return pictAdr;
	}
	public void setPictAdr(String pictAdr) {
		this.pictAdr = pictAdr;
	}
	public String getSceneStroy() {
		return sceneStroy;
	}
	public void setSceneStroy(String sceneStroy) {
		this.sceneStroy = sceneStroy;
	}
	public String getSceneInfo() {
		return sceneInfo;
	}
	public void setSceneInfo(String sceneInfo) {
		this.sceneInfo = sceneInfo;
	}
	public String getSceneMission() {
		return sceneMission;
	}
	public void setSceneMission(String sceneMission) {
		this.sceneMission = sceneMission;
	}
	
	public String getFoodGuide() {
		return foodGuide;
	}
	public void setFoodGuide(String foodGuide) {
		this.foodGuide = foodGuide;
	}
	
}


