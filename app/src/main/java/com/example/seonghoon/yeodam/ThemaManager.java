package com.example.seonghoon.yeodam;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ThemaManager implements IThemaIOhandler , ISearchThema, Parcelable{

	//여러 테마의 저장
	private ArrayList<Thema> themaContainer = new ArrayList<Thema>();
	//테마와 씬들의 릴레이션을 저장
	private ArrayList<ThemaRelation> themaRelations = new ArrayList<ThemaRelation>();

	public ThemaManager(){

	}

	public ThemaManager(Parcel in) {
		this.themaContainer = (ArrayList<Thema>)in.readSerializable();
	}


	// 하나의 테마 추가
	public int addThema(Thema thema) {

		themaContainer.add(thema);
		return 0;
	}


	public int addThemaRelation(ThemaRelation oneRelation){
		themaRelations.add(oneRelation);
		return 0;
	}

	public int enrollThemaRelation() {
		//테마-릴레이션 테이블을 한번 순서대로 읽어서
		//씬코드를 테마에 등록시킴
		for( ThemaRelation tRel : themaRelations ) {

			int themaCode = tRel.getThemaCode();
			int sceneCode = tRel.getSceneCode();

			//씬코드를 테마에 등록시킴
			for( Thema t : themaContainer){
				if(t.getThemaId()==themaCode) {
					t.addSceneCode(sceneCode);
				}
			}
		}
		return 0;
	}


	@Override
	public int read(InputStream inputStream) throws IOException {
		// 파일에서 테마 내용을 읽어서 저장함
		String[] spiltBuf;
		int skipFrist=0;

		String readLine;
		BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));

		while((readLine = sceneBuf.readLine())!=null) {
			if(skipFrist==0) { skipFrist++;continue;}

			spiltBuf = readLine.split(",");
			Thema themaBuffer = new Thema();

			themaBuffer.setThemaName(spiltBuf[0]);
			themaBuffer.setThemaId(Integer.parseInt(spiltBuf[1]));
			themaBuffer.setThemaReward(spiltBuf[2]);


			addThema(themaBuffer);
		}
		//전체 테마 릴레이션을 등록함
		enrollThemaRelation();

		sceneBuf.close();

		return 0;
	}


	@Override
	public int readRelation(InputStream inputStream) throws IOException {
		//파일로 부터 테마-씬 릴레이션 테이블을 읽어옴
		String[] spiltBuf;
		String readLine;
		int skipFrist=0;


		BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));

		while((readLine = sceneBuf.readLine())!=null) {
			if(skipFrist==0) { skipFrist++;continue;}
			spiltBuf = readLine.split(",");
			ThemaRelation relationBuffer = new ThemaRelation();
			relationBuffer.setThemaCode(Integer.parseInt(spiltBuf[0]));
			relationBuffer.setSceneCode(Integer.parseInt(spiltBuf[1]));

			addThemaRelation(relationBuffer);
		}

		sceneBuf.close();
		return 0;
	}


	@Override
	public ArrayList<Thema> SearchThema(String SearchWord){

		ArrayList<Thema> bufList = new ArrayList<Thema>();

		//기초 검색 기능 : 이후 ★발전된 검색이 필요함
		for(Thema i : themaContainer) {

			if(i.getThemaName() == SearchWord) {
				bufList.add(i);
			}
		}

		return bufList;
	}


	public String getThemaName(int code) {

		return themaContainer.get(code).getThemaName();

	}



	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeSerializable(this.themaContainer);
	}

	public static final Parcelable.Creator<ThemaManager> CREATOR = new Parcelable.Creator<ThemaManager>(){
		public ThemaManager createFromParcel(Parcel in) {
			return new ThemaManager(in);
		}

		@Override
		public ThemaManager[] newArray(int size) {
			return new ThemaManager[size];
		}

	};
}