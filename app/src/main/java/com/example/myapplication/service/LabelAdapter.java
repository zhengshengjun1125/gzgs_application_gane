package com.example.myapplication.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * 顶部轮播导航图
 */
public class LabelAdapter extends PagerAdapter {

    private List datas;  //数据源
    private Context context; //链接
    private LayoutInflater inflater; //

    //初始化分页以及地址
    public LabelAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    //页数
    @Override
    public int getCount() {
        return datas.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    //初始化item
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return container;
    }

    //销毁item
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
