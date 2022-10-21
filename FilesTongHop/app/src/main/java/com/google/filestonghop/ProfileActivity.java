package com.google.filestonghop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView logout= (ImageView) findViewById(R.id.logout);
        TextView back =(TextView) findViewById(R.id.back) ;
        ImageView imageback =(ImageView) findViewById(R.id.imgback) ;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_profile:
                        Toast.makeText(ProfileActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_favourite:
                        Toast.makeText(ProfileActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfileActivity.this, ListViewActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_home:
                        Toast.makeText(ProfileActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(ProfileActivity.this, HomeActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
    }
