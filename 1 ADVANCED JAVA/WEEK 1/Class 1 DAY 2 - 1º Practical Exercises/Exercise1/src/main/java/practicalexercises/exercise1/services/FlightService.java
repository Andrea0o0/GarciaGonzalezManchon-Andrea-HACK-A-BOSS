package practicalexercises.exercise1.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import practicalexercises.exercise1.exceptions.InvalidFlightException;
import practicalexercises.exercise1.models.Flight;

public class FlightService {
    Flight flight = new Flight();
    Map<String,Integer> availableSeats = new HashMap<String,Integer>();
    int maxSeats = 150;
    Scanner scanner = new Scanner(System.in);
    
    
    public Map<String,Integer> creatingMap(String month, Integer daysMonth) {
        Map<String, Integer> months = new HashMap<>();
        months.put(month,daysMonth);
        return months;
    }
    
    public LocalDate validationDate () {
        int maxYearDifference = 1;
        int year = 0, month = 0, day = 0;
        List<Map<String, Integer>> listMonths = new ArrayList<>();
            listMonths.add(creatingMap("January", 31));
            listMonths.add(creatingMap("February", 28));
            listMonths.add(creatingMap("March", 31));
            listMonths.add(creatingMap("April", 30));
            listMonths.add(creatingMap("May", 31));
            listMonths.add(creatingMap("June", 30));
            listMonths.add(creatingMap("July", 31));
            listMonths.add(creatingMap("August", 31));
            listMonths.add(creatingMap("September", 30));
            listMonths.add(creatingMap("October", 31));
            listMonths.add(creatingMap("November", 30));
            listMonths.add(creatingMap("December", 31));

        int nowYear = LocalDateTime.now().getYear();
        int nowMonth = LocalDateTime.now().getMonthValue();
        int nowDay = LocalDateTime.now().getDayOfMonth();
        int lapYear = 2024;
        
        System.out.println("Enter the year:");
        do {            
            while (!scanner.hasNextInt()) {
                System.out.println("Hi, please enter a valid year and now try with a number ;): ");
                scanner.next();
            }
            year = scanner.nextInt();
            if (year < nowYear || year > nowYear + maxYearDifference) {
                System.out.println("Invalid year. You can only book a flight from " +
                        nowYear + " to " + (nowYear + maxYearDifference));
                System.out.println("Please enter a valid range year: ");
            }
        } while (year < nowYear || year > nowYear + maxYearDifference);
        

        System.out.print("Enter the month: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Hi, please enter a valid month and now try with a number ;): ");
                scanner.next();
            }
            month = scanner.nextInt();
            // CASE 1 : Older year
            // EXAMPLE --- Year Input-> 2024 > 2023 <-Actual Year
            if (year > nowYear) {
                // Month MUST BE Higher than 0 and Lower than 12 months -- Example: NOT VALID 13 months or -2 months
                // Opposite condition to print invalid input message
                if (month <= 0 || month > 12) {
                    System.out.println("Invalid input. Please enter a valid month (1-12): ");
                }
            }  
            // CASE 2: same year, has to be equal or higher month to be valid date booking flight
            // Opposite condition to print invalid input message 
            else if (month < 1 || month > 12 || month < nowMonth) {
                System.out.println( month > 12 ? "You created new months with your " + month + " digit, but until they become a reality, please insert a valid month: " : 
                        month<1 ? "Negative month, I'm sorry for you, but enter a valid month please: ":"Invalid input. Please enter a valid month from month " + nowMonth + " or from " + new ArrayList<>(listMonths.get((nowMonth-1)).keySet()).get(0) + ":");
            }           
            
        } while 
                // True 1: Older Year - AND - Month between 1-12
                ((year > nowYear && (month <= 0 || month > 12))
                // True 2: Same Year - AND - Same Month or Older -> Actual month: 10, only valid 10,11,12 month
                || (year == nowYear && (month < nowMonth || month > 12)));

        
        System.out.print("Enter the day: ");
        //                                                        Convert to List to get the days (value) parameter with the index and no the String Key  
        int maxDays = ((year - lapYear) % 4 == 0 && month == 2) ?  29: (new ArrayList<>(listMonths.get((month-1)).values()).get(0));
        String monthString = new ArrayList<>(listMonths.get((month-1)).keySet()).get(0);
        String nowMonthString = new ArrayList<>(listMonths.get((nowMonth-1)).keySet()).get(0);
        do {    
            while (!scanner.hasNextInt()) {
                System.out.println("Hi, please enter a valid day and now try with a number ;): ");
                scanner.next();
            }
            day = scanner.nextInt();
            // CASE same year AND month, DAY: Has to be higher or same day
            if(year == nowYear && month == nowMonth && day < nowDay && day > 0 ){
                System.out.println("You have to enter a day higher than " + day + " because it's a passed date, and you can't still book a flight for the past");
                System.out.println("Your date Flight : " + "DAY-> " + day + " MONTH-> " + month + "/" + monthString + " YEAR-> " + year);
                System.out.println("Real Time Date   : " + "DAY-> " + nowDay + " MONTH-> " + nowMonth + "/" + nowMonthString  + " YEAR-> " + nowYear);  
                System.out.println("Please enter a valid day: ");
            }
            if(day < 1 || day > maxDays ){
                // Convert to List to get the MONTH (key) parameter with the index and no the String Key 
                System.out.println("Oops, there's " + maxDays + " days on " + monthString  );
                System.out.println(day < 1 ? "It seems you don't know the negative days on month only exists in our mood": "Keep dreaming, there are't that many days in the month");
                System.out.println("Could you enter new day inside parameters: ");
            }            
        } while(
                // TRUE 1: Same year, same month, same or older day 
                ((year == nowYear && month == nowMonth && day < nowDay) ||
                // TRUE 2: Same/Different year, different month  
                (month != nowMonth && year >= nowYear)) ||
                // COMMON CONDITION on TRUE1 & TRUE2 -> MUST BE: More than 0 and less than the max day of the input Month
                (day < 1 || day > maxDays));
        
        return LocalDate.of(year, month, day);
        
    }


    public Flight createFlight() throws InvalidFlightException {
        
        System.out.println("Enter your name: ");
        flight.setUserName(scanner.next());
        
        System.out.println("Enter destination: ");
        flight.setDestination(scanner.next());
        
        System.out.println("Enter your travel date: ");
        flight.setTravelDate(validationDate());
        
        
        System.out.println("Enter number of seats you want to book: ");
        flight.setSeats(scanner.nextInt());
        
        if (flight.getUserName() == null || flight.getUserName().trim().isEmpty()) {
            throw new InvalidFlightException("User name cannot be null or empty");
        }

        if (flight.getDestination() == null || flight.getDestination().trim().isEmpty()) {
            throw new InvalidFlightException("Destination cannot be null or empty");
        }

        if (flight.getTravelDate() == null) {
            throw new InvalidFlightException("Travel date cannot be null");
        }

        if (flight.getSeats() == null) {
            throw new InvalidFlightException("Number of seats cannot be null");
        }

        String idFlightDate = flight.getDestination().toLowerCase()+flight.getTravelDate();
        if(availableSeats.containsKey(idFlightDate)){
            if(availableSeats.get(idFlightDate) - flight.getSeats() >=1){
                throw new InvalidFlightException("Sorry the number of seats choice exceeds the available seats, for this flight there's only " + (availableSeats.get(idFlightDate) - flight.getSeats()) + "seats available");
            } else if (availableSeats.get(idFlightDate) - flight.getSeats() <=0) {
                throw new InvalidFlightException("Sorry there's no seats available for this destination and date");
            }            
        availableSeats.put(idFlightDate, (availableSeats.get(idFlightDate) - flight.getSeats()));
            System.out.println(availableSeats.get(idFlightDate));
        } else if(flight.getSeats()> maxSeats ){
            throw new InvalidFlightException("Exceed the maximum of seats available to buy on a flight");
        } else {
            availableSeats.put(idFlightDate, (maxSeats - flight.getSeats()));
        }
        
        System.out.println("Would you like to reserve another flight? YES/NO");
        boolean answer = true;
        do {            
           while (!scanner.hasNext()) {
            System.out.println("Invalid answer YES or NO:");
            scanner.next();
           } 
           answer = scanner.next().equalsIgnoreCase("YES") || scanner.next().equalsIgnoreCase("NO");
        } while (!answer);
        
        if(answer) {
            createFlight();
        } else { 
            scanner.close();
        }
        
        return flight;
    
    }
    
}
