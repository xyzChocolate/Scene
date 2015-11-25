package com.example.seonghoon.yeodam;

public class Location {

	private String locationName;      // 이름
	private int locationCode;          // 코드
	private String pictAdr;         //사진주소
	private String locationInfo;      //장소 정보
	private float latitude;            //위도
	private float longitude;         //경도



	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}
	public String getPictAdr() {
		return pictAdr;
	}
	public void setPictAdr(String pictAdr) {
		this.pictAdr = pictAdr;
	}
	public String getLocationInfo() {
		return locationInfo;
	}
	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	//장소 위치 정보

}
