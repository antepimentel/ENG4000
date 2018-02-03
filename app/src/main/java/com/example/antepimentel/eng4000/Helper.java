package com.example.antepimentel.eng4000;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Items.Item;

import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 * Just a utility class
 */

public class Helper {

    private static int buttonHeight = getScreenHeight()/10;
    private static int buttonWidth = (getScreenWidth()/2) - (getScreenWidth()/15);

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

        int i = 0;

        temp.add(new Goal("Test1", 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test2", 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test3", 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test4", 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test5", 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_ELEC));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));
        temp.add(new Goal("Test"+i, 100, Goal.TYPE_WATER));

        return temp;
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
