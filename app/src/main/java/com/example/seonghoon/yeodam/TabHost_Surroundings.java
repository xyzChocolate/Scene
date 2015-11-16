package com.example.seonghoon.yeodam;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Seonghoon on 2015-11-16.
 */
public class TabHost_Surroundings extends FragmentActivity {


    private GoogleMap mMap;
    private SensorManager mSensorManager;


    public boolean gps_enabled = false;
    public boolean network_enabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //지도 띄우기
        setContentView(R.layout.tab_surroundings);


        //지도 객체 참조
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        //센서 관리자 객체 참조
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setCompassEnabled(true);

        //위치 확인하여 위치 표시 시작
        startLocationService();

    }

    @Override
    public void onResume() {
        super.onResume();

        // 내 위치 자동 표시 enable
        mMap.setMyLocationEnabled(true);

    }

    @Override
    public void onPause() {
        super.onPause();

        // 내 위치 자동 표시 disable
        mMap.setMyLocationEnabled(false);

    }
    /**
     * 현재 위치 확인을 위해 정의한 메소드
     */

    private void startLocationService() {
        int MY_PERMISSION_ACCESS_COURSE_LOCATION = 1000;
        //위치 관리자 객체 참조
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //gps 이용가능여부
        //gps_enabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        //network 이용가능 여부
        //network_enabled = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        //리스너 객체 생성
        GPSListener gpsListener = new GPSListener();
        long minTime = 1000;
        float minDistance = 0;

        //GPS기반 위치 요청
        //PERMISSION 체크
        if ( ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSION_ACCESS_COURSE_LOCATION);
        }
        //GPS를 이용한 위치측정 요청
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
        //Network를 이용한 위치측정 요청
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime,minDistance,gpsListener);
        Toast.makeText(getApplicationContext(),"현재 위치를 찾는 중...",Toast.LENGTH_LONG).show();


    }

    /**
     * Listener 정의
     */
    private class GPSListener implements LocationListener{
        /**
         * 위치 정보가 확인되었을 때 호출되는 메소드
         */

        public void onLocationChanged(Location location){
            Double latitude = location.getLatitude();
            Double longtitude = location.getLongitude();

            String msg = "Latitude "+latitude +"\nLongtitude "+longtitude;
            Log.i("GPSLocationService", msg);

            //현재위치의 지도를 보여주기 위해 정의한 메소드 호출
            showCurrentLocation(latitude,longtitude);
        }
        public void onProviderDisabled(String provider){}
        public void onProviderEnabled(String provider){}
        public void onStatusChanged(String provider, int status, Bundle extras){}
    }

    /**
     * 현재 우치의 지도를 보여주기 위해 정의한 메소드
     * @param latitude
     * @param longtitude
     */
    private void showCurrentLocation(Double latitude,Double longtitude){
        //현재 위치를 이용해 LatLng 객체 생성
        LatLng curPoint = new LatLng(latitude,longtitude);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,13));

        //지도 유형 설정
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);      //지형도
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);    //위성지도

        showSurroundings(latitude,longtitude);
    }

    /**
     * 마커표시용 메소드
     */

    private void showSurroundings(Double latitude,Double longtitude){
        /*
        MarkerOptions marker = new MarkerOptions();
        //marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(new LatLng(latitude, longtitude));
        marker.position(new LatLng(latitude,longtitude));
        marker.title("현재위치");
        marker.draggable(true);

        mMap.addMarker(marker);
        */
    }





}
