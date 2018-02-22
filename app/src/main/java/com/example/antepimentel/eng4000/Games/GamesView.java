package com.example.antepimentel.eng4000.Games;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.antepimentel.eng4000.Data.Helper;
import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.R;

public class GamesView extends AppCompatActivity {

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_view);
        getSupportActionBar().setTitle(getString(R.string.games_title));

        Button b1 = (Button)findViewById(R.id.button);
        Helper.setButtonSize(b1);
        b1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(GamesView.this, TapGameViewLauncher.class);
                //startActivity(intent);
                Intent game1 = new Intent(Intent.ACTION_VIEW);
                game1.setData(Uri.parse("market://details?id="+Helper.game1));
                startActivity(game1);
            }
        });

        Button b2 = (Button)findViewById(R.id.button8);
        Helper.setButtonSize(b2);
        b2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(GamesView.this, TapGameViewLauncher.class);
                //startActivity(intent);
                Intent game1 = new Intent(Intent.ACTION_VIEW);
                game1.setData(Uri.parse("market://details?id="+Helper.game2));
                startActivity(game1);
            }
        });

        Button b3 = (Button)findViewById(R.id.button9);
        Helper.setButtonSize(b3);
        b3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(GamesView.this, TapGameViewLauncher.class);
                //startActivity(intent);
                Intent game1 = new Intent(Intent.ACTION_VIEW);
                game1.setData(Uri.parse("market://details?id="+Helper.game3));
                startActivity(game1);
            }
        });

        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);

        TextView v1 = (TextView)findViewById(R.id.textView2);
        TextView v2 = (TextView)findViewById(R.id.textView3);
        TextView v3 = (TextView)findViewById(R.id.textView4);

        v1.setText("Unlocked at 100 points");
        v2.setText("Unlocked at 200 points");
        v3.setText("Unlocked at 300 points");

        if(Model.getLifetimePoints() > 100){
            b1.setEnabled(true);
            b1.setText("Fruit Ninja");
            v1.setText("Unlocked!");
        }

        if(Model.getLifetimePoints() > 200){
            b2.setEnabled(true);
            b2.setText("Flip Diving");
            v2.setText("Unlocked!");
        }

        if(Model.getLifetimePoints() > 300){
            b3.setEnabled(true);
            b3.setText("Roll the Ball");
            v3.setText("Unlocked!");
        }
    }
}
