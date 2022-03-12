package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        LayoutInflater lf = getLayoutInflater().from(this);
        View v1 = lf.inflate(R.layout.index_one, null);
        View v2 = lf.inflate(R.layout.index_two, null);
        View v3 = lf.inflate(R.layout.index_three, null);
        List<View> viewList = new ArrayList<>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        WelcomeAdapter welcomeAdapter = new WelcomeAdapter(viewList);
        ViewPager viewPager =findViewById(R.id.welcome_user_index);
        viewPager.setAdapter(welcomeAdapter);
    }

    /**
     * 引导页的最后一页点击进入系统
     * @param view
     */
    public void joinLoginPage(View view) {
        setContentView(R.layout.activity_main);

    }
}
