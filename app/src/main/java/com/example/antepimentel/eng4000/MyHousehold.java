package com.example.antepimentel.eng4000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyHousehold extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_household);
        getSupportActionBar().setTitle(getString(R.string.my_household_title));
    }
}
