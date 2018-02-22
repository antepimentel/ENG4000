package com.example.antepimentel.eng4000.Quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antepimentel.eng4000.Data.Helper;
import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QuizView extends AppCompatActivity {

    private Button submit;
    private TextView question;
    private RadioGroup radioGroup;
    private RadioButton op0;
    private RadioButton op1;
    private RadioButton op2;
    private RadioButton op3;

    private int currentQuestion;
    private ArrayList<QuizQuestion> quiz;
    private ArrayList<RadioButton> buttons = new ArrayList<RadioButton>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);
        getSupportActionBar().setTitle(getString(R.string.quiz_title));

        // Check timer
        Date today = new Date();

        // DEBUG CODE: START
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            today = sdf.parse("10/02/2018");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        // DEBUG CODE: END

        long todayInDays = TimeUnit.MILLISECONDS.toDays(today.getTime());
        long startInDays = TimeUnit.MILLISECONDS.toDays(Model.getWeekStartDate().getTime());
        long diff = todayInDays - startInDays;

        if(diff < 6){
            Toast.makeText(getApplicationContext(), "You must wait " + (6 - diff) + " days before attempting the quiz", Toast.LENGTH_SHORT).show();

            finish();
        } else {
            submit = (Button)findViewById(R.id.submit);
            question = (TextView)findViewById(R.id.questionView);
            radioGroup = (RadioGroup)findViewById(R.id.radio_group);

            op0 = (RadioButton)findViewById(R.id.op0);
            op1 = (RadioButton)findViewById(R.id.op1);
            op2 = (RadioButton)findViewById(R.id.op2);
            op3 = (RadioButton)findViewById(R.id.op3);

            buttons.add(op0);
            buttons.add(op1);
            buttons.add(op2);
            buttons.add(op3);

            quiz = Helper.getQuiz(Model.getQuizID());
            currentQuestion = 0;

            loadPage();

            submit.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    int selected = radioGroup.getCheckedRadioButtonId();
                    int indexOfSelected = radioGroup.indexOfChild(findViewById(selected));

                    if(indexOfSelected > 0){
                        quiz.get(currentQuestion).setSelected(indexOfSelected);

                        // Reply if answer is correct
                        if(quiz.get(currentQuestion).isCorrect()){
                            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                        }

                        if(quiz.size() - 1 == currentQuestion){
                            //END
                            int earned = Model.getWeeklyPoints()*2;
                            Toast.makeText(getApplicationContext(), "Congrats! You've earned " + earned + " points!", Toast.LENGTH_SHORT).show();
                            Model.addPoints(earned);
                            Model.weeklyReset();
                            finish();
                        } else {
                            // NEXT QUESTION
                            currentQuestion++;
                            loadPage();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "You must select an answer", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void loadPage(){

        radioGroup.clearCheck();
        question.setText(quiz.get(currentQuestion).getQuestion());

        for(int i = 0; i < buttons.size(); i++){
            if(i < quiz.get(currentQuestion).getOptions().length){
                buttons.get(i).setText(quiz.get(currentQuestion).getOptions()[i]);
            } else {
                buttons.get(i).setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        Model.saveData(getFilesDir());
    }
}