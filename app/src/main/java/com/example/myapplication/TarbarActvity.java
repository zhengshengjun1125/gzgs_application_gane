package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.showcustomTarbar.HomeFragment;
import com.example.myapplication.showcustomTarbar.MineFragment;
import com.example.myapplication.showcustomTarbar.NewsFragment;

public class TarbarActvity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout flyout;

    //首页
    private RelativeLayout home_layout;
    private ImageView home_iv;
    private TextView home_tv;

    //新闻
    private RelativeLayout news_layout;
    private ImageView news_iv;
    private TextView news_tv;

    //我
    private RelativeLayout mine_layout;
    private ImageView mine_iv;
    private TextView mine_tv;


    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int blue = 0xFF0AB2FB;

    //三个视图
    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private MineFragment mineFragment;

    FragmentManager fragmentManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showtarbar_activity);

        initView();

//        一开始显示首页
        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        home_iv.setImageResource(R.drawable.home_index_selector);
        getSupportFragmentManager().beginTransaction().add(R.id.content, homeFragment).commit();
    }

    //初始化控件
    private void initView() {
        home_layout = findViewById(R.id.home_layout);
        home_iv = findViewById(R.id.home_iv);
        home_tv = findViewById(R.id.home_tv);

        news_layout = findViewById(R.id.news_layout);
        news_iv = findViewById(R.id.news_iv);
        news_tv = findViewById(R.id.news_tv);

        mine_layout = findViewById(R.id.mine_layout);
        mine_iv = findViewById(R.id.mine_iv);
        mine_tv = findViewById(R.id.mine_tv);


        home_layout.setOnClickListener(this);
        news_layout.setOnClickListener(this);
        mine_layout.setOnClickListener(this);

        clearChioce();//清空选择

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                setItem(0);
                break;
            case R.id.news_layout:
                setItem(1);
                break;
            case R.id.mine_layout:
                setItem(2);
                break;
            default:
                break;
        }
    }


    /**
     * 选择 控制器
     */
    public void setItem(int index) {
        clearChioce();//选择的时候清除上一个索引
        // 重置选项
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏之前的
        hideFragments(transaction);

        switch (index) {
            case 0: //选择首页
                home_iv.setImageResource(R.drawable.home_index_selector);
                home_tv.setTextColor(blue);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;

            case 1:
                news_iv.setImageResource(R.drawable.news_index_selector);
                news_tv.setTextColor(blue);
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;

            case 2:
                mine_iv.setImageResource(R.drawable.mine_index_selector);
                mine_tv.setTextColor(blue);
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();

    }


    /**
     * 清除选项
     * 还原颜色以及图标
     */
    public void clearChioce() {
        home_iv.setImageResource(R.drawable.home_index);
        home_layout.setBackgroundColor(whirt);
        home_tv.setTextColor(gray);

        news_iv.setImageResource(R.drawable.news_index);
        news_layout.setBackgroundColor(whirt);
        news_tv.setTextColor(gray);

        mine_iv.setImageResource(R.drawable.mine_index);
        mine_layout.setBackgroundColor(whirt);
        mine_tv.setTextColor(gray);

    }

    /***
     * 将所有的Fragment都设置为隐藏状态
     * @param transaction 事物
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }


}
