package com.example.seonghoon.yeodam;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LocationManager implements ILocationIOhandler, Parcelable {

	//여러 장소를 저장


	private ArrayList<Location> locationContainer = new ArrayList<Location>();


	public LocationManager() {

	}

	public LocationManager(Parcel in) {

		this.locationContainer = (ArrayList<Location>) in.readSerializable();
	}


	public int addLocation(Location location) {

		locationContainer.add(location);
		return 0;
	}

	public Location getLocation(int index) {

		return locationContainer.get(index);
	}

	public int getLocaSize() {

		return locationContainer.size();

	}

	@Override
	public int read(InputStream inputStream) throws IOException {

		String[] spiltBuf;
		int skipFrist = 0;
		String readLine;
		BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream, "euc-kr"));

		while ((readLine = sceneBuf.readLine()) != null) {
			if (skipFrist == 0) {
				skipFrist++;
				continue;
			}

			spiltBuf = readLine.split(",");
			Location locationBuffer = new Location();

			locationBuffer.setLocationName(spiltBuf[0]);
			locationBuffer.setLocationCode(Integer.parseInt(spiltBuf[1]));
			locationBuffer.setPictAdr(spiltBuf[2]);
			locationBuffer.setLocationInfo(spiltBuf[3]);
			locationBuffer.setLatitude(Float.parseFloat(spiltBuf[4]));
			locationBuffer.setLongitude(Float.parseFloat(spiltBuf[5]));

			addLocation(locationBuffer);
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

	public static final Parcelable.Creator<LocationManager> CREATOR = new Parcelable.Creator<LocationManager>() {

		public LocationManager createFromParcel(Parcel in) {
			return new LocationManager(in);
		}

		@Override
		public LocationManager[] newArray(int size) {
			return new LocationManager[size];
		}


	};
}