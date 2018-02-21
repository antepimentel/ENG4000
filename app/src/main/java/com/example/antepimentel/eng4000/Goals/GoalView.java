package com.example.antepimentel.eng4000.Goals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Model;
import com.example.antepimentel.eng4000.R;

public class GoalView extends AppCompatActivity {

    ListView listView;
    GoalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_view);
        getSupportActionBar().setTitle(getString(R.string.my_goals));


        listView = (ListView)findViewById(R.id.list_view);
        adapter = new GoalAdapter(GoalView.this, Model.sGoals);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_goalview, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id = item.getItemId();
        if(res_id == R.id.goal_submit){

            Intent intent = new Intent(GoalView.this, Submit.class);
            startActivityForResult(intent, 1);

            //recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            System.out.println("Got Result!");
            int total = Model.getTotalScore();
            Model.submitGoals();
            Toast.makeText(getApplicationContext(), "Goals Submitted. New Score: " + Model.getPointBalance(), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        Model.saveData(getFilesDir());
    }
}
