package com.practicalexercises.Exercise1;

import com.practicalexercises.Exercise1.models.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EventController {
    
    List<Event> events = new ArrayList<>();

    @PostMapping("/event")
    public String createEvent(@RequestBody Event event){
        System.out.println("in " + event);
        events.add(event);
        return "Event created";
    }

    @PutMapping("/editEvent/{id}")
    public String editEvent(@RequestBody Event eventModified,
                           @PathVariable int id) {
        String message = "";
        Event event = getEvent(id);
        event.setHourEvent(eventModified.getHourEvent());
        event.setDateEvent(eventModified.getDateEvent());
        event.setDescription(eventModified.getDescription());
        event.setPlace(eventModified.getPlace());
        event.setTitle(eventModified.getTitle());
        event.setSpeaker(event.getSpeaker());
        System.out.println(event + " " + eventModified);
        for (int i=0;i<events.size();i++){
            if(events.get(i).getId() == id ){
                events.set(i,event);
                message = "Event Modified";
            }
        }
        return message;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return events;
    }


    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable int id) {
        return events.stream().filter(
                event -> event.getId() == id).findFirst().orElse(null);
    }

    @DeleteMapping("/eventDelete/{id}")
    public String deleteEvent(@PathVariable int id) {
        String message = "Not found any Event with this index";
        for (int i=0;i<events.size();i++){
            if(events.get(i).getId() == id ){
                events.remove(i);
                message = "deleted Event";
            }
        }
        return message;
    }


}
