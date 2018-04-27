package com.example.antepimentel.eng4000;

import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.Data.SavedDataHandler;
import com.example.antepimentel.eng4000.Exceptions.PointsException;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.NoSuchElementException;


/**
 * Created by Ante Pimentel on 3/01/2018.
 */

public class ModelUnitTest {

    @BeforeClass
    public static void setup(){
        Model.loadData();
    }

    @Test
    public void testWeeklyReset(){
        int oldID = Model.getQuizID();
        Model.weeklyReset();
        assertEquals(0, Model.getWeeklyPoints());
        assertEquals(new Date(), Model.getWeekStartDate());
        assertEquals(false, Model.isQuizCompleted());
        assertEquals(oldID+1, Model.getQuizID());
    }

    @Test
    public void testAddPoints1(){
        int value = 10000;

        Model.loadData();
        Model.addPoints(value);
        assertEquals(value, Model.getLifetimePoints());
        assertEquals(value, Model.getPointBalance());
        assertEquals(value, Model.getWeeklyPoints());
    }

    @Test(expected = PointsException.class)
    public void testAddPoints2(){
        int value = -1;

        Model.loadData();
        Model.addPoints(value);
    }

    @Test(expected = PointsException.class)
    public void testAddPoints3(){
        int value = Integer.MAX_VALUE;

        Model.loadData();
        Model.addPoints(value + 1);
    }

    @Test
    public void testSubtractPoints1(){
        int value = 10000;
        Model.loadData();
        Model.addPoints(value);

        Model.subtractPoints(value-100);
        assertEquals(value, Model.getLifetimePoints());
        assertEquals(100, Model.getPointBalance());
        assertEquals(value, Model.getWeeklyPoints());
    }

    @Test(expected = PointsException.class)
    public void testSubtractPoints2(){
        int value = -1;
        Model.loadData();
        Model.addPoints(value);

        Model.subtractPoints(value);
    }

    @Test(expected = PointsException.class)
    public void testSubtractPoints3(){
        int value = Integer.MAX_VALUE;
        Model.loadData();
        Model.addPoints(value);

        Model.subtractPoints(value + 1);
    }

    @Test
    public void testGetNumCompletedGoals(){
        Model.loadData();
        int expected = 3;
        for(int i = 0; i < expected; i++){
            Model.getGoals().get(i).setCOMPLETE(true);
        }
        assertEquals(expected, Model.getNumCompletedGoals());
    }

    @Test
    public void testGetTotalScore(){
        Model.loadData();
        for(int i = 0; i < 3; i++){
            Model.getGoals().get(i).setCOMPLETE(true);
        }
        assertEquals(15, Model.getTotalScore());
    }

    @Test
    public void testResetGoals(){
        Model.loadData();
        for(int i = 0; i < 3; i++){
            Model.getGoals().get(i).setCOMPLETE(true);
        }

        Model.resetGoals();
        boolean temp = false;

        for(int i = 0; i < Model.getGoals().size(); i++){
            temp = temp || Model.getGoals().get(i).isCOMPLETE();
        }
        assertEquals(false, temp);
    }

    @Test
    public void testSubmitGoals(){
        Model.loadData();
        for(int i = 0; i < 3; i++){
            Model.getGoals().get(i).setCOMPLETE(true);
        }

        Model.submitGoals();
        assertEquals(3, Model.getLifetimeCompletedGoals());
    }

    @Test
    public void testGetTotalItemWeight(){
        assertEquals(90, Model.getTotalItemWeight());
    }

    @Test
    public void testRandomItem(){
        int numTests = 5000;
        for(int i = 0; i < numTests; i++){
            int result = Model.getRandomItem();
            assertTrue("Value out of range: "+result,0 <= result && result < Model.getItems().size());
        }
    }


    // Fresh Start
    @Test
    public void init1(){
        File dir = SavedDataHandlerUnitTest.dir;
        File myDir = SavedDataHandlerUnitTest.testDir;
        if(myDir.exists()){

            File f1 = new File(myDir, "integers");
            if(f1.exists())
                f1.delete();

            File f2 = new File(myDir, "bools");
            if(f2.exists())
                f2.delete();

            File f3 = new File(myDir, "strings");
            if(f3.exists())
                f3.delete();

            File f4 = new File(myDir, "items");
            if(f4.exists())
                f4.delete();

            File f5 = new File(myDir, "char");
            if(f5.exists())
                f5.delete();
        }
        myDir.delete();
        Model.initialize(dir);

        assertTrue(SavedDataHandlerUnitTest.testDir.exists());
    }

    // Prev files
    @Test
    public void init2(){
        Model.loadData();
        Model.setLifetimeCompletedGoals(10);
        Model.saveData(SavedDataHandlerUnitTest.dir);

        Model.initialize(SavedDataHandlerUnitTest.dir);

        assertEquals(10, Model.getLifetimeCompletedGoals());
    }

    // Corrupt files
    @Test
    public void init3(){
        Model.loadData();
        Model.setLifetimeCompletedGoals(10);
        Model.saveData(SavedDataHandlerUnitTest.dir);

        try {
            File temp = new File(SavedDataHandlerUnitTest.testDir, "integers");
            temp.delete();
            PrintStream f_out = new PrintStream(temp);
            f_out.print("#");
            f_out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Model.initialize(SavedDataHandlerUnitTest.dir);
        return;
        // All errors should be handled internally
    }

    @Test
    public void getAllItems(){
        Model.loadData();

        for(int i = 0; i < Model.getItems().size(); i++){
            Model.getRandomItem();
        }

        for(int j = 0; j < Model.getItems().size(); j++){
            System.out.println(j + " : " + Model.getItems().get(j).isObtained());
            assertTrue(Model.getItems().get(j).isObtained());
        }
    }
}