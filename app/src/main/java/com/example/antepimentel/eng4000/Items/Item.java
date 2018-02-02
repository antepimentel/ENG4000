package com.example.antepimentel.eng4000.Items;

/**
 * Created by Ante Pimentel on 2/1/2018.
 */

public class Item {

    private boolean isObtained;
    private String name;
    private int weight;
    private String icon;
    private String obtainedOn;

    public Item(String n, boolean obtained, int w){
        this.isObtained = obtained;
        this.name = n;
        this.weight = w;
    }

    public boolean isObtained() {
        return isObtained;
    }

    public void setObtained(boolean obtained) {
        isObtained = obtained;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int dropChance) {
        this.weight = dropChance;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getObtainedOn() {
        return obtainedOn;
    }

    public void setObtainedOn(String obtainedOn) {
        this.obtainedOn = obtainedOn;
    }
}
