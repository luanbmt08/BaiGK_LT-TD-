package com.google.filestonghop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView txt_supphone;
    ImageView imgp;
    TextView txt_mota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txt_supphone=findViewById(R.id.txt_nametb);
        Intent myintent = getIntent();
        String namephone = myintent.getStringExtra("name");
        txt_supphone.setText(namephone);

        imgp = findViewById(R.id.imgtb);
        Intent myintent1 = getIntent();
        int imgphone = myintent.getIntExtra("img",R.drawable.img_ssgalaxys22);
        imgp.setImageResource(imgphone);

        txt_mota=findViewById(R.id.txt_motatb);
        Intent myintent2 = getIntent();
        String txt_mota2 = myintent2.getStringExtra("mota");
        txt_mota.setText(txt_mota2);



        TextView back =(TextView) findViewById(R.id.back) ;
        ImageView imageback =(ImageView) findViewById(R.id.imgback) ;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}

