package com.example.antepimentel.eng4000.Goals;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ante Pimentel on 11/20/2017.
 *
 * Simple object class for holding Goal attributes
 */

public class Goal implements Parcelable{

    private String TITLE;
    private int VALUE;
    private int ID;
    private boolean COMPLETE;

    public Goal(String title, int value, int id){
        this.TITLE = title;
        this.VALUE = value;
        this.ID = id;
        this.COMPLETE = false;
    }

    public String print(){
        String temp = "";
        temp = "ID:       " + Integer.toString(this.getID()) +
             "\nTITLE:    " + this.getTITLE() +
             "\nVALUE:    " + Integer.toString(this.getVALUE()) +
             "\nCOMPLETE: " + this.isCOMPLETE() + "\n";
        return temp;
    }

    //========= PARCEL METHODS =========//

    private Goal(Parcel in){

        TITLE = in.readString();
        VALUE = in.readInt();
        ID = in.readInt();
        COMPLETE = in.readByte() != 0;
    }

    public static final Creator<Goal> CREATOR = new Creator<Goal>() {
        @Override
        public Goal createFromParcel(Parcel in) {
            return new Goal(in);
        }

        @Override
        public Goal[] newArray(int size) {
            return new Goal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TITLE);
        dest.writeInt(VALUE);
        dest.writeInt(ID);
        dest.writeByte((byte) (COMPLETE ? 1 : 0));
    }

    //========= GETTERS AND SETTERS =========//

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public int getVALUE() {
        return VALUE;
    }

    public void setVALUE(int VALUE) {
        this.VALUE = VALUE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isCOMPLETE() {
        return COMPLETE;
    }

    public void setCOMPLETE(boolean COMPLETE) {
        this.COMPLETE = COMPLETE;
    }

}
