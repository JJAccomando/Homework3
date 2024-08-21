package com.solvd.laba.homework3;

public class Seat {
    
    private int seatNum;
    private char seatLetter;
    private String iD;
    public Passenger passenger;
    public boolean availabe = true;

    //seat constructor
    //called when creating a flight
    public Seat(int seatNum, char seatLetter) {
        this.seatNum = seatNum;
        this.seatLetter = seatLetter;
        this.iD = "" + this.seatNum + this.seatLetter;
    }

    //returns seat number in the form of a string
    public String getId() {
        return this.iD;
    }

    //seat availability is set to false 
    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
        this.availabe = false;
    }

    public int getSeatNum() {
        return this.seatNum;
    }

    public char getSeatLetter() {
        return this.seatLetter;
    }

}
