package com.example.antepimentel.eng4000.Quiz;

import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 2/3/2018.
 */

public class QuizQuestion {

    private String question;
    private String[] options;
    private int answer;
    private int selected;


    public boolean isCorrect(){
        System.out.println("Checking answer: Correct = " +answer+", Selected = " + selected );
        return answer == selected;
    }

    public QuizQuestion(String q, String[] op, int ans){
        question = q;
        options = op;
        answer = ans;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
