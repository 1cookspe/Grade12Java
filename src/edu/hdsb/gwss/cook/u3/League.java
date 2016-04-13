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
public class League {
    // Class variables
    private String name;
    private int numberOfTeams;
    private String sport;
    private double age;
    private String recentChampion;
    private String[] countries;
    private boolean stillActive;
    private Teams[] team;
    private String commissioner; // PRIMARY KEY
    
    public League() {
    }
    
    public League(String commissioner) { // PRIMARY KEY CONSTRUCTOR
        this.commissioner = commissioner;
    }
    
    public League(String sport, String name) { // SECONDARY KEYS
        this.name = name;
        this.sport = sport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setRecentChampion(String recentChampion) {
        this.recentChampion = recentChampion;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void setStillActive(boolean stillActive) {
        this.stillActive = stillActive;
    }

    public void setTeam(Teams[] team) {
        this.team = team;
    }

    public void setCommissioner(String commissioner) {
        this.commissioner = commissioner;
    }
    
    

    public void add(Teams t) {
        // Team can't be null
        // Team must be valid
        // t.isValid()
        // - name, players, etc
        // No duplicates
        // .equals() (+ contains)
        
        
    }
    
    public Teams get( /* pass primary/secondary key */ ) {
        Teams t = new Teams();
        return t;
    }
}
