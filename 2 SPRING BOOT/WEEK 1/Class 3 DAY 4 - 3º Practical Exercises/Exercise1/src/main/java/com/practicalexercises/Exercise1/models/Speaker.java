package com.practicalexercises.Exercise1.models;

import java.util.Random;

public class Speaker {
    Random r = new Random();
    private int id = r.nextInt(1000000);
    private String nameSpeaker;
    private String surnameSpeaker;
    private String profession;

    public Speaker(String nameSpeaker, String surnameSpeaker, String profession) {
        this.nameSpeaker = nameSpeaker;
        this.surnameSpeaker = surnameSpeaker;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSpeaker() {
        return nameSpeaker;
    }

    public void setNameSpeaker(String nameSpeaker) {
        this.nameSpeaker = nameSpeaker;
    }

    public String getSurnameSpeaker() {
        return surnameSpeaker;
    }

    public void setSurnameSpeaker(String surnameSpeaker) {
        this.surnameSpeaker = surnameSpeaker;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Speaker{" + "id=" + id + ", nameSpeaker='" + nameSpeaker + '\'' + ", surnameSpeaker='" + surnameSpeaker + '\'' + ", profession='" + profession + '\'' + '}';
    }
}
