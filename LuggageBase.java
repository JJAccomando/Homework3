package com.solvd.laba.homework3;

public class LuggageBase implements UniqueIDInterface {

    private int weight, iD = 0;
    public static int numLuggage = 0;
    public boolean isOverweight = false;

    //LuggageBase constructor
    //if new luggage object is over 50lbs then isOverweight is true
    public LuggageBase(int weight) {
        this.iD = ++numLuggage;
        this.weight = weight;
        if (this.weight > 50)
            this.isOverweight = true;
    }

    //returns unique LuggageBase objects id number
    @Override
    public int getId() {
        return this.iD;
    }

    //returns a String of a LuggageBase object as the object's id number
    @Override
    public String toString() {
        String myobj = "Bag ID#: " + this.iD;
        return myobj;
    }

    //compares 2 LuggageBase objects by comparing their object Strings
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof LuggageBase) {
            LuggageBase cast = (LuggageBase)obj;
            return this.toString() == cast.toString();
        }
        return false;
    }

    //LuggageBase objects hash code is set to its unique id#
    @Override
    public int hashCode() {
        return this.iD;
    }

}
