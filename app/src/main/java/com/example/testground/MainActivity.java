package com.example.testground;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat formatter;
    Date date;
    TextView dateShow,lanTV;
    Context context;
    Resources resources;
    public static String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateShow = findViewById(R.id.dateTv);
        lanTV = findViewById(R.id.lanTest);

        //init your locale
        if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")){
            context = LocaleHelper.setLocale(this, "en");
            resources = context.getResources();
        }
        else  if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("bn")){
            context = LocaleHelper.setLocale(this, "bn");
            resources = context.getResources();
        }

        setViewData();
        Log.d(TAG, "onCreate: "+LocaleHelper.getLanguage(MainActivity.this));


        findViewById(R.id.enBtn).setOnClickListener(v->{
            context = LocaleHelper.setLocale(MainActivity.this,"en");
            resources =context.getResources();
            setViewData();
        });
        findViewById(R.id.bnBtn).setOnClickListener(v->{
            context = LocaleHelper.setLocale(this, "bn");
            resources = context.getResources();
            setViewData();
        });
    }

    private void setViewData() {
        formatter = new SimpleDateFormat("HH:mm aa");

        try {
            date = formatter.parse("10:52 am");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getSupportActionBar().setTitle(resources.getString(R.string.app_title));
        lanTV.setText(resources.getString(R.string.app_test));
        dateShow.setText(formatter.format(date));
    }
}