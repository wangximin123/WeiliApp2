package com.example.wxm.weiliapp2;

import android.Manifest;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.wxm.weiliapp2.Shebei;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//37.434416,121.529923
public class GPSdingwei extends AppCompatActivity {
    MapView mMapView;
    AMap aMap=null;
    MyLocationStyle myLocationStyle=null;
    List<Shebei>  list_shebei=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpsdingwei);
        getpermissions();
        finViews();
        initData();
        initMap(savedInstanceState);
        //addMarker(new LatLng(37.434416,121.529923),"aa","西安市：34.341568, 108.940174",R.drawable.normal);
//        addMarker(new LatLng(37.234416,120.529923),"bb","西安市：34.341568, 108.940174",R.drawable.normal);
//        addMarker(new LatLng(36.834416,120.529923),"cc","西安市：34.341568, 108.940174",R.drawable.normal);
    }

//    public void onMyLocationChange(android.location.Location location){
//    //从location对象中获取经纬度信息，地址描述信息，建议拿到位置之后调用逆地理编码接口获取（获取地址描述数据章节有介绍）
//        double latitude = location.getLatitude();     //经度
//        double longitude = location.getLongitude(); //纬度
//        Log.d("result","x:"+latitude+"  "+"y:"+longitude);
//}
    void initData(){
        list_shebei.add(new Shebei("仓库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.shouye,true,true,37.234416f,120.529923f));
        list_shebei.add(new Shebei("运输车","ID:5689A",08.5f,75.3f,"2016-04-21 19:23:06",R.drawable.yunshuche,true,true,36.834416,121.229923));
        list_shebei.add(new Shebei("冷藏箱","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.gongwenbao,false,true,37.434416,121.529923));
        list_shebei.add(new Shebei("冷藏室","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.cangkumen,true,false,37.304416f,120.929923f));
        list_shebei.add(new Shebei("粮库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.gongwenbao,true,true,37.034416f,120.829923f));
        list_shebei.add(new Shebei("水库","ID:5689A",08.5f,0,"2016-04-21 19:23:06",R.drawable.cangkumen,true,true,37.334416f,121.729923f));
    }
    void addMarker(LatLng latLng,String title,String content,int pic){
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(latLng);
        markerOption.title(title).snippet(content);

        markerOption.draggable(true);//设置Marker可拖动
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(),pic)));
        final Marker marker = aMap.addMarker(markerOption);
    }
    void getpermissions(){
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION},1);
    }
    void finViews(){
        mMapView=findViewById(R.id.GPS_mapView);
    }
    public String getAddress(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude,
                    longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String data = address.toString();
                int startCity = data.indexOf("0:\"") + "0:\"".length();
                int endCity = data.indexOf("\"", startCity);
                String city = data.substring(startCity, endCity);

//                int startPlace = data.indexOf("feature=") + "feature=".length();
//                int endplace = data.indexOf(",", startPlace);
//                String place = data.substring(startPlace, endplace);

                return city;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "获取失败";
    }
    void initMap(Bundle savedInstanceState){
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }

        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE) ;//定位一次，且将视角移动到地图中心点。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.aa)));
        myLocationStyle.showMyLocation(true);
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        //aMap.setOnMyLocationChangeListener(this);

        for (Shebei shebei:list_shebei){
            LatLng latLng=new LatLng(shebei.getPositionX(),shebei.getPositionY());
            addMarker(latLng,shebei.getName(),
                    getAddress(shebei.getPositionX(),shebei.getPositionY())+" "+((shebei.isNormal()&&shebei.isInline())?"正常":(shebei.isNormal()?"离线":"异常")),
                    (shebei.isNormal()&&shebei.isInline())?R.drawable.normal:(shebei.isInline()?R.drawable.yichang:R.drawable.lixian));
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}
