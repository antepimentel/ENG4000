package com.example.antepimentel.eng4000;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.antepimentel.eng4000.household.MyHousehold;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //getActionBar().setTitle("Menu");
        getSupportActionBar().setTitle(getString(R.string.menu_title));

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MyHousehold.class);
                startActivity(intent);
            }
        });

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
            }
        });

        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
            }
        });

        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
            }
        });
    }
}
