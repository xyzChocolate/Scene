package com.example.seonghoon.yeodam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LocationManager implements ILocationIOhandler{

	//여러 장소를 저장
		private ArrayList<Location> locationContainer= new ArrayList<Location>();

		
		public int addLocation(Location location) { 
			
			locationContainer.add(location);
			return 0;
		}


		@Override
		public int read(InputStream inputStream) throws IOException {

			String[] spiltBuf;
			int skipFrist=0;
			String readLine;
			BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));
			
			while((readLine = sceneBuf.readLine())!=null) { 
				if(skipFrist==0) { skipFrist++;continue;}

				spiltBuf = readLine.split(",");		
				Location locationBuffer = new Location();
				
				locationBuffer.setLocationName(spiltBuf[0]);
				locationBuffer.setLocationCode(Integer.parseInt(spiltBuf[1]));
				locationBuffer.setPictAdr(spiltBuf[2]);
				locationBuffer.setLocationInfo(spiltBuf[3]);
			
				addLocation(locationBuffer);
			}
			sceneBuf.close();
			return 0;
		}
		
}
