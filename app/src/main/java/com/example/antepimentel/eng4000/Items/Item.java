package com.example.antepimentel.eng4000.Items;

/**
 * Created by Ante Pimentel on 2/1/2018.
 */

public class Item {

    public static final int TYPE_HEAD = 0;
    public static final int TYPE_FACE = 1;
    public static final int TYPE_NECK = 2;
    public static final int TYPE_TORSO = 3;
    public static final int TYPE_HANDS = 4;
    public static final int TYPE_FEET = 5;

    private boolean isObtained;
    private String name;
    private int type;
    private int weight;
    private int icon;
    private int image;
    private String obtainedOn;

    public Item(String n, int ic, int im, boolean obtained, int t, int w){
        this.isObtained = obtained;
        this.icon = ic;
        this.image = im;
        this.name = n;
        this.weight = w;
        this.type = t;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int dropChance) {
        this.weight = dropChance;
    }

    public int getIcon() {
        return icon;
    }

    public int getType(){
        return this.type;
    }

    public String getObtainedOn() {
        return obtainedOn;
    }

    public void setObtainedOn(String obtainedOn) {
        this.obtainedOn = obtainedOn;
    }

    public int getImage() {
        return image;
    }

}
