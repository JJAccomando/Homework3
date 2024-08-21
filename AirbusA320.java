package com.solvd.laba.homework3;

public class AirbusA320 extends AirplaneBase implements A320 {

    private int iD = 0;
    private static int count = 0;

    //AirbusA380 object constructor
    public AirbusA320() {
        this.iD = ++count;
    }

    @Override
    public int getId() {
        return this.iD;
    }
    
    @Override
    public String getClassification() {
        return CLASSIFICATION;
    }

    //returns a String of an AirbusA380 object as the object's "CLASSIFICATION" and id number
    @Override
    public String toString() {
        String myobj = COMPANY + " " + CLASSIFICATION +
        "\nPlane ID#: " + this.getId();
        return myobj;
    }

    //compares 2 AirbusA380 objects by comparing their object Strings
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof AirbusA380) {
            AirbusA380 cast = (AirbusA380)obj;
            return this.toString() == cast.toString();
        }
        return false;
    }

    //AirbusA380 objects hash code is set to its unique id#
    @Override
    public int hashCode() {
        return this.getId() + TOTAL_SEATS;
    }

    @Override
    public int getTotalSeats() {
        return TOTAL_SEATS;
    }

    @Override
    public int getSeatsInFirst() {
        return TOTAL_IN_FIRST;
    }

    @Override
    public int getSeatsInBusiness() {
        return TOTAL_IN_BUSINESS;
    }

    @Override
    public int getSeatsInEcon() {
        return TOTAL_IN_ECONOMY;
    }

}
