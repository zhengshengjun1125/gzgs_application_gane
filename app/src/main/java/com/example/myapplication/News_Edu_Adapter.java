package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.childFragment.EducationFragment;
import com.example.myapplication.childFragment.MilitaryFragment;
import com.example.myapplication.pojo.News;

import java.util.ArrayList;
import java.util.List;

public class News_Edu_Adapter extends BaseAdapter {
    private List<News> news_data = new ArrayList<>();//数据存储容器
    private LayoutInflater inflater;


    //初始化
    public News_Edu_Adapter(List<News> news_data, EducationFragment context) {
        this.news_data = news_data;
        this.inflater = LayoutInflater.from(context.getContext());
    }

    private ImageView news_image;//新闻海报
    private ImageView news_discuss_icon;//评论图标
    private TextView news_title;//新闻标题
    private TextView news_message;//新闻内容
    private TextView news_time;//发布时间
    private TextView news_discuss_numbers;//评论数量


    @Override
    public int getCount() {
        //如果数据结合为0返回0，否者返回集合长度
        return news_data == null ? 0 : news_data.size();
    }

    @Override
    public Object getItem(int position) {
        return news_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.news_item, null);
        news_image = view.findViewById(R.id.news_image);
        news_time = view.findViewById(R.id.news_time);
        news_discuss_icon = view.findViewById(R.id.discuss_icon);
        news_discuss_numbers = view.findViewById(R.id.discuss_numbers);
        news_message = view.findViewById(R.id.news_message);
        news_title = view.findViewById(R.id.news_title);
        //数据绑定
        News news = (News) getItem(position);

        news_image.setImageResource(news.getImage());
        news_time.setText(news.getDate());
        news_discuss_icon.setImageResource(news.getDiscuss_icon());
        news_discuss_numbers.setText(news.getDiscussNumbers());
        news_message.setText(news.getMessage());
        news_title.setText(news.getTitle());

        return view;
    }
}
