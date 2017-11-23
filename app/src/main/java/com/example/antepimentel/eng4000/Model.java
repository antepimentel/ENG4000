package com.example.antepimentel.eng4000;
import android.os.Parcel;
import android.os.Parcelable;
import com.example.antepimentel.eng4000.Goals.Goal;
import com.example.antepimentel.eng4000.Goals.Helper;
import java.util.ArrayList;

/**
 * Created by Ante Pimentel on 11/21/2017.
 */

public class Model implements Parcelable{

    public static boolean isInitialized = false;
    public static ArrayList<Goal> sGoals = new ArrayList<Goal>();

    private ArrayList<Goal> goals = new ArrayList<Goal>();

//========= CONSTRUCTORS =========//

    public Model(){
        this.goals = new ArrayList<Goal>();
    }

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

    public void updateData(Model m){
        this.goals = m.getGoals();
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

//========= GETTERS AND SETTERS =========//

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

//========= PARCEL METHODS =========//

    @Override
    public int describeContents() {
        return 0;
    }

    private Model(Parcel in){
        in.readTypedList(goals, Goal.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(goals);
    }

    public static final Parcelable.Creator<Model> CREATOR= new Parcelable.Creator<Model>() {

        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);  //using parcelable constructor
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
