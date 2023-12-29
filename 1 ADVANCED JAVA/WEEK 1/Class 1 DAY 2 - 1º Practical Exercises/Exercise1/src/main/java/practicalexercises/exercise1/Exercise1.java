package practicalexercises.exercise1;

import practicalexercises.exercise1.exceptions.InvalidFlightException;
import practicalexercises.exercise1.services.FlightService;


public class Exercise1 {

    public static void main(String[] args) {
        FlightService flightSv = new FlightService();
        try {
            flightSv.createFlight();
        } catch (InvalidFlightException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
