package com.example.myapplication.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * 工具类，连接sqllite  （单例模式）
 *
 */
public class SqlListConnectController extends SQLiteOpenHelper {

    //对外提供函数
    public static SqlListConnectController mInstance;
    public static synchronized SqlListConnectController getInstance(Context context){
        if (mInstance ==null){
            mInstance = new SqlListConnectController(context,"demo.db",null,1);
        }
        return mInstance;
    }

     //构造函数私有化
    private SqlListConnectController(@Nullable Context context, @Nullable String name,
                                     @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 该方法只会调用一次，如果你的表已经创建过了，那就不会再次调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table users(_id integer primary key autoincrement,name text NOT NULL UNIQUE,password text NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
