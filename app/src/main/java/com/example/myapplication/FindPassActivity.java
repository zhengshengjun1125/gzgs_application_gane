package com.example.myapplication;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//找回密码页面
public class FindPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_pass);

    }

    /**
     * 视图的返回
     * @param view
     */
    public void back(View view) {
        //返回主页面
        setContentView(R.layout.activity_main);
        System.out.println("调用了back方法");
    }
}
