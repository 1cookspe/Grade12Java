/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

/**
 *
 * @author 1cookspe
 */
public class Teams {
    // Class variables
    private String city; // PRIMARY KEY
    private String teamName;
    private int ranking;
    private String captain;
    private boolean isInPlayoffs;
    private int numberOfPlayers;
    private String[] players;
    private double age;
    private League league; // Only 1 league
    private String coach; 
    private int orderOfIntroduction;
    
    public Teams() {
    }
    
    public Teams(int orderOfIntroduction) { // PRIMARY KEY CONSTRUCTOR
        this.orderOfIntroduction = orderOfIntroduction;
    }
    
    public Teams(int numberOfPlayers, String teamName) {
        this.teamName = teamName;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public void setIsInPlayoffs(boolean isInPlayoffs) {
        this.isInPlayoffs = isInPlayoffs;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
    
    

    
    
    
    
}
