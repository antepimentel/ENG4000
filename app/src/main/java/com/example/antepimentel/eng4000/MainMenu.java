package com.example.antepimentel.eng4000;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Exceptions.NotEnoughPointsException;
import com.example.antepimentel.eng4000.Games.GamesView;
import com.example.antepimentel.eng4000.Goals.GoalView;
import com.example.antepimentel.eng4000.Items.ItemView;
import com.example.antepimentel.eng4000.Quiz.QuizView;

public class MainMenu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //getActionBar().setTitle("Menu");
        getSupportActionBar().setTitle(getString(R.string.menu_title));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        // Initialize model
        if(!Model.isInitialized){
            Model.loadData();
            System.out.println("==== Model data loaded ====");
            //System.out.println(Model.print());
        }

        // Goals
        Button b1 = (Button) findViewById(R.id.button1);
        Helper.setButtonSize(b1);
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
        Helper.setButtonSize(b2);
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, GamesView.class);
                startActivity(intent);
            }
        });

        // Stats
        Button b3 = (Button) findViewById(R.id.button3);
        Helper.setButtonSize(b3);
        b3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                System.out.println("GOT HERE");
                Intent intent = new Intent(MainMenu.this, StatsView.class);
                startActivity(intent);
            }
        });

        // Shop
        Button b4 = (Button) findViewById(R.id.button4);
        Helper.setButtonSize(b4);
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

            }
        });

        // Quiz
        Button b6 = (Button) findViewById(R.id.button6);
        Helper.setButtonSize(b6);
        b6.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, QuizView.class);
                startActivity(intent);
            }
        });

        // New Item
        Button b7 = (Button) findViewById(R.id.button7);
        Helper.setButtonSize(b7);
        b7.setText(getString(R.string.new_item) + "(" + Model.itemCost + ")");
        b7.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String message = "";

                try{
                    Model.subtractPoints(Model.itemCost);
                    int item = Model.getRandomItem();
                    Model.items.get(item).setObtained(true);
                    message = "You got: "+ Model.items.get(item).getName();

                } catch (NotEnoughPointsException e){
                    message = e.getMessage();
                }

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        // Char
        Button b8 = (Button) findViewById(R.id.button8);
        Helper.setButtonSize(b8);
        b8.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, CharacterView.class);
                startActivity(intent);
            }
        });
    }

}
