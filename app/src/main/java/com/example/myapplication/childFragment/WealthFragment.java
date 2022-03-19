package com.example.myapplication.childFragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.News_Wealth_Adapter;
import com.example.myapplication.R;
import com.example.myapplication.pojo.News;

import java.util.ArrayList;
import java.util.List;

/**
 * 财经fragment
 */
public class WealthFragment extends Fragment {

    private List<News> data =new ArrayList<>();
    private News_Wealth_Adapter newsAdapter;
    private News news;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wealth_fragment, container, false);
        ListView listView = view.findViewById(R.id.news_wealth_lv);
        for (int i = 0; i < 20; i++) {
            //加二十条新闻
            news = new News();
            news.setTitle("测试标题");
            news.setMessage("内容测试_财经");

            news.setImage(R.mipmap.news_image);
            news.setDiscuss_icon(R.drawable.news_discuss_icon);
            news.setDate(news.getDate());
            news.setDiscussNumbers("100");
            data.add(news);
        }
        newsAdapter = new News_Wealth_Adapter(data,this);
        listView.setAdapter(newsAdapter);
        return view;
    }
}