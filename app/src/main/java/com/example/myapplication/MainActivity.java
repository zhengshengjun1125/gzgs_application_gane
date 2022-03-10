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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_agree);

        //暂时创建逻辑库
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        if (sp.getBoolean("is_user_first_join", false)) {
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class)); //跳转到LoginActivity类中
        }


    }

    /**
     * @param view
     */
    public void login(View view) {
        //获取到同意框
        CheckBox read_agree = findViewById(R.id.read_agree);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.user_pass);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        if (username.getText().toString() != "admin" &&
                password.getText().toString() != "admin"
                && read_agree.isChecked() == false) {
            dialog.setTitle("提示").setMessage("账号或者密码错误,也有可能是您没有同意用户协议").setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();
            //Toast.makeText(this,"账号或者密码错误,当前为测试账号",Toast.LENGTH_SHORT).show();
        }else {
            //没有错了，直接进入页面即可
            setContentView(R.layout.index_system);
        }

    }

/*
 else {
            System.out.println(checkBox.isChecked());
            //没有被选中
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(MainActivity.this).setTitle("信息提示")//设置对话框标题

                            .setMessage("是否同意并进入系统？")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {//添加确定按钮
                                @Override
                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                    checkBox.setChecked(checkBox.isChecked());
                                    login(view);
                                }
                            }).setNegativeButton("否", new DialogInterface.OnClickListener() {//添加返回按钮
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//响应事件

                        }

                    }).show();//在按键响应事件中显示此对话框
                }
            });
        }
 */
}
