package com.google.filestonghop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicate;
    private List<Image> mListImage;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;

    private Handler mHandler =new Handler();
    private Runnable mRunnable =new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem()==mListImage.size() -1) {
                mViewPager.setCurrentItem(0);
            } else {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvItem=findViewById(R.id.rcv_item);
        mItemAdapter=new ItemAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        rcvItem.setLayoutManager(gridLayoutManager);
        mItemAdapter.setData(getListItem());
        rcvItem.setAdapter(mItemAdapter);




        mViewPager =findViewById(R.id.view_pager);
        mCircleIndicate =findViewById(R.id.circle_indicator);
        mListImage=getListImage();
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(mListImage);
        mViewPager.setAdapter(adapter);
        mCircleIndicate.setViewPager(mViewPager);
        mHandler.postDelayed(mRunnable,2000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,2000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_favourite:
                        Toast.makeText(HomeActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeActivity.this, ListViewActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(HomeActivity.this, ProfileActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
    List<Image> getListImage(){
        List<Image> list =new ArrayList<>();
        list.add(new Image(R.drawable.img_ip14));
        list.add(new Image(R.drawable.img_samsung));
        list.add(new Image(R.drawable.img_zflip3));
        list.add(new Image(R.drawable.img_xiaomi));
        return list;
    }
    private List<Item> getListItem() {
        List<Item> list =new ArrayList<>();
        list.add(new Item(R.drawable.img_introip_1,"Iphone"));
        list.add(new Item(R.drawable.img_introip2,"Iphone"));
        list.add(new Item(R.drawable.img_introip3,"Iphone"));


        list.add(new Item(R.drawable.img_intross1,"SamSung"));
        list.add(new Item(R.drawable.img_intross2,"SamSung"));
        list.add(new Item(R.drawable.img_intross3,"SamSung"));


        list.add(new Item(R.drawable.img_introxm1,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm2,"Xiaomi"));
        list.add(new Item(R.drawable.image_introxm3,"Xiaomi"));

        list.add(new Item(R.drawable.img_samsung,"Xiaomi"));
        list.add(new Item(R.drawable.img_xiaomi,"Xiaomi"));
        list.add(new Item(R.drawable.img_zflip3,"Xiaomi"));
        return list;
    }
}