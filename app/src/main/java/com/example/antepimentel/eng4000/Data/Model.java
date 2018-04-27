package com.example.antepimentel.eng4000.Data;

import com.example.antepimentel.eng4000.Exceptions.PointsException;
import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Items.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Ante Pimentel on 11/21/2017.
 */

public class Model{

    //==== UNSAVED SYSTEM VALUES ====//
    public static boolean isInitialized = false;
    public static int itemCost = 100;
    public static boolean inTestMode = false;
    public static String testPin = "4000";

    //==== SAVED VALUES ====//
    // Stats
    private static int lifetimeCompletedGoals = 0;
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
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Goal> goals = new ArrayList<Goal>();

    // Equip Items
    private static HashMap<Integer, Integer> slots = new HashMap<Integer, Integer>();

    //========= METHODS =========//
    public static void initialize(File dir){
        // Load saved data
        loadData();

        try {
            SavedDataHandler.loadData(dir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            SavedDataHandler.createFiles(dir);
        } catch (Exception e){
            e.printStackTrace();
            SavedDataHandler.clearData(dir);
        }
    }

    public static void saveData(File dir){
        try {
            SavedDataHandler.saveData(dir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            SavedDataHandler.clearData(dir);
        }
    }

    public static void weeklyReset(){
        weeklyPoints = 0;
        weekStartDate = new Date();
        isQuizCompleted = false;
        quizID++;
    }

    public static void loadData(){
        goals = Helper.loadGoals();
        items = Helper.loadItems();

        slots.put(Item.TYPE_FACE, -1);
        slots.put(Item.TYPE_HEAD, -1);
        slots.put(Item.TYPE_NECK, -1);
        slots.put(Item.TYPE_TORSO, -1);
        slots.put(Item.TYPE_FEET, -1);
        slots.put(Item.TYPE_HANDS, -1);

        lifetimeCompletedGoals = 0;
        lifetimePoints = 0;
        pointBalance = 0;

        // Weekly Values
        weekStartDate = new Date();
        weeklyPoints = 0;
        isQuizCompleted = false;
        quizID = 0;

        // Settings
        pinNumber = "0000";

        isInitialized = true;
    }

    public static void addPoints(int p) throws PointsException{
        if(p<0){
            throw new PointsException("Value is negative");
        } else if(lifetimePoints+p > Integer.MAX_VALUE){
            throw new PointsException("Max point value reached");
        }

        lifetimePoints = lifetimePoints + p;
        pointBalance = pointBalance + p;
        weeklyPoints = weeklyPoints + p;
    }

    public static void subtractPoints(int p) throws PointsException{
        if(p<0){
            throw new PointsException("Value is negative");
        } else if(pointBalance - p >= 0){
            pointBalance = pointBalance - p;
        } else {
            throw new PointsException("Not enough points");
        }
    }

    public static String print(){
        String temp = "==== BEGIN MODEL ====\n";
        for(int i = 0; i < goals.size(); i++){
            temp = temp + goals.get(i).print();
        }
        temp = temp + "==== END MODEL ====\n";
        return temp;
    }

    public static int getNumCompletedGoals(){
        int k = 0;
        for(int i = 0; i < goals.size(); i++){
            if(goals.get(i).isCOMPLETE()){
                k++;
            }
        }
        return k;
    }

    public static int getTotalScore(){
        int total = 0;
        for(int i = 0; i < goals.size(); i++){
            if(goals.get(i).isCOMPLETE()){
                total += goals.get(i).getVALUE();
            }
        }
        return total;
    }

    public static void resetGoals(){
        for(int i = 0; i < goals.size(); i++){
            if(goals.get(i).isCOMPLETE()){
                goals.get(i).setCOMPLETE(false);
            }
        }
    }

    public static void submitGoals(){
        lifetimeCompletedGoals += getNumCompletedGoals();
        addPoints(getTotalScore());
        resetGoals();
    }

    public static int getTotalItemWeight(){
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            if(!items.get(i).isObtained()) {
                total = total + items.get(i).getWeight();
            }
        }
        return total;
    }

    private static int randomIntWithinRange(){
        int total = getTotalItemWeight();
        return (int)(Math.random() * total);
    }

    public static int getRandomItem(){
        int target = randomIntWithinRange();
        int counter = 0;
        int i, j;

        for(i = 0; i < items.size(); i++){
            if(!items.get(i).isObtained()){
                for(j = 0; j < items.get(i).getWeight(); j++){
                    if(counter == target){
                        items.get(i).setObtained(true);
                        return i;
                    } else {
                        counter++;
                    }
                }
            }
        }
        return -1;
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

    public static HashMap<Integer, Integer> getSlots() {
        return slots;
    }

    public static boolean isQuizCompleted() {
        return isQuizCompleted;
    }

    public static void setIsQuizCompleted(boolean isQuizCompleted) {
        Model.isQuizCompleted = isQuizCompleted;
    }

    public static void setLifetimeCompletedGoals(int lifetimeCompletedGoals) {
        Model.lifetimeCompletedGoals = lifetimeCompletedGoals;
    }

    public static void setLifetimePoints(int lifetimePoints) {
        Model.lifetimePoints = lifetimePoints;
    }

    public static void setPointBalance(int pointBalance) {
        Model.pointBalance = pointBalance;
    }

    public static void setWeeklyPoints(int weeklyPoints) {
        Model.weeklyPoints = weeklyPoints;
    }

    public static void setQuizID(int quizID) {
        Model.quizID = quizID;
    }

    public static int getLifetimeCompletedGoals() {
        return lifetimeCompletedGoals;
    }

    public static void setWeekStartDate(Date weekStartDate) {
        Model.weekStartDate = weekStartDate;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Model.items = items;
    }

    public static ArrayList<Goal> getGoals() {
        return goals;
    }

    public static void setGoals(ArrayList<Goal> goals) {
        Model.goals = goals;
    }
}