/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 1cookspe
 */
public class Team {
    // CLASS CONSTANTS
    private static int lastID = 0;
    
    // Instance variables
    private String city; // SECONDARY KEY
    private String name; // SECONDARY KEY
    private ArrayList<Player> players;
    private int id; // PRIMARY KEY
    private String sport;
    private boolean active;
    private double age;
    
    // DEFAULT CONSTRUCTOR
    public Team() {
        this.players = new ArrayList<Player>();
        this.id = ++lastID;
    }
    
    // PRIMARY KEY CONSTRUCTOR
    public Team(int id) {  
        this();
        this.id = id;
    }
    
    // SECONDARY KEY CONSTRUCTOR
    public Team(String city, String name) {
        this();
        this.city = city;
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSport() {
        return sport;
    }

    public boolean isActive() {
        return active;
    }

    public double getAge() {
        return age;
    }
    
    public void add(Player player) {
        this.players.add(player);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
