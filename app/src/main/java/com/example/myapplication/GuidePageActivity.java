package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class GuidePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);

        //引导页创建
        LayoutInflater lf = getLayoutInflater().from(this);
        View v1 = lf.inflate(R.layout.guide_one,null);
        View v2 = lf.inflate(R.layout.guide_two,null);
        View v3 = lf.inflate(R.layout.guide_three,null);
        List<View> view = new ArrayList<>();
        view.add(v1);
        view.add(v2);
        view.add(v3);
        GuideAdapter sideshowAdapter = new GuideAdapter(view);

        ViewPager guide = findViewById(R.id.guide);
        guide.setAdapter(sideshowAdapter);
    }


    /**
     * 进入主登录界面
     * @param view
     */
    public void joinLoginPage(View view) {
        //setContentView(R.layout.activity_main);
        startActivity(new Intent(this,MainActivity.class));
    }
}
