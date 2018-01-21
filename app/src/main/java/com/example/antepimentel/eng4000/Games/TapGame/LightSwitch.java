package com.example.antepimentel.eng4000.Games.TapGame;

/**
 * Created by Ante Pimentel on 1/20/2018.
 */

public class LightSwitch {

    private boolean isOn;

    public LightSwitch(){
        isOn = false;
    }

    public boolean getIsOn(){
        return isOn;
    }

    public void setIsOn(boolean temp){
        isOn = temp;
    }
}
