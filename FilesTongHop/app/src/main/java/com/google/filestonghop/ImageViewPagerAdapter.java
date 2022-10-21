package com.google.filestonghop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ImageViewPagerAdapter extends PagerAdapter {

    List<Image> mListImage;

    public ImageViewPagerAdapter(List<Image> mListImage) {
        this.mListImage = mListImage;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_image,container,false);
        ImageView imgImage =view.findViewById(R.id.img_image);

        Image image= mListImage.get(position);
        imgImage.setImageResource(image.getResourceId());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListImage != null){
            return mListImage.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
