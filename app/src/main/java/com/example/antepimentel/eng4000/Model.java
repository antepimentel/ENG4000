package com.example.antepimentel.eng4000;
import android.os.Parcel;
import android.os.Parcelable;
import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Goals.Helper;
import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/21/2017.
 */

public class Model{

    public static boolean isInitialized = false;
    public static ArrayList<Goal> sGoals = new ArrayList<Goal>();
    public static int points = 0;
    public static int numCompletedGoals= 0;

//========= METHODS =========//

    public void initialize(){
        // Does nothing so far
    }

    public static void loadData(){
        // Load fake data for now
        //this.goals = Helper.loadGoals();
        sGoals = Helper.loadGoals();
        isInitialized = true;
    }

    public static String print(){
        String temp = "==== BEGIN MODEL ====\n";
        for(int i = 0; i < sGoals.size(); i++){
            temp = temp + sGoals.get(i).print();
        }
        temp = temp + "==== END MODEL ====\n";
        return temp;
    }

    public static int getNumCompletedGoals(){
        int k = 0;
        for(int i = 0; i < sGoals.size(); i++){
            if(sGoals.get(i).isCOMPLETE()){
                k++;
            }
        }
        return k;
    }

    public static int getTotalScore(){
        int total = 0;
        for(int i = 0; i < sGoals.size(); i++){
            if(sGoals.get(i).isCOMPLETE()){
                total += sGoals.get(i).getVALUE();
            }
        }
        return total;
    }

    public static void resetGoals(){
        for(int i = 0; i < sGoals.size(); i++){
            if(sGoals.get(i).isCOMPLETE()){
                sGoals.get(i).setCOMPLETE(false);
            }
        }
    }

    public static void submitGoals(){

        numCompletedGoals += getNumCompletedGoals();
        points += getTotalScore();
        resetGoals();
    }
}
