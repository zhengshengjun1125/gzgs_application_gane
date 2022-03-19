package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.util.SqlListConnectController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void insert(){

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat timeFormat= DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        String data = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
        String now = data +time;
        System.out.println(now);

    }
}