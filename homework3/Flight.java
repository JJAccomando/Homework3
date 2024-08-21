package com.solvd.laba.homework3;

public final class Flight implements UniqueIDInterface {

    enum SeatType {
        FIRST_CLASS,
        BUSINESS_CLASS,
        ECONOMY_CLASS;
    }

    enum PlaneType {
        A380(16, 4, 90, 
        6, 410, 10, 518, "Airbus", "A380"),
        A320(14, 2, 20, 
        4, 112, 7, 146, "Airbus", "A320"),
        B737(4, 2, 12, 
        4, 102, 6, 118, "Boeing", "737");

        final int SEATS_IN_FIRST;
        final int SEATS_IN_BUSINESS;
        final int SEATS_IN_ECON;
        final int TOTAL_SEATS;
        final int NUM_COLUMNS_FIRST;
        final int NUM_COLUMNS_BUSINESS;
        final int NUM_COLUMNS_ECON;

        final String COMPANY;
        final String CLASSIFICATION;

        PlaneType(int seatsInFirst, int numColumnFirst, int seatsInBusiness, int numColumnBus, 
        int seatsInEcon, int numColumnEcon, int totalSeats, String company, String classification) {
            this.SEATS_IN_FIRST = seatsInFirst;
            this.SEATS_IN_BUSINESS = seatsInBusiness;
            this.SEATS_IN_ECON = seatsInEcon;
            this.TOTAL_SEATS = totalSeats;
            this.COMPANY = company;
            this.CLASSIFICATION = classification;
            this.NUM_COLUMNS_FIRST = numColumnFirst;
            this.NUM_COLUMNS_BUSINESS = numColumnBus;
            this.NUM_COLUMNS_ECON = numColumnEcon;
        }
    }

    private PlaneType planeType;
    public static int numFlights = 0;
    private String flightNum, departFrom, arriveTo;
    private AirplaneBase plane;
    private Passenger[] passengers;
    private Seat[] seats;  
    private int seatsAvailable, seatsInFirst, seatsInBusiness, seatsInEcon, numPassengers = 0, iD = 0;
    

    //Flight Class constructor 
    //assigns most fields with information dependent on each plane type
    //allocates memory for Passenger and Seat arrays
    //populates Seat array with seat objects
    public Flight(AirplaneBase myPlane, String departFrom, String arriveTo) {
        this.plane = myPlane;
        this.setPlaneType(myPlane);
        this.seatsAvailable = this.planeType.TOTAL_SEATS;
        this.seatsInFirst = this.planeType.SEATS_IN_FIRST;
        this.seatsInBusiness = this.planeType.SEATS_IN_BUSINESS;
        this.seatsInEcon = this.planeType.SEATS_IN_ECON;
        this.flightNum = myPlane.getClassification() + plane.getId();
        this.departFrom = departFrom;
        this.arriveTo = arriveTo;
        this.passengers = new Passenger[this.planeType.TOTAL_SEATS];
        this.seats = new Seat[this.planeType.TOTAL_SEATS];
        this.populateSeats();
        this.iD = ++numFlights;
    }

    //sets enum PlaneType depending on Object instance
    final private void setPlaneType(AirplaneBase plane) {
        if (plane instanceof AirbusA380) {
            this.planeType = PlaneType.A380; 
        } else if (plane instanceof AirbusA320) {
            this.planeType = PlaneType.A320;
        } else if (plane instanceof Boeing737) {
            this.planeType = PlaneType.B737;
        }
    } 

    //populates Seat array with seats based on rows and columns 
    //ex: 4 columns means seats will have letters A, B, C, or D
    //rows are seat numbers
    //so row 1 with 4 columns would have seats 1A, 1B, 1C, and 1D
    final private void populateSeats() {
        this.seats = new Seat[this.planeType.TOTAL_SEATS];
        int first = this.planeType.SEATS_IN_FIRST;
        int totalRowFirst = (first / this.planeType.NUM_COLUMNS_FIRST);
        int bus = this.planeType.SEATS_IN_BUSINESS;
        int totalRowBus = (bus / this.planeType.NUM_COLUMNS_BUSINESS);
        int econ = this.planeType.SEATS_IN_ECON;
        int totalRowEcon = (econ / this.planeType.NUM_COLUMNS_ECON);

        for (int row = 1; row <= totalRowFirst; row++) {
            char seatLetter = 'A';
            for (int i = 0; i < this.planeType.NUM_COLUMNS_FIRST; i++) {
                Seat seat = new Seat(row, seatLetter);
                for (int j = 0; j < this.seats.length; j++) {
                    if (this.seats[j] == null) {
                        this.seats[j] = seat;
                        break;
                    }
                }
                ++seatLetter; 
            }
        }

        for (int row = totalRowFirst + 1; row <= totalRowFirst + totalRowBus; row++) {
            char seatLetter = 'A';
            for (int i = 0; i < this.planeType.NUM_COLUMNS_BUSINESS; i++) {
                Seat seat = new Seat(row, seatLetter);
                for (int j = 0; j < this.seats.length; j++) {
                    if (this.seats[j] == null) {
                        this.seats[j] = seat;
                        break;
                    }
                }
                ++seatLetter; 
            }
        }

        for (int row = totalRowFirst + totalRowBus + 1; row <= totalRowFirst + totalRowBus + totalRowEcon; row++) {
            char seatLetter = 'A';
            for (int i = 0; i < this.planeType.NUM_COLUMNS_ECON; i++) {
                Seat seat = new Seat(row, seatLetter);
                for (int j = 0; j < this.seats.length; j++) {
                    if (this.seats[j] == null) {
                        this.seats[j] = seat;
                        break;
                    }
                }
                ++seatLetter; 
            }
        }
        
    }

