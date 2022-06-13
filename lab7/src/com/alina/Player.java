package com.alina;

import java.time.LocalDate;

public class Player {
    private  String secondName;
    private LocalDate birth;
    private String club;
    private Roles role;
    private int numberOfGames;
    private String cityOfBirth;


    public Player(String secondName, LocalDate birth, String club, Roles role, int numberOfGames, String cityOfBirth) {
        this.secondName = secondName;
        this.birth = birth;
        this.club = club;
        this.role = role;
        this.numberOfGames = numberOfGames;
        this.cityOfBirth = cityOfBirth;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if(secondName == null || secondName == ""){
            throw new IllegalArgumentException();
        }
        this.secondName = secondName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        if(birth.getYear()<2010){
            throw new IllegalArgumentException();
        }
        this.birth = birth;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        if(club == null || club == ""){
            throw new IllegalArgumentException();
        }
        this.club = club;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        if(role == null){
            throw new NullPointerException();
        }
        this.role = role;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        if(numberOfGames<1){
            throw new IllegalArgumentException();
        }
        this.numberOfGames = numberOfGames;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        if(cityOfBirth == null || cityOfBirth == ""){
            throw new IllegalArgumentException();
        }
        this.cityOfBirth = cityOfBirth;
    }

    @Override
    public String toString() {
        return "Player{" +
                "secondName='" + secondName + '\'' +
                ", birth=" + birth +
                ", club='" + club + '\'' +
                ", role=" + role +
                ", numberOfGames=" + numberOfGames +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                '}';
    }
}
