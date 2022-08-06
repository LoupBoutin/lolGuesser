package com.loldle.loldle;

public class Champion {
    private final String gender;
    private final String position;
    private final String name;

    public Champion(String name, String gender, String position){
        this.name = name;
        this.gender = gender;
        this.position = position;

    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
/*
    @Override
    public String toString() {
        return this.name;
    }*/
}
