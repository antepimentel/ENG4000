package com.example.antepimentel.eng4000;

import com.example.antepimentel.eng4000.Data.Model;
import com.example.antepimentel.eng4000.Data.SavedDataHandler;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by Ante Pimentel on 3/10/2018.
 */

public class SavedDataHandlerUnitTest {

    //String testDir = "savedData";
    public static File dir = new File("");
    public static File testDir = new File(dir, "savedData");

    @Before
    public void reset(){
        SavedDataHandler.clearData(dir);
    }

    @Test
    public void testSave(){
        Model.loadData();
        Model.saveData(dir);
        testDir.delete();

        File bools = new File(testDir, "bools");
        assertTrue(bools.exists());

        File ints = new File(testDir, "integers");
        assertTrue(ints.exists());

        File strings = new File(testDir, "strings");
        assertTrue(strings.exists());

        File items = new File(testDir, "items");
        assertTrue(items.exists());

        File character = new File(testDir, "char");
        assertTrue(character.exists());
    }

    @Test
    public void testLoad() throws FileNotFoundException{
        Model.loadData();
        Model.addPoints(1000);
        Model.setLifetimeCompletedGoals(7);
        Model.saveData(dir);

        Model.loadData();
        SavedDataHandler.loadData(dir);

        assertEquals(1000, Model.getWeeklyPoints());
        assertEquals(1000, Model.getLifetimePoints());
        assertEquals(1000, Model.getPointBalance());
        assertEquals(7, Model.getLifetimeCompletedGoals());
    }

    @Test
    public void testClear(){
        File bools = new File(testDir, "bools");
        assertFalse(bools.exists());

        File ints = new File(testDir, "integers");
        assertFalse(ints.exists());

        File strings = new File(testDir, "strings");
        assertFalse(strings.exists());

        File items = new File(testDir, "items");
        assertFalse(items.exists());

        File character = new File(testDir, "char");
        assertFalse(character.exists());
    }

    @Test
    public void createFresh(){
        File bools = new File(testDir, "bools");
        bools.delete();

        File ints = new File(testDir, "integers");
        ints.delete();

        File strings = new File(testDir, "strings");
        strings.delete();

        File items = new File(testDir, "items");
        items.delete();

        File character = new File(testDir, "char");
        character.delete();

        testDir.delete();

        SavedDataHandler.createFiles(dir);
        assertTrue(testDir.exists());
    }

    @Test
    public void saveFresh(){
        File bools = new File(testDir, "bools");
        bools.delete();

        File ints = new File(testDir, "integers");
        ints.delete();

        File strings = new File(testDir, "strings");
        strings.delete();

        File items = new File(testDir, "items");
        items.delete();

        File character = new File(testDir, "char");
        character.delete();

        testDir.delete();

        try {
            SavedDataHandler.saveData(dir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTrue(testDir.exists());
    }

}
