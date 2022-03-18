package com.example.myapplication.showcustomTarbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.childFragment.AmusementFragment;
import com.example.myapplication.childFragment.EducationFragment;
import com.example.myapplication.childFragment.MilitaryFragment;
import com.example.myapplication.childFragment.PeFragment;
import com.example.myapplication.childFragment.WealthFragment;

public class NewsFragment extends Fragment implements View.OnClickListener {


    private TextView news_wealth;//财经
    private TextView news_military;//军事
    private TextView news_education;//教育
    private TextView news_amusement;//娱乐
    private TextView news_pe;//体育


    private WealthFragment wealthFragment;
    private MilitaryFragment militaryFragment;
    private EducationFragment educationFragment;
    private AmusementFragment amusementFragment;
    private PeFragment peFragment;

    FragmentManager fragmentManager;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);
        initView();

        //一开始显示财经
        fragmentManager = getChildFragmentManager();//在这里需要用getChildFragmentManager  因为是fragment套fragment
        WealthFragment wealthFragment = new WealthFragment();
        news_wealth.setTextColor(Color.BLUE);
        getChildFragmentManager().beginTransaction().add(R.id.news_content, wealthFragment).commit();
        return view;
    }

    private void initView() {
        news_wealth = view.findViewById(R.id.news_wealth);
        news_military = view.findViewById(R.id.news_military);
        news_education = view.findViewById(R.id.news_education);
        news_amusement = view.findViewById(R.id.news_amusement);
        news_pe = view.findViewById(R.id.news_pe);

        news_amusement.setOnClickListener(this);
        news_military.setOnClickListener(this);
        news_education.setOnClickListener(this);
        news_wealth.setOnClickListener(this);
        news_pe.setOnClickListener(this);

        clearChoice();
    }

    @Override
    public void onClick(View v) {
        //选中其中一个
        switch (v.getId()) {
            case R.id.news_wealth:
                setItem(0);
                break;
            case R.id.news_military:
                setItem(1);
                break;
            case R.id.news_education:
                setItem(2);
                break;
            case R.id.news_amusement:
                setItem(3);
                break;
            case R.id.news_pe:
                setItem(4);
                break;

        }

    }

    /**
     * 处理选中逻辑
     *
     * @param index 索引
     */
    private void setItem(int index) {
        clearChoice();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);

        switch (index) {
            case 0:
                //财经页，设置字体颜色为蓝色
                news_wealth.setTextColor(Color.BLUE);
                if (wealthFragment == null) {
                    WealthFragment wealthFragment = new WealthFragment();
                    transaction.replace(R.id.news_content, wealthFragment);
                } else {
                    transaction.show(wealthFragment);
                }
                break;
            case 1:
                //军事，设置字体颜色为蓝色
                news_military.setTextColor(Color.BLUE);
                if (militaryFragment == null) {
                    MilitaryFragment militaryFragment = new MilitaryFragment();
                    transaction.replace(R.id.news_content, militaryFragment);
                } else {
                    transaction.show(militaryFragment);
                }
                break;
            case 2:
                //教育，设置字体颜色为蓝色
                news_education.setTextColor(Color.BLUE);
                if (educationFragment == null) {
                    EducationFragment educationFragment = new EducationFragment();
                    transaction.replace(R.id.news_content, educationFragment);
                } else {
                    transaction.show(educationFragment);
                }
                break;

            case 3:
                //娱乐，设置字体颜色为蓝色
                news_amusement.setTextColor(Color.BLUE);
                if (amusementFragment == null) {
                    AmusementFragment amusementFragment = new AmusementFragment();
                    transaction.replace(R.id.news_content, amusementFragment);
                } else {
                    transaction.show(amusementFragment);
                }
                break;
            case 4:
                //体育，设置字体颜色为蓝色
                news_pe.setTextColor(Color.BLUE);
                if (peFragment == null) {
                    PeFragment peFragment = new PeFragment();
                    transaction.replace(R.id.news_content, peFragment);
                } else {
                    transaction.show(peFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏之前的页面
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (wealthFragment != null) {
            transaction.hide(wealthFragment);
        }
        if (militaryFragment != null) {
            transaction.hide(wealthFragment);
        }
        if (peFragment != null) {
            transaction.hide(wealthFragment);
        }
        if (educationFragment != null) {
            transaction.hide(wealthFragment);
        }
        if (amusementFragment != null) {
            transaction.hide(wealthFragment);
        }
    }

    /**
     * 清除选项
     * 还原颜色
     */
    public void clearChoice() {
        news_wealth.setTextColor(Color.BLACK);
        news_military.setTextColor(Color.BLACK);
        news_education.setTextColor(Color.BLACK);
        news_amusement.setTextColor(Color.BLACK);
        news_pe.setTextColor(Color.BLACK);
    }
}
