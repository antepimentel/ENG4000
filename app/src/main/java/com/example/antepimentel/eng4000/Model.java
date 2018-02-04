package com.example.antepimentel.eng4000;
import android.content.Context;

import com.example.antepimentel.eng4000.Exceptions.NotEnoughPointsException;
import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Items.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ante Pimentel on 11/21/2017.
 */

public class Model{

    //==== UNSAVED SYSTEM VALUES ====//
    public static boolean isInitialized = false;
    public static int itemCost = 100;

    //==== SAVED VALUES ====//
    // Stats
    public static int numCompletedGoals= 0;
    private static int lifetimePoints = 0;
    private static int pointBalance = 0;

    // Weekly Values
    private static Date weekStartDate = new Date();
    private static int weeklyPoints = 0;
    private static boolean isQuizCompleted = false;
    private static int quizID = 0;

    // Settings
    public static String pinNumber = "0000";

    // Data
    public static ArrayList<Item> items = new ArrayList<Item>();
    public static ArrayList<Goal> sGoals = new ArrayList<Goal>();

    //========= METHODS =========//
    public void initialize(){
        // Load saved data

    }

    public static void weeklyReset(){
        weeklyPoints = 0;
        weekStartDate = new Date();
        isQuizCompleted = false;
        quizID++;
    }

    public static void loadData(){
        sGoals = Helper.loadGoals();
        items = Helper.loadItems();
        isInitialized = true;
    }

    public static void addPoints(int p){
        lifetimePoints = lifetimePoints + p;
        pointBalance = pointBalance + p;
        weeklyPoints = weeklyPoints + p;
    }

    public static void subtractPoints(int p) throws NotEnoughPointsException{
        if(pointBalance - p >= 0){
            pointBalance = pointBalance - p;
        } else {
            throw new NotEnoughPointsException("Not enough points");
        }
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
        addPoints(getTotalScore());
        resetGoals();
    }

    public static int getTotalItemWeight(){
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            total = total + items.get(i).getWeight();
        }
        return total;
    }

    private static int randomIntWithinRange(){
        int total = getTotalItemWeight();
        return (int)(Math.random() * total) + 1;
    }

    public static int getRandomItem(){
        int target = randomIntWithinRange();
        int counter = 0;
        int i, j;

        for(i = 0; i < items.size(); i++){
            for(j = 0; j < items.get(i).getWeight(); j++){
                if(counter == target){
                    return i;
                } else {
                    counter++;
                }
            }
        }
        return -1;
    }

    public void loadSavedData(){
        //TODO
    }

    public void saveData(Context context){
        //TODO
        File dir = context.getFilesDir();

    }

    // GETTERS AND SETTERS
    public static int getPointBalance(){
        return pointBalance;
    }

    public static int getLifetimePoints(){
        return lifetimePoints;
    }

    public static int getWeeklyPoints(){
        return weeklyPoints;
    }

    public static int getQuizID(){
        return quizID;
    }

    public static Date getWeekStartDate(){
        return weekStartDate;
    }
}