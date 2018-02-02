package com.example.antepimentel.eng4000;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Games.GamesView;
import com.example.antepimentel.eng4000.Goals.GoalView;
import com.example.antepimentel.eng4000.Items.ItemView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //getActionBar().setTitle("Menu");
        getSupportActionBar().setTitle(getString(R.string.menu_title));

        // Initialize model
        if(!Model.isInitialized){
            Model.loadData();
            System.out.println("==== Model data loaded ====");
            //System.out.println(Model.print());
        }

        // Goals
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, GoalView.class);
                startActivity(intent);
                //intent.putExtra("model", model);
                //startActivityForResult(intent, 1);
            }
        });

        // Games
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, GamesView.class);
                startActivity(intent);
            }
        });

        // Stats
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("GOT HERE");
                Intent intent = new Intent(MainMenu.this, StatsView.class);
                startActivity(intent);
            }
        });

        // Shop
        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("GOT HERE");
                Intent intent = new Intent(MainMenu.this, ItemView.class);
                startActivity(intent);
            }
        });

        // Settings
        Button b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int item = Model.getRandomItem();
                Toast.makeText(getApplicationContext(), "You got: "+ Model.items.get(item).getName(), Toast.LENGTH_SHORT).show();
                Model.items.get(item).setObtained(true);
            }
        });
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                Bundle bundle = getIntent().getExtras();
//                model.updateData((Model)bundle.getParcelable("model"));
//            }
//        }
//    }
}
