package com.example.antepimentel.eng4000.household;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.antepimentel.eng4000.R;

import java.util.ArrayList;

public class MyHousehold extends AppCompatActivity {

    ListView listView;
    ArrayList<Goal> goals = Helper.loadGoals();
    GoalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_household);
        getSupportActionBar().setTitle(getString(R.string.my_goals));

        listView = (ListView)findViewById(R.id.list_view);
        adapter = new GoalAdapter(MyHousehold.this, goals);

        listView.setAdapter(adapter);
    }
}
