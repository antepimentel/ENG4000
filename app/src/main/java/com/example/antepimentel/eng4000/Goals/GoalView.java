package com.example.antepimentel.eng4000.Goals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.antepimentel.eng4000.Model;
import com.example.antepimentel.eng4000.R;

import java.util.ArrayList;

public class GoalView extends AppCompatActivity {

    ListView listView;
    ArrayList<Goal> goals = Helper.loadGoals();
    GoalAdapter adapter;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_view);
        getSupportActionBar().setTitle(getString(R.string.my_goals));

        Bundle data = getIntent().getExtras();
        model = (Model)data.getParcelable("model");

        listView = (ListView)findViewById(R.id.list_view);
        adapter = new GoalAdapter(GoalView.this, model.getGoals());
        //adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}
