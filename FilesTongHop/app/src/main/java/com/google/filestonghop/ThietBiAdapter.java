package com.google.filestonghop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ThietBiAdapter extends ArrayAdapter<ThietBi> {
    Activity context;
    int IdLayout;
    ArrayList<ThietBi> myList;

    public ThietBiAdapter(Activity context, int idLayout, ArrayList<ThietBi> myList) {
        super(context, idLayout,myList);
        this.context = context;
        IdLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myflater = context.getLayoutInflater();
        convertView = myflater.inflate(IdLayout,null);
        ThietBi myphone =myList.get(position);
        ImageView img_phone = convertView.findViewById(R.id.imageHinh);
        img_phone.setImageResource(myphone.getHinh());
        TextView txt_name=convertView.findViewById(R.id.name);
        txt_name.setText(myphone.getName());

        TextView txt_gia=convertView.findViewById(R.id.gia);
        txt_gia.setText(myphone.getGia());
        return convertView;
    }
}
