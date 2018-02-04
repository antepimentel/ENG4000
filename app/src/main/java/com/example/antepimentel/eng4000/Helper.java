package com.example.antepimentel.eng4000;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Items.Item;
import com.example.antepimentel.eng4000.Quiz.QuizQuestion;

import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 * Just a utility class
 */

public class Helper {

    private static int buttonHeight = getScreenHeight()/10;
    private static int buttonWidth = (getScreenWidth()/2) - (getScreenWidth()/15);

    public static String game1 = "com.halfbrick.fruitninjafree";
    public static String game2 = "com.motionvolt.flipdiving";
    public static String game3 = "com.bitmango.rolltheballunrollme";

    public static ArrayList<Item> loadItems(){
        ArrayList<Item> temp = new ArrayList<Item>();

        temp.add(new Item("Wizard Hat", true, 5));
        temp.add(new Item("Mittens", false, 5));
        temp.add(new Item("Birthday Hat", false, 5));
        temp.add(new Item("Tuxedo", true, 5));
        temp.add(new Item("Polka-dot Tie", false, 5));
        temp.add(new Item("Bow Tie", false, 1));
        temp.add(new Item("Snorkel and Goggles", false, 5));
        temp.add(new Item("Sombrero", true, 5));
        temp.add(new Item("Wizard Hat", false, 5));
        temp.add(new Item("Wizard Hat", false, 5));
        temp.add(new Item("Wizard Hat", false, 5));
        temp.add(new Item("Wizard Hat", false, 5));
        temp.add(new Item("Wizard Hat", false, 5));
        temp.add(new Item("Wizard Hat", false, 5));

        return temp;
    }

    public static ArrayList<Goal> loadGoals(){
        ArrayList<Goal> temp = new ArrayList<Goal>();

        temp.add(new Goal("Turn off tap while brushing teeth", Goal.POINT_SMALL, Goal.TYPE_WATER));
        temp.add(new Goal("Turn off lights in a room when no one is there", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Take shorter showers", Goal.POINT_SMALL, Goal.TYPE_WATER));
        temp.add(new Goal("Make sure your toys and clothes are not blocking the heating vents", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Unplug devices when not in use", Goal.POINT_SMALL, Goal.TYPE_ELEC));

        temp.add(new Goal("Try not to get your clothes dirty so you can wear them again without washing", Goal.POINT_SMALL, Goal.TYPE_WATER));
        temp.add(new Goal("Watch less TV and do more outdoor activities", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Turn off heating/cooling system if it is not too hot/cold", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Do homework in natural lighting", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Keep a jug of water in the fridge to avoid running tap for cold water", Goal.POINT_SMALL, Goal.TYPE_WATER));

        temp.add(new Goal("Get rechargeable batteries for your toys and devices", Goal.POINT_SMALL, Goal.TYPE_GREEN));
        temp.add(new Goal("Don't leave the refrigerator door open", Goal.POINT_SMALL, Goal.TYPE_ELEC));
        temp.add(new Goal("Check for any dripping faucets and let an adult know to replace it if it is dripping", Goal.POINT_SMALL, Goal.TYPE_WATER));
        temp.add(new Goal("Make a solar oven", Goal.POINT_LRG, Goal.TYPE_GREEN));
        temp.add(new Goal("With the help of an adult, replace old light bulbs with new compact fluorescent bulbs", Goal.POINT_MED, Goal.TYPE_ELEC));

        return temp;
    }

    public static ArrayList<QuizQuestion> getQuiz(int i){
        ArrayList<QuizQuestion> quiz = new ArrayList<QuizQuestion>();

        switch(i){
            case 0:
                quiz.add(new QuizQuestion(
                        "Question 1",
                        new String[]{
                                "Op1",
                                "Op2",
                                "Op3",
                                "Op4"},
                        1 ));

                quiz.add(new QuizQuestion(
                        "Question 2",
                        new String[]{
                                "Op1",
                                "Op2",
                                "Op3",
                                "Op4"},
                        3 ));
                break;

            case 1:
                quiz.add(new QuizQuestion(
                        "question 1",
                        new String[]{
                                "Op1",
                                "Op2",
                                "Op3",
                                "Op4"},
                        1 ));

                quiz.add(new QuizQuestion(
                        "question 2",
                        new String[]{
                                "Op1",
                                "Op2",
                                "Op3",
                                "Op4"},
                        3 ));
                break;
        }

        return quiz;
    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static void setButtonSize(Button b){
        ViewGroup.LayoutParams params = b.getLayoutParams();
        params.width = buttonWidth;
        params.height = buttonHeight;
        b.setLayoutParams(params);
    }
}
