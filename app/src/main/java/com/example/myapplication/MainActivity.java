package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.util.GuideLoader;
import com.example.myapplication.util.SqlListConnectController;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btn;//按钮
    private SharedPreferences jame;//一个存储数据的工具
    private List<Integer> images = new ArrayList<>();//存放轮播图图片
    public static Map<String,String> userInfo = new HashMap();//存放用户信息

    public static Map<String, String> userInfo() {
        return userInfo;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = findViewById(R.id.btn_agree);


        //SharedPreferences存储
        jame = getSharedPreferences("jame", 0);
        boolean isFirst = jame.getBoolean("isFirst", true);
        SharedPreferences.Editor edit = jame.edit();
        //进入引导页
        //并且判断之前是不是第一次登录
        if (isFirst) {
            //是第一次
            startActivity(new Intent(MainActivity.this, GuidePageActivity.class));
            //将文件状态改变
            edit.putBoolean("isFirst", false);
            edit.commit();
        } else {
            //直接进入登录页
            setContentView(R.layout.activity_main);
            Banner banner = findViewById(R.id.sideshow);
            images.add(R.mipmap.node);
            images.add(R.mipmap.v1);
            images.add(R.mipmap.v2);
            //设置banner样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器
            banner.setImageLoader(new GuideLoader());
            //设置图片集合
            banner.setImages(images);
            //设置轮播时间
            banner.setDelayTime(2000);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }


        //同意用户协议以及手册
        TextView info = findViewById(R.id.agree_info);
        SpannableString protocol = new SpannableString("已经同意《用户协议》");
        SpannableString handbook = new SpannableString("和《用户使用手册》");
        ClickableSpan clickProtocol = new ProtocolClickSpan(this);
        ClickableSpan clickHandbook = new HandBookClickSpan(this);
        protocol.setSpan(clickProtocol, 4, protocol.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        handbook.setSpan(clickHandbook, 1, handbook.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        info.setText(protocol);
        info.append(handbook);
        info.setMovementMethod(LinkMovementMethod.getInstance());

        //忘记密码
        TextView forget_pass = findViewById(R.id.forget_pass);
        ForgerPassClickSpan forgerPassClickSpan = new ForgerPassClickSpan(this);
        SpannableString forget = new SpannableString("忘记密码?");
        forget.setSpan(forgerPassClickSpan, 0, forget.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        forget_pass.setText(forget);
        forget_pass.setMovementMethod(LinkMovementMethod.getInstance());

    }


    /**
     * @param view 登录逻辑处理
     */
    @SuppressLint("Recycle")
    public void login(View view) {

        SqlListConnectController instance = SqlListConnectController.getInstance(this);
        SQLiteDatabase db = instance.getReadableDatabase(); //数据库连接器
        //获取到同意框
        CheckBox read_agree = findViewById(R.id.read_agree);
        //用户输入框
        EditText usernameEdit = findViewById(R.id.username);
        EditText passwordEdit = findViewById(R.id.user_pass);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        String name = "";
        String password = "";

        //处理各种非空逻辑
        if (usernameEdit.getText().toString().isEmpty()) {
            //账号或者密码为空
            dialog.setTitle("提示").setMessage("账号不能为空!").setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            }).show();
        } else if (passwordEdit.getText().toString().isEmpty()) {
            dialog.setTitle("提示").setMessage("密码不能为空!").setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            }).show();
        } else if (!read_agree.isChecked()) {
            //没有点击同意按钮
            dialog.setTitle("提示").setMessage("请您阅读并且勾选用户协议和使用手册!").setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            }).show();
        }else{
            //上面的正确了才能进入
            if (db.isOpen()) {
                //先查用户是否存在
                name = usernameEdit.getText().toString();
                Cursor cursor = db.query("users", null, "name=?", new String[]{name}, null, null, null);
//            ArrayList<Map<String,String>> resultList = new ArrayList<>();
                if (cursor.moveToNext()) {
                    name = cursor.getString(cursor.getColumnIndex("name"));
                    password = cursor.getString(cursor.getColumnIndex("password"));
                    if (!name.isEmpty()) {
                        //说明存在，在检验密码是否正确
                        if (passwordEdit.getText().toString().equals(password)) {
                            //密码正确,存放用户信息，并且进入主页面
                            userInfo.put("username",name);
                            userInfo.put("password",password);
                            startActivity(new Intent(this, TarbarActvity.class));
                        } else {
                            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            } else {
                //账号为空
                Toast.makeText(this, "账号不存在", Toast.LENGTH_SHORT).show();
            }

        }


    }

    /**
     * act的跳转，跳转到找回密码页面
     *
     * @param view
     */
    public void find_pass(View view) {
        Toast.makeText(this, "忘记密码我也没办法", Toast.LENGTH_SHORT);
//        setContentView(R.layout.find_pass);
    }

    /**
     * 注册账号
     * @param view
     */
    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
