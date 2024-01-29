package com.practicalexercises.Exercise1;

import com.practicalexercises.Exercise1.models.Speaker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SpeakerController {
    
    List<Speaker> speakers = new ArrayList<>();

    @PostMapping("/speaker")
    public String createSpeaker(@RequestBody Speaker speaker){
        speakers.add(speaker);
        return "Speaker created";
    }

    @GetMapping("/speakers")
    public List<Speaker> getSpeakers() {
        return speakers;
    }


    @GetMapping("/speaker/{id}")
    public Speaker getSpeaker(@PathVariable int id) {
        return speakers.stream().filter(
                speaker -> speaker.getId() == id).findFirst().orElse(null);
    }




}
