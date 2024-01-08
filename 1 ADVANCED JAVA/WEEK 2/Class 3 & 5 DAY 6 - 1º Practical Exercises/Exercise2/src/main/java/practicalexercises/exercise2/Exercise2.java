package practicalexercises.exercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import practicalexercises.exercise2.models.Event;


public class Exercise2 {

    public static void main(String[] args) {
        Random random = new Random();
        
        List<Event> events = new ArrayList<Event>();
        
        String[] categoryType = {"Meeting","Conference","Workshop"};
        for (int i = 0; i < random.nextInt(100); i++) {
            events.add(new Event(
                    "Event "+ i,
                    LocalDate.of(random.nextInt(24)+2000, random.nextInt(12)+1, random.nextInt(27)+1),
                    categoryType[random.nextInt(categoryType.length)]));
        }
        for (Event event : events) {
            System.out.println(event);
        }
        
        // SPECIFIC DATE
//        LocalDate specDate = LocalDate.now();
        // TESTING IF IT WORKS
        LocalDate specDate = events.get(random.nextInt(events.size())).getDate();
        
        List<Event> eventsDate = events.stream()
                .filter(event -> {
                    LocalDate date = event.getDate(); 
                    return (date.getYear() == specDate.getYear() && date.getMonth() == specDate.getMonth() && date.getDayOfMonth() == specDate.getDayOfMonth());
                            })
                .collect(Collectors.toList());
        Optional<Event> nullPossible = Optional.empty();
        System.out.println("With the date " + specDate + " There's only " + eventsDate.size() + " events: \n" + eventsDate);
        
        Map<String, Long> howManyEventByCategory = events.stream()
                .collect(Collectors.groupingBy(Event::getCategory,
                        Collectors.counting()
                ));
        System.out.println(howManyEventByCategory);
        
        LocalDate now = LocalDate.now();
        events.add(new Event("EventDATE", now, "test"));
        List<Event> closeEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());
        
        Optional<Event> nullPossibleEvent = Optional.empty();
    }
}
