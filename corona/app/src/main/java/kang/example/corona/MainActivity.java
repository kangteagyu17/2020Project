package kang.example.corona;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //getMapAsync must be called on the main thread.
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.56, 126.97);   //위치 정보


        first(mMap);    //단순 마크 찍기
        third(mMap);    //마크찍고 각 위치를 polyline 으로 이음

        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL)); //초기 카메라를 어디위치에 놓을 것인가?
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
    }
    public void first(final GoogleMap googleMap)
    {
        LatLng f1 = new LatLng(37.460195,126.438507);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(f1);
        markerOptions.title("1번째확진자");
        markerOptions.snippet("인천공항에서 바로 격리");
        mMap.addMarker(markerOptions);
    }

    public void third(final GoogleMap googleMap)
    {
        LatLng l1 = new LatLng(37.5244219,127.0275946);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(l1);
        markerOptions.title("3번째확진자");
        markerOptions.snippet("글로비 성형외과");
        mMap.addMarker(markerOptions);
        LatLng l2 = new LatLng(37.523565, 127.030507);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(l2);
        markerOptions1.title("3번째확진자");
        markerOptions1.snippet("인근식당");
        mMap.addMarker(markerOptions1);
        LatLng l3 = new LatLng(37.4994525,127.0393967);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(l3);
        markerOptions2.title("3번째확진자");
        markerOptions2.snippet("호텔뉴브");
        mMap.addMarker(markerOptions2);
        LatLng l4 = new LatLng(37.5244317,127.0158946);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(l4);
        markerOptions3.title("3번째확진자");
        markerOptions3.snippet("한강 잠원 1호점");
        mMap.addMarker(markerOptions3);
        LatLng l5 = new LatLng(37.500497, 127.050846);
        MarkerOptions markerOptions4= new MarkerOptions();
        markerOptions4.position(l5);
        markerOptions4.title("3번째확진자");
        markerOptions4.snippet("역삼동 대치동 인근 음식점");
        mMap.addMarker(markerOptions4);
        LatLng l6 = new LatLng(37.5244219,127.0275964);
        MarkerOptions markerOptions5= new MarkerOptions();
        markerOptions5.position(l6);
        markerOptions5.title("3번째확진자");
        markerOptions5.snippet("글로비 재방문");
        mMap.addMarker(markerOptions5);
        LatLng l7 = new LatLng(37.653210, 126.790891);
        MarkerOptions markerOptions6= new MarkerOptions();
        markerOptions6.position(l7);
        markerOptions6.title("3번째확진자");
        markerOptions6.snippet("일산 근처 음식점 카페");
        mMap.addMarker(markerOptions6);
        LatLng l8 = new LatLng(37.662540, 126.778966);
        MarkerOptions markerOptions7= new MarkerOptions();
        markerOptions7.position(l8);
        markerOptions7.title("3번째확진자");
        markerOptions7.snippet("일산 모친 자택");
        mMap.addMarker(markerOptions7);


        Polyline line = mMap.addPolyline(new PolylineOptions()
            .add(l1, l2,l3,l4,l5,l6,l7,l8)  //각 위치를 이음
            .width(5)   //두께 설정
            .color(Color.RED)); //Polyline 의 색


    }


}
