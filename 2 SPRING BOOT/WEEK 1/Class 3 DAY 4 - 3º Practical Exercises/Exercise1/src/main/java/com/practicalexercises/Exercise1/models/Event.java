package com.practicalexercises.Exercise1.models;

import java.time.LocalDate;
import java.util.Random;

public class Event {

    Random r = new Random();
    private int id = r.nextInt(1000000);
    private String title;
    private String description;
    private LocalDate dateEvent;
    private String hourEvent;
    private String place;
    private Speaker speaker;

    public Event(String title, String description, LocalDate dateEvent, String hourEvent, String place, Speaker speaker) {
        this.title = title;
        this.description = description;
        this.dateEvent = dateEvent;
        this.hourEvent = hourEvent;
        this.place = place;
        this.speaker = speaker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getHourEvent() {
        return hourEvent;
    }

    public void setHourEvent(String hourEvent) {
        this.hourEvent = hourEvent;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", dateEvent=" + dateEvent + ", hourEvent='" + hourEvent + '\'' + ", place='" + place + '\'' + ", speaker=" + speaker + '}';
    }
}
