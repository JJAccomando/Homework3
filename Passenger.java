package com.solvd.laba.homework3;

public class Passenger implements UniqueIDInterface {
    
    private static final int MAX_LUGGAGE = 10;
    public String firstName;
    public String lastName;
    private int iD = 0;
    public static int numPassengers = 0;
    public LuggageBase[] myBags = new LuggageBase[MAX_LUGGAGE];
    private int countBags = 0;
    private Seat seat;

    //Passenger Class constructor 
    //creates new passenger with first and last name as given String parameters
    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = ++numPassengers;
    }

    //creates a Luggage or OversizeLuggage object depending on the int parameter
    //adds bag to the "myBags" array if array is not full
    public final boolean addBags(int weight) {
        boolean isFull = true;
        for (int i = 0; i < myBags.length; i++) {
            if (myBags[i] == null)
                isFull = false;
        }
        if (isFull) {
            return false;
        }
        if (weight > 50 ) {
            OversizeLuggage bag = new OversizeLuggage(weight);
            for (int i = 0; i < this.myBags.length; i++) {
                if (this.myBags[i] == null) {
                    this.myBags[i] = bag;
                    ++this.countBags;
                    break;
                }
            }
            return true;
        }
        LuggageBase bag = new LuggageBase(weight);
        for (int i = 0; i < this.myBags.length; i++) {
            if (this.myBags[i] == null) {
                this.myBags[i] = bag;
                ++this.countBags;
                break;
            }
        }
        return true;
    }

    //returns total number of bags this passenger has
    public final int numBags() {
        return this.countBags;
    }

    //assigns passenger with a seat number 
    //method is called in Flight Class when booking a passenger to a flight
    public final void setSeatNum(Seat seat) {
        this.seat = seat;
    }

    //returns this passengers seat number
    //if passenger does not belong to a flight then this will return -1
    public final String getSeatNum() {
        return this.seat.getId();
    }

    //returns unique id number created for every new passenger
    @Override
    public final int getId() {
        return this.iD;
    }

    //returns a String of a Passenger object as that object's id number
    @Override
    public final String toString() {
        String myobj = "Passenger ID#: " + this.iD;
        return myobj;
    }

    //compares 2 Passenger objects by comparing their object Strings
    @Override
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Passenger) {
            Passenger cast = (Passenger)obj;
            return this.toString() == cast.toString();
        }
        return false;
    }

    //Passenger objects hash code is set to its unique id#
    @Override
    public final int hashCode() {
        return this.iD;
    }

}
