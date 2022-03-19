package com.example.myapplication.showcustomTarbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.Map;

public class MineFragment extends Fragment implements View.OnClickListener {

    Map<String,String> userInfo =MainActivity.userInfo();//得到当前用户信息
    Button exitSystemToLogin_btn;
    View view;

    /**
     * 从数据库中查询到当前登录用户信息
     * 然后在页面中进行展示
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment, container,false);
        String name =userInfo.get("username");
        String password = userInfo.get("password");
        TextView textView = view.findViewById(R.id.user_name_mine);
        if (name.equals("admin")){
            name="管理员";
        }
        textView.setText("当前用户为: "+name);
        exitSystemToLogin_btn = view.findViewById(R.id.exitSystemToLogin_btn);
        exitSystemToLogin_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exitSystemToLogin_btn:
                ExitSystemToLogin();
                break;
        }
    }

    private void ExitSystemToLogin() {
        //退出系统
        startActivity(new Intent(this.getContext(),MainActivity.class));
    }
}
