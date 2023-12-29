package practicalexercises.exercise1.models;

import java.time.LocalDate;


public class Flight {
    private String userName;
    private String destination;
    private LocalDate travelDate;
    private Integer seats;

    public Flight() {
    }

    public Flight(String userName, String destination, LocalDate travelDate, Integer seats) {
        this.userName = userName;
        this.destination = destination;
        this.travelDate = travelDate;
        this.seats = seats;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Flight{" + "userName=" + userName + ", destination=" + destination + ", travelDate=" + travelDate + ", seats=" + seats + '}';
    }
    
    
}
