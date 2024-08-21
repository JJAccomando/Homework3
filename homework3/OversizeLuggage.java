package com.solvd.laba.homework3;

public class OversizeLuggage extends LuggageBase {
    
    //OversizeLuggage object constructor
    public OversizeLuggage(int weight) {
        super(weight);
    }

    //returns a String of an OversizeLuggage object as the object's id number
    @Override
    public final String toString() {
        String myobj = "Bag ID#: " + this.getId();
        return myobj;
    }

    //compares 2 OversizeLuggage objects by comparing their object Strings
    @Override
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof OversizeLuggage) {
            OversizeLuggage cast = (OversizeLuggage)obj;
            return this.toString() == cast.toString();
        }
        return false;
    }

    //OversizeLuggage objects hash code is set to its unique id#
    @Override
    public final int hashCode() {
        return this.getId();
    }

}
