package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences( "config" , MODE_PRIVATE );
        if (sp.getBoolean("is_user_first_join",true)){
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class)); //跳转到LoginActivity类中
        }


    }

    /**
     * todo   获取同意框然后对登录进行监听
     * @param view
     */
    public void login(View view) {
        //获取的是同意
        CheckBox checkBox= findViewById(R.id.read_agree);
        boolean checked = checkBox.isChecked();
        if (checked){
            setContentView(R.layout.index_system);
        }else {
            System.out.println("为选中");
        }
    }
}