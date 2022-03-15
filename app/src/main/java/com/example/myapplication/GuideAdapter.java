package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class GuideAdapter extends PagerAdapter {

    private List<View> view;

    public GuideAdapter(List<View> view) {
        this.view = view;
    }

    @Override
    public int getCount() {
        return view.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(view.get(position), 0);
        return view.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(view.get(position));
    }
}

