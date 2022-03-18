package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.util.SqlListConnectController;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }

    public void backForLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * 对用户的信息注册到数据库中
     *
     * @param view
     */
    public void register_user(View view) {
        //拿到用户输入的信息并且查询数据库中不包含这个数据之后在进行插入
        EditText E_username = findViewById(R.id.register_username);
        EditText E_password = findViewById(R.id.register_password);
        SqlListConnectController scc = SqlListConnectController.getInstance(this);
        SQLiteDatabase db = scc.getWritableDatabase();
        String username = E_username.getText().toString();
        String password = E_password.getText().toString();
        if (db.isOpen()) {
            Cursor users = db.query("users", null, "name=?", new String[]{username}, null, null, null);
            if (users.getCount() == 1) {
                Toast.makeText(this, "当前名字的用户已经存在了", Toast.LENGTH_SHORT).show();
            } else {
                //进行注册
                ContentValues values = new ContentValues();
                values.put("name", username);
                values.put("password", password);
                long result = db.insert("users", null, values);
                if (result != -1) {
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
}
