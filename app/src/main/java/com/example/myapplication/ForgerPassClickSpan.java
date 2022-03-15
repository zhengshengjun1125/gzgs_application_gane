package com.example.myapplication;

import static android.graphics.Color.WHITE;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ForgerPassClickSpan extends ClickableSpan {
    private Context context;

    public ForgerPassClickSpan(Context context) {
        this.context = context;
    }
    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        //设置文本的颜色
        ds.setColor(Color.BLUE);
        //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(@NonNull View view) {
        //在这里做点击事件
        Intent intent = new Intent();
        intent.setClass(context,FindPassActivity.class);
        context.startActivity(intent);
        //Toast.makeText(context,"我暂时没有办法",Toast.LENGTH_SHORT).show();
    }


}
