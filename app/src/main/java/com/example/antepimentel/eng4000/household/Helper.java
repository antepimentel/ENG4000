package com.example.antepimentel.eng4000.household;

import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 * Just a utility class
 */

public class Helper {

    public static ArrayList<Goal> loadGoals(){
        ArrayList<Goal> temp = new ArrayList<Goal>();

        int i = 0;

        temp.add(new Goal("Test", 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));
        temp.add(new Goal("Test"+i, 100, i++));



        return temp;
    }
}
