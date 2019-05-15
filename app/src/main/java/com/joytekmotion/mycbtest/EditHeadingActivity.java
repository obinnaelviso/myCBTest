package com.joytekmotion.mycbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditHeadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_heading);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
