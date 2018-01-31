package com.example.antepimentel.eng4000.Goals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Model;
import com.example.antepimentel.eng4000.R;

public class Submit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        EditText editText = (EditText) findViewById(R.id.editText);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String t = v.getText().toString();
                    String p = Model.pinNumber;

                    if(t.equals(p)){
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",1);
                        setResult(RESULT_OK,returnIntent);

                        System.out.println("GOT HERE");

                        killActivity();
                    } else {
                        System.out.println(v.getText());
                        System.out.println(Model.pinNumber);
                        Toast.makeText(getApplicationContext(), "Incorrect Pin: " + v.getText() + " " + Model.pinNumber, Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
    }

    private void killActivity(){
        finish();
    }
}
