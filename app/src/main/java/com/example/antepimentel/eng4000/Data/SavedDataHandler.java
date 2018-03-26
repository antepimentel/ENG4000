package com.example.antepimentel.eng4000.Data;

import com.example.antepimentel.eng4000.Items.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private static final String fItems = "items";
    private static final String fChar = "char";
    private static final String delim = "#";
    private static PrintStream f_out;
    private static Scanner f_in;


    public static void createFiles(File dir) {
        File myDir = new File(dir, baseDir);
        if(!myDir.exists()){
            myDir.mkdir();
        }
        File f1 = new File(myDir, fInt);
        File f2 = new File(myDir, fBool);
        File f3 = new File(myDir, fString);
        File f4 = new File(myDir, fItems);
        File f5 = new File(myDir, fChar);

        System.out.println("========================== FILES CREATED ==========================");
        System.out.println(myDir.getAbsoluteFile());
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

            File f4 = new File(myDir, fItems);
            if(f4.exists())
                f4.delete();

            File f5 = new File(myDir, fChar);
            if(f5.exists())
                f5.delete();
        }
        System.out.println("========================== DATA CLEARED ==========================");
        createFiles(dir);
    }

    public static void saveData(File dir) throws FileNotFoundException {
        //String des = dir.getPath() + baseDir;
        File myDir = new File(dir, baseDir);
        if (!myDir.exists()) {
            myDir.mkdir();
        }

        File strings = new File(myDir, fString);
        File integers = new File(myDir, fInt);
        File items = new File(myDir, fItems);
        File character = new File(myDir, fChar);
        File bools = new File(myDir, fBool);


        // SAVE INTEGERS
        f_out = new PrintStream(integers);

        f_out.print(Model.getLifetimeCompletedGoals());
        f_out.print(delim);

        f_out.print(Model.getLifetimePoints());
        f_out.print(delim);

        f_out.print(Model.getPointBalance());
        f_out.print(delim);

        f_out.print(Model.getWeeklyPoints());
        f_out.print(delim);

        f_out.print(Model.getQuizID());


        // SAVE STRINGS
        f_out = new PrintStream(strings);

        f_out.print(Model.pinNumber);
        f_out.print(delim);

        f_out.print(Helper.formatDate(Model.getWeekStartDate()));
        f_out.print(delim);


        // SAVE BOOLEANS
        f_out = new PrintStream(bools);

        f_out.print(Model.isQuizCompleted());
        f_out.print(delim);


        // SAVE ITEMS
        f_out = new PrintStream(items);

        for (int i = 0; i < Model.getItems().size(); i++) {
            f_out.print(Model.getItems().get(i).isObtained());
            f_out.print(delim);
        }


        // SAVE SLOTS
        f_out = new PrintStream(character);

        f_out.print(Model.getSlots().get(Item.TYPE_HEAD));
        f_out.print(delim);

        f_out.print(Model.getSlots().get(Item.TYPE_FACE));
        f_out.print(delim);

        f_out.print(Model.getSlots().get(Item.TYPE_NECK));
        f_out.print(delim);

        f_out.print(Model.getSlots().get(Item.TYPE_TORSO));
        f_out.print(delim);

        f_out.print(Model.getSlots().get(Item.TYPE_HANDS));
        f_out.print(delim);

        f_out.print(Model.getSlots().get(Item.TYPE_FEET));
        f_out.print(delim);


        f_out.close();
        System.out.println("========================== DATA SAVED ==========================");
        System.out.println(myDir.getAbsolutePath());
    }

    public static void loadData(File dir) throws FileNotFoundException {
        File myDir = new File(dir, baseDir);

        // LOAD INTEGERS
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
        Model.setWeekStartDate(Helper.parseDate(st2.nextToken()));


        // LOAD BOOLEANS
        File temp3 = new File(myDir, fBool);
        f_in = new Scanner(temp3);

        StringTokenizer st3 = new StringTokenizer(f_in.nextLine(), delim);
        Model.setIsQuizCompleted(Boolean.parseBoolean(st3.nextToken()));


        // LOAD ITEMS
        File temp4 = new File(myDir, fItems);
        f_in = new Scanner(temp4);

        StringTokenizer st4 = new StringTokenizer(f_in.nextLine(), delim);
        for(int i = 0; i < Model.getItems().size(); i++){
            Model.getItems().get(i).setObtained(Boolean.parseBoolean(st4.nextToken()));
        }

        // LOAD CHAR
        File temp5 = new File(myDir, fChar);
        f_in = new Scanner(temp5);

        StringTokenizer st5 = new StringTokenizer(f_in.nextLine(), delim);
        Model.getSlots().put(Item.TYPE_HEAD, Integer.parseInt(st5.nextToken()));
        Model.getSlots().put(Item.TYPE_FACE, Integer.parseInt(st5.nextToken()));
        Model.getSlots().put(Item.TYPE_NECK, Integer.parseInt(st5.nextToken()));
        Model.getSlots().put(Item.TYPE_TORSO, Integer.parseInt(st5.nextToken()));
        Model.getSlots().put(Item.TYPE_HANDS, Integer.parseInt(st5.nextToken()));
        Model.getSlots().put(Item.TYPE_FEET, Integer.parseInt(st5.nextToken()));


        f_in.close();
        System.out.println("========================== DATA LOADED ==========================");
    }
}