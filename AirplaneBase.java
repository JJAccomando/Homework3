package com.solvd.laba.homework3;

public abstract class AirplaneBase implements Airplanes, UniqueID {
    
    public static int numPlanes;
    
    static
    {
        numPlanes = 0;
    }

    {
        ++numPlanes;
    }

    //returns plane classification
    abstract public String getClassification();
    
    //returns total number of seats on a specific type of airplane object
    abstract public int getTotalSeats();

    //returns total number of seats in First Class for a specific type of airplane object
    abstract public int getSeatsInFirst();

    //returns total number of seats in Business Class for a specific type of airplane object
    abstract public int getSeatsInBusiness();

    //returns total number of seats in Economy Class for a specific type of airplane object
    abstract public int getSeatsInEcon();

    abstract public int getId();

    //returns current total number of airplanes created
    public static int getNumPlanes() {
        return numPlanes;
    }
}
