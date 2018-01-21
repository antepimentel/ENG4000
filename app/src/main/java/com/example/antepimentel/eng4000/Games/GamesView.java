package com.example.antepimentel.eng4000.Games;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.antepimentel.eng4000.Games.TapGame.TapGame;
import com.example.antepimentel.eng4000.R;

public class GamesView extends AppCompatActivity {

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_view);
        getSupportActionBar().setTitle(getString(R.string.games_title));

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TapGame tgView = new TapGame(getBaseContext(), getWindow().getDecorView().getMeasuredWidth(), getWindow().getDecorView().getMeasuredHeight());
                setContentView(tgView);
                getWindow().getDecorView().setBackgroundColor(Color.rgb(239,239,239));
            }
        });
    }



    public static void hideSystemUI(View decorView) {
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public static void keepScreenOn(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // don't dim screen
    }
}
