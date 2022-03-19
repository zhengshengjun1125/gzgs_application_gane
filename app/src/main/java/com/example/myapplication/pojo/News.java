package com.example.myapplication.pojo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 新闻信息类
 */
public class News {
    private String title;  //标题
    private String message; //内容
    private int image;      //图片
    private String date;   //时间
    private String discussNumbers;//评论数
    private int discuss_icon;//评论图标
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    //获取当前时间
    public String getDate() {
        //时间格式化器
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        String data = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
        String now = data + time;
        return now;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscussNumbers() {
        return discussNumbers;
    }

    public void setDiscussNumbers(String discussNumbers) {
        this.discussNumbers = discussNumbers;
    }

    public int getDiscuss_icon() {
        return discuss_icon;
    }

    public void setDiscuss_icon(int discuss_icon) {
        this.discuss_icon = discuss_icon;
    }
}