    //returns available seats on flight
    public final int getSeatsAvailable() {
        return this.seatsAvailable;
    }

    //returns flight number which is unique for each new flight
    public final String getFlightNum() {
        return this.flightNum;
    }

    //returns flight ID#
    @Override
    public final int getId() {
        return this.iD;
    }
 
    //adds a passenger to a flight and assigns a seat number based on requested class
    //then the passenger is added to the array of passengers
    public final boolean bookSeat(Passenger person, SeatType seatType) {
            switch (seatType) {
                case FIRST_CLASS:
                    if (this.seatsInFirst != 0) {
                        --this.seatsInFirst;
                        --this.seatsAvailable;
                        ++this.numPassengers;
                        this.addPassenger(person);
                        for (int i = 0; i < this.planeType.SEATS_IN_FIRST; i++) {
                            if (this.seats[i].availabe) {
                                this.seats[i].addPassenger(person);
                                person.setSeatNum(this.seats[i]);
                                break;
                            }
                        }
                        return true;
                    }

                case BUSINESS_CLASS:
                    if (this.seatsInBusiness != 0) {
                        --this.seatsInBusiness;
                        --this.seatsAvailable;
                        ++this.numPassengers;
                        this.addPassenger(person);
                        for (int i = this.planeType.SEATS_IN_FIRST; i < this.planeType.SEATS_IN_FIRST + this.planeType.SEATS_IN_BUSINESS; i++) {
                            if (this.seats[i].availabe) {
                                this.seats[i].addPassenger(person);
                                person.setSeatNum(this.seats[i]);
                                break;
                            }
                        }
                        return true;
                    }

                case ECONOMY_CLASS:
                    if (this.seatsInEcon != 0) {
                        --this.seatsInEcon;
                        --this.seatsAvailable;
                        ++this.numPassengers;
                        this.addPassenger(person);
                        for (int i = this.planeType.SEATS_IN_FIRST + this.planeType.SEATS_IN_BUSINESS; 
                        i < this.planeType.SEATS_IN_FIRST + this.planeType.SEATS_IN_BUSINESS + this.planeType.SEATS_IN_ECON; i++) {
                            if (this.seats[i].availabe) {
                                this.seats[i].addPassenger(person);
                                person.setSeatNum(this.seats[i]);
                                break;
                            }
                        }
                        return true;
                    }
                
                default:
                    break;
            }
        return false;
    }

    //adds passenger to the flight by storing the passenger in the flights list of passengers array
    //this method is called inside bookSeat method which already checks for seat availability
    //therefore; if this method is called, a passenger will always be able to be added to array
    private final void addPassenger(Passenger person) {
        for (int i = 0; i < this.passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = person;
                break;
            }
        }
    }

    //returns a String of a Flight object as unique flight information
    @Override
    public final String toString() {
        String myFlightNum = "Flight#: " + this.flightNum;
        String departure = "Deaparting from: " + this.departFrom;
        String arrival = "Arriving to: " + this.arriveTo;
        String numberOfPassengers = "Number of passengers: " + this.numPassengers;
        String planeType = "Plane: " + this.planeType.COMPANY + " " + this.planeType.CLASSIFICATION;

        String myobj = myFlightNum + "\n" + departure + "\n" + arrival + "\n"
        + numberOfPassengers + "\n" + planeType;

        return myobj;
    }

    //compares 2 Flight objects by comparing their object Strings
    @Override
    public final boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Flight) {
            Flight cast = (Flight)obj;
            return this.toString() == cast.toString();
        }
        return false;
    }

    //Flight objects hash code is set to its id#
    @Override
    public final int hashCode() {
        return this.iD;
    }

}
