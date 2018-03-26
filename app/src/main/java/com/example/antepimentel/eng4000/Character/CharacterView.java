package com.example.antepimentel.eng4000.Character;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.Items.Item;
import com.example.antepimentel.eng4000.Items.ItemView;
import com.example.antepimentel.eng4000.R;

public class CharacterView extends AppCompatActivity {

    private ImageView ivHead;
    private ImageView ivFace;
    private ImageView ivTorso;
    private ImageView ivHands;
    private ImageView ivNeck;
    private ImageView ivFeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characterview);
        getSupportActionBar().setTitle(getString(R.string.character));

        ivHead = (ImageView)findViewById(R.id.head);
        ivFace = (ImageView)findViewById(R.id.face);
        ivTorso = (ImageView)findViewById(R.id.torso);
        ivHands = (ImageView)findViewById(R.id.hands);
        ivNeck = (ImageView)findViewById(R.id.neck);
        ivFeet = (ImageView)findViewById(R.id.feet);

        refreshView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_char, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int res_id = item.getItemId();
        if(res_id == R.id.menu_item){

            Intent intent = new Intent(CharacterView.this, ItemView.class);
            startActivityForResult(intent, 1);

            //recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        refreshView();
    }

    private void refreshView(){
        setResID(ivHead, Item.TYPE_HEAD);
        setResID(ivFace, Item.TYPE_FACE);
        setResID(ivTorso, Item.TYPE_TORSO);
        setResID(ivHands, Item.TYPE_HANDS);
        setResID(ivNeck, Item.TYPE_NECK);
        setResID(ivFeet, Item.TYPE_FEET);
    }

    private void setResID(ImageView iv, int type){
        int resID = Model.getSlots().get(type);
        if(resID < 0){
            iv.setVisibility(View.GONE);
        } else {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(resID);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        Model.saveData(getFilesDir());
    }
}