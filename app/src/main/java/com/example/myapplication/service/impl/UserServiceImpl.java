package com.example.myapplication.service.impl;

import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.service.UserService;
import com.example.myapplication.util.SqlListConnectController;

public class UserServiceImpl implements UserService {
    /**
     * 检测表中是否含有指定数据
     * @return 存在返回1，不存在返回-1
     */
    @Override
    public int userIsExist() {
        return -1;
    }
}
