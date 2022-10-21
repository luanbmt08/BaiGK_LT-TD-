package com.google.filestonghop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    int image[]={R.drawable.img_samsunggalaxy22,R.drawable.img_ip11promax,R.drawable.img_ssgalaxys22,R.drawable.img_ip13promax,R.drawable.ssgalaxy_zflip3,R.drawable.img_asus_zfone3,R.drawable.img_ip13promax,R.drawable.img_ssgalaxys22,R.drawable.img_ip13promax,R.drawable.ssgalaxy_zflip3};
    String name[] = {"Samsung Galaxy A22","Iphone11 Promax" ,"Samsung Galaxy S22 Ultra","Iphone13 Promax" ,"Galaxy Zflip 3 5G" ,"Asus Zfone 3 Ze520KI","Iphone13 Promax","Samsung Galaxy S22 Ultra","Iphone13 Promax" ,"Galaxy Zflip 3 5G"};
    String mota[] = {"Thân máy\tKích thước\t159.3 x 73.6 x 8.4 mm (6.27 x 2.90 x 0.33 in)\n" +
            "Trong lượng\t186 g (6.56 oz)\n" +
            "Build\tGlass front, plastic frame, plastic back\n" +
            "SIM\tSingle SIM (Nano-SIM) or Dual SIM (Nano-SIM, dual stand-by)\n" +
            "Bộ nhớ\tKhe cắm thẻ nhớ\tmicroSDXC (dedicated slot)\n" +
            "Bộ nhớ trong\t64GB 4GB RAM, 128GB 4GB RAM, 128GB 6GB RAM\n" +
            " \teMMC 5.1","Màn hình\tSuper Retina XDR OLED, 6.5\", 1242x2688 pixels\n" +
            "Camera trước\t12MP\n" +
            "Camera sau\t3 Camera 12MP\n" +
            "CPU\tApple A13 Bionic (7 nm+) 6 nhân\n" +
            "RAM\t4GB\n" +
            "Bộ nhớ trong\t64GB\n" +
            "Thẻ SIM\t1 Nano-SIM, 1 eSIM\n" +
            "Dung lượng Pin\t3969 mAh, có sạc nhanh, có sạc không dây\n" +
            "Hệ điều hành\tiOS","Công nghệ màn hình\n" +
            "\n" +
            "Dynamic AMOLED 2X\n" +
            "Độ phân giải\n" +
            "\n" +
            "QHD+ (1440 x 3088 pixels)\n" +
            "Màn hình rộng\n" +
            "\n" +
            "6.8\" - Tần số quét 120Hz\n" +
            "Mặt kính cảm ứng\n" +
            "\n" +
            "Camera sau\n" +
            "\n" +
            "40 MP\n" +
            "Videocall\n" +
            "\n" +
            "4K@30/60FPS / 1080P@30/60FPS / 720P/30FPS","Thương hiệu\n" +
            "\n" +
            "Apple\n" +
            "Công nghệ màn hình\n" +
            "\n" +
            "Retina IPS LCD\n" +
            "Độ phân giải\n" +
            "\n" +
            "1640 x 2360 pixels\n" +
            "Kích thước màn hình\n" +
            "\n" +
            "10.9 inches\n" +
            "Camera sau\n" +
            "\n" +
            "12 MP\n" +
            "Quay phim\n" +
            "\n" +
            "12 MP\n" +
            "Hệ điều hành\n" +
            "\n","Thương hiệu\n" +
            "\n" +
            "Apple\n" +
            "Công nghệ màn hình\n" +
            "\n" +
            "Retina IPS LCD\n" +
            "Độ phân giải\n" +
            "\n" +
            "1640 x 2360 pixels\n" +
            "Kích thước màn hình\n" +
            "\n" +
            "10.9 inches\n" +
            "Camera sau\n" +
            "\n" +
            "12 MP\n" +
            "\n" +
            "802.11 a/b/g/n/ac/ax 2.4G+5GHz+6GHz / HE160 / MIMO / 1024-QAM","Công nghệ màn hình\n" +
            "\n" +
            "Dynamic AMOLED 2X\n" +
            "Độ phân giải\n" +
            "\n" +
            "Màn hình rộng\n" +
            "\n" +
            "Chính 7.6\" & Phụ 6.2\" - Tần số 120 Hz\n" +
            "Mặt kính cảm ứng\n" +
            "Chụp ảnh nâng cao\n" +
            "\n" +
            "Camera trước\n" +
            "\n" +
            "802.11 a/b/g/n/ac/ax 2.4G+5GHz+6GHz / HE160 / MIMO / 1024-QAM","Kích thước màn hình\n" +
            "\n" +
            "6.1 inches\n" +
            "Hệ điều hành\n" +
            "\n" +
            "iOS 16\n" +
            "Pin\n" +
            "\n" +
            "3,279mAh\n" +
            "Công nghệ màn hình\n" +
            "\n" +
            "OLED\n" +
            "Camera sau\n" +
            "\n" +
            "Camera góc rộng: 12MP\n" +
            "Camera góc siêu rộng: 12MP"};
    String gia[] = {"4.190.000","10.000.000","15.000.000","25.490.000 ","28.500.000","12.515.000","25.490.000 ","28.500.000","12.515.000","25.490.000 "};
    ArrayList<ThietBi> myList;
    ThietBiAdapter myadapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv = findViewById(R.id.listviewthietbi);
        myList = new ArrayList<>();
        for (int i = 0;i<name.length;i++){
            myList.add(new ThietBi(name[i],gia[i],image[i]));
        }
        myadapter = new ThietBiAdapter(ListViewActivity.this,R.layout.layout_thietbi,myList);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(ListViewActivity.this, DetailActivity.class);
                myintent.putExtra("name",name[i]);
                myintent.putExtra("img",image[i]);
                myintent.putExtra("gia",gia[i]);
                myintent.putExtra("mota",mota[i]);

                startActivity(myintent);
            }
        });
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_favourite:
                        Toast.makeText(ListViewActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_home:
                        Toast.makeText(ListViewActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ListViewActivity.this, HomeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(ListViewActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(ListViewActivity.this, ProfileActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
    }


