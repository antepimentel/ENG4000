package com.example.antepimentel.eng4000.Games.TapGame;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.antepimentel.eng4000.R;

public class TapGameViewLauncher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.activity_tag_game_view_launcher);

        TapGame tgView = new TapGame(getBaseContext(), getWindow().getDecorView().getMeasuredWidth(), getWindow().getDecorView().getMeasuredHeight());
        setContentView(tgView);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(239,239,239));
    }
}
