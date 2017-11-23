package com.example.antepimentel.eng4000.Goals;

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

        temp.add(new Goal("Test1", 100, 0));
        temp.add(new Goal("Test2", 100, 1));
        temp.add(new Goal("Test3", 100, 2));
        temp.add(new Goal("Test4", 100, 3));
        temp.add(new Goal("Test5", 100, 4));
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
