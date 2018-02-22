package com.example.antepimentel.eng4000.Settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Data.Helper;
import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.Data.SavedDataHandler;
import com.example.antepimentel.eng4000.R;

import java.util.Calendar;
import java.util.Date;

public class SettingsView extends AppCompatActivity {

    Button clear;
    Button points;
    Button adv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_view);
        getSupportActionBar().setTitle(getString(R.string.settings_title));

        clear = (Button)findViewById(R.id.clearData);
        clear.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SavedDataHandler.clearData(getFilesDir());
                Model.initialize(getFilesDir());
                Toast.makeText(getApplicationContext(), "Data Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        points = (Button)findViewById(R.id.t_addpoints);
        points.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Model.addPoints(1000);
                Toast.makeText(getApplicationContext(), "1000 Points added", Toast.LENGTH_SHORT).show();
            }
        });

        adv = (Button)findViewById(R.id.t_advweek);
        adv.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(Model.getWeekStartDate());
                cal.add(Calendar.DAY_OF_YEAR, -7);
                Model.setWeekStartDate(cal.getTime());
                Toast.makeText(getApplicationContext(), "WeekStart changed to: " + Helper.formatDate(Model.getWeekStartDate()), Toast.LENGTH_SHORT).show();
            }
        });

        reload();
    }

    private void reload(){
        Helper.setButtonSize(clear);
        if(Model.inTestMode){
            points.setVisibility(View.VISIBLE);
            adv.setVisibility(View.VISIBLE);
            Helper.setButtonSize(points);
            Helper.setButtonSize(adv);
        } else {
            points.setVisibility(View.GONE);
            adv.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id = item.getItemId();
        if(res_id == R.id.settings_test){

            Intent intent = new Intent(SettingsView.this, SettingsPin.class);
            startActivityForResult(intent, 1);

            //recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            System.out.println("Got Result!");
            Model.inTestMode = true;
            Toast.makeText(getApplicationContext(), "Tester options available", Toast.LENGTH_SHORT).show();
            reload();
        }
    }
}
