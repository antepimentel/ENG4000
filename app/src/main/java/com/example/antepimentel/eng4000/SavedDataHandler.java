package com.example.antepimentel.eng4000;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Ante Pimentel on 2/21/2018.
 */

public class SavedDataHandler {

    private static final String baseDir = "savedData";
    private static final String fInt = "integers";
    private static final String fBool = "bools";
    private static final String fString = "strings";
    private static final String delim = "#";
    private static PrintStream f_out;
    private static Scanner f_in;


    public static void createFiles(File dir){
        File myDir = new File(dir, baseDir);
        if(!myDir.exists()){
            myDir.mkdir();
        }
        File f1 = new File(myDir, fInt);
        File f2 = new File(myDir, fBool);
        File f3 = new File(myDir, fString);

        System.out.println("========================== FILES CREATED ==========================");
    }

    public static void clearData(File dir){
        File myDir = new File(dir, baseDir);
        if(myDir.exists()){

            File f1 = new File(myDir, fInt);
            if(f1.exists())
                f1.delete();

            File f2 = new File(myDir, fBool);
            if(f2.exists())
                f2.delete();

            File f3 = new File(myDir, fString);
            if(f3.exists())
                f3.delete();
        }
        System.out.println("========================== DATA CLEARED ==========================");
        createFiles(dir);
    }

    public static void saveData(File dir){
        //String des = dir.getPath() + baseDir;
        File myDir = new File(dir, baseDir);
        if(!myDir.exists()){
            myDir.mkdir();
        }
        // SAVE INTEGERS
        try {
            //f_out = new PrintStream(new File(des+fInt));
            File temp = new File(myDir, fInt);
            f_out = new PrintStream(temp);

            f_out.print(Model.getLifetimeCompletedGoals());
            f_out.print(delim);

            f_out.print(Model.getLifetimePoints());
            f_out.print(delim);

            f_out.print(Model.getPointBalance());
            f_out.print(delim);

            f_out.print(Model.getWeeklyPoints());
            f_out.print(delim);

            f_out.print(Model.getQuizID());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // SAVE STRINGS
        try {
            File temp = new File(myDir, fString);
            f_out = new PrintStream(temp);

            f_out.print(Model.pinNumber);
            f_out.print(delim);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // SAVE BOOLEANS
        try {
            File temp = new File(myDir, fBool);
            f_out = new PrintStream(temp);

            f_out.print(Model.isQuizCompleted());
            f_out.print(delim);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("========================== DATA SAVED ==========================");
    }

    public static void loadData(File dir) throws FileNotFoundException {
        File myDir = new File(dir, baseDir);

        // LOAD INTEGERS

        //f_in = new Scanner(new File(des+fInt));
        File temp = new File(myDir, fInt);
        f_in = new Scanner(temp);

        StringTokenizer st = new StringTokenizer(f_in.nextLine(), delim);

        Model.setLifetimeCompletedGoals(Integer.parseInt(st.nextToken()));
        Model.setLifetimePoints(Integer.parseInt(st.nextToken()));
        Model.setPointBalance(Integer.parseInt(st.nextToken()));
        Model.setWeeklyPoints(Integer.parseInt(st.nextToken()));
        Model.setQuizID(Integer.parseInt(st.nextToken()));


        // LOAD STRINGS

        File temp2 = new File(myDir, fString);
        f_in = new Scanner(temp2);

        StringTokenizer st2 = new StringTokenizer(f_in.nextLine(), delim);
        Model.pinNumber = (st2.nextToken());


        // LOAD BOOLEANS

        File temp3 = new File(myDir, fBool);
        f_in = new Scanner(temp3);

        StringTokenizer st3 = new StringTokenizer(f_in.nextLine(), delim);

        Model.setIsQuizCompleted(Boolean.parseBoolean(st3.nextToken()));

        System.out.println("========================== DATA LOADED ==========================");
    }
}