package com.example.antepimentel.eng4000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        getSupportActionBar().setTitle(getString(R.string.stats_title));

        TextView tv_numGoals = (TextView)findViewById(R.id.tv_numGoals);
        TextView  tv_score = (TextView)findViewById(R.id.tv_score);
        TextView  tv_weeklyScore = (TextView)findViewById(R.id.tv_weeklyscore);
        TextView  tv_lifetimescore = (TextView)findViewById(R.id.tv_lifetimescore);

        tv_numGoals.setText("Completed Goals: " + Integer.toString(Model.getLifetimeCompletedGoals()));
        tv_score.setText("Total Score: " + Integer.toString(Model.getPointBalance()));
        tv_weeklyScore.setText("Weekly Score: " + Model.getWeeklyPoints());
        tv_lifetimescore.setText("Lifetime Score: " + Model.getLifetimePoints());
    }
}
