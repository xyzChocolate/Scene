package com.example.seonghoon.yeodam;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SceneManager implements ISceneIOhandler,Parcelable {

	//여러 씬 저장 장소
	private ArrayList<Scene> sceneContainer= new ArrayList<Scene>();

	public SceneManager(){

	}
	public SceneManager(Parcel in) {
		this.sceneContainer = (ArrayList<Scene>)in.readSerializable();
	}

	public int addScene(Scene scene) {
		sceneContainer.add(scene);
		return 0;
	}
	// 테스트용 함수

	public String getFristSceneName(){

		return sceneContainer.get(1).getSceneName();
	}


	@Override
	public int read(InputStream inputStream) throws IOException {

		//파일로 부터 내용을 읽어와 저장하는 기능
		int skipFrist =0;
		String readLine;
		String[] spiltBuf;
		BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));

		while((readLine = sceneBuf.readLine())!=null) {
			if(skipFrist==0) { skipFrist++;continue;}

			spiltBuf = readLine.split(",");
			Scene sceneBuffer = new Scene();

			sceneBuffer.setSceneName(spiltBuf[0]);
			sceneBuffer.setSceneCode(Integer.parseInt(spiltBuf[1]));
			sceneBuffer.setPictAdr(spiltBuf[2]);
			sceneBuffer.setHashTag(spiltBuf[3]);
			sceneBuffer.setSceneInfo(spiltBuf[4]);
			sceneBuffer.setFoodGuide(spiltBuf[5]);
			sceneBuffer.setMissionReward(spiltBuf[6]);
			sceneBuffer.setSceneMission(spiltBuf[7]);
			sceneBuffer.setMissionMarker(spiltBuf[8]);
			sceneBuffer.setSceneFin(Boolean.parseBoolean(spiltBuf[8]));
			sceneBuffer.setSceneStroy(spiltBuf[9]);

			addScene(sceneBuffer);
		}
		sceneBuf.close();
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
	public static final Parcelable.Creator<SceneManager> CREATOR = new Parcelable.Creator<SceneManager>(){
		public SceneManager createFromParcel(Parcel in) {
			return new SceneManager(in);
		}

		@Override
		public SceneManager[] newArray(int size) {
			return new SceneManager[size];
		}

	};
}