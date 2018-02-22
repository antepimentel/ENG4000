package com.example.antepimentel.eng4000.Data;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Items.Item;
import com.example.antepimentel.eng4000.Quiz.QuizQuestion;
import com.example.antepimentel.eng4000.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 *
 * Just a utility class
 */

public class Helper {

    private static int buttonHeight = getScreenHeight()/10;
    private static int buttonWidth = (getScreenWidth()/2) - (getScreenWidth()/15);

    public static String game1 = "com.halfbrick.fruitninjafree";
    public static String game2 = "com.motionvolt.flipdiving";
    public static String game3 = "com.bitmango.rolltheballunrollme";

    public static final String df = "MMM dd, yyyy";

    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(df);
        return sdf.format(date);
    }

    public static Date parseDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat(df);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error parsing date");
        }
        return null;
    }

    public static ArrayList<Item> loadItems(){
        ArrayList<Item> temp = new ArrayList<Item>();

        //FACE
        temp.add(new Item("Glasses", R.mipmap.glasses1, R.drawable.glasses, false, Item.TYPE_FACE, 5));
        temp.add(new Item("3D Specs", R.mipmap.glasses2, R.drawable.threedspecs, false, Item.TYPE_FACE, 5));
        temp.add(new Item("Monocle", R.mipmap.monocle, R.drawable.monocle, false, Item.TYPE_FACE, 5));

        //HEAD
        temp.add(new Item("Cowboy Hat", R.mipmap.hat, R.drawable.cowboyhat, false, Item.TYPE_HEAD, 5));
        temp.add(new Item("Winter Hat", R.mipmap.winterhat, R.drawable.winterhat, false, Item.TYPE_HEAD, 5));
        temp.add(new Item("Sailor Hat", R.mipmap.sailorhat, R.drawable.sailorhat, false, Item.TYPE_HEAD, 5));

        //NECK
        temp.add(new Item("Fancy Tie", R.mipmap.fancytie, R.drawable.fancytie, false, Item.TYPE_NECK, 5));
        temp.add(new Item("Winter Scarf", R.mipmap.scarf, R.drawable.scarf, false, Item.TYPE_NECK, 5));
        temp.add(new Item("Fashionable Scarf", R.mipmap.fashionablescarf, R.drawable.fashionablescarf, false, Item.TYPE_NECK, 5));

        //TORSO
        temp.add(new Item("Winter Coat", R.mipmap.wintercoat, R.drawable.wintercoat, false, Item.TYPE_TORSO,5));
        temp.add(new Item("Suit", R.mipmap.suit, R.drawable.suit, false, Item.TYPE_TORSO,5));
        temp.add(new Item("Varsity Coat", R.mipmap.varsitycoat, R.drawable.varsitycoat, false, Item.TYPE_TORSO,5));

        //HANDS
        temp.add(new Item("Boxing Gloves", R.mipmap.boxinggloves, R.drawable.boxinggloves, false, Item.TYPE_HANDS,5));
        temp.add(new Item("Goalie Gloves", R.mipmap.goaliegloves, R.drawable.goaliegloves, false, Item.TYPE_HANDS,5));
        temp.add(new Item("Cozy Mittens", R.mipmap.mittens, R.drawable.mittens, false, Item.TYPE_HANDS,5));

        //FEET
        temp.add(new Item("Snow Shoes", R.mipmap.snowshoes, R.drawable.snowshoes, false, Item.TYPE_FEET,5));
        temp.add(new Item("Cowboy Boots", R.mipmap.cowboyboots, R.drawable.cowboyboots, false, Item.TYPE_FEET,5));
        temp.add(new Item("Sneakers", R.mipmap.sneakers, R.drawable.sneakers, false, Item.TYPE_FEET,5));

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
            case 1:
                quiz.add(new QuizQuestion(
                        "How much water do you use in an 8 minute shower?",
                        new String[]{
                                "1 litre",
                                "400 litre",
                                "62 litre",
                                "10 litre"},
                        2 ));

                quiz.add(new QuizQuestion(
                        "How many litres of water does an average bath use?",
                        new String[]{
                                "500 litres",
                                "80 litres",
                                "1000 litres",
                                "2 litres"},
                        1 ));
                break;

            case 0:
                quiz.add(new QuizQuestion(
                        "How much energy can you save by using the microwave instead of the oven?",
                        new String[]{
                                "Up to 100%",
                                "Up to 80%",
                                "Up to 1%",
                                "No savings"},
                        1 ));

                quiz.add(new QuizQuestion(
                        "Can microwaves be used to do all of the cooking?",
                        new String[]{
                                "Yes",
                                "No"},
                        1 ));
                break;

            case 2:
                quiz.add(new QuizQuestion(
                        "Which lights are more energy efficient?",
                        new String[]{
                                "Incandescent (Regular lights at home)",
                                "LEDs"},
                        1 ));

                quiz.add(new QuizQuestion(
                        "Which lights are more expensive?",
                        new String[]{
                                "LEDs",
                                "Incandescent"},
                        0 ));
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
