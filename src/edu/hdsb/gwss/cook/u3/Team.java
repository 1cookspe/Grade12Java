/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

import java.text.DecimalFormat;
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
        setCity(city);
        this.name = name;
    }

    public void setCity(String city) {
        if (city.length() > 1 && city.length() < 10) {
            this.city = city;
            System.out.println(this.city);
        } else {
            this.city = city.substring(0, 3);
        }
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
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            DecimalFormat f = new DecimalFormat("##.00");
            this.age = Double.parseDouble(f.format(Math.random() * 120 + 10));
        }
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void add(Player player) {
        if (player.isValid() && !this.players.contains(player)) {
            this.players.add(player);
            System.out.println(player.getFirstName() + " " + player.getLastName() + " successfully added to the " + this.name);
        } else {
            System.out.println(player.getFirstName() + " " + player.getLastName() + " cannot be added because they are already on the roster");
        }

//        for (int i = 0; i < players.size(); i++) {
//            System.out.println("Yo " + players.get(i) + " babab");
//        }
    }

    public void remove(Player player) {
        if (player.isValid() && this.players.contains(player)) {
            this.players.remove(player);
            System.out.println(player.getFirstName() + " " + player.getLastName() + " successfully removed from the " + this.name);
        } else {
            System.out.println(player.getFirstName() + " " + player.getLastName() + " cannot be removed because they are not on the roster");
        }
    }

    public Player get(Player player) { // CHANGE TO NAME OR PLAYER ID
        if (player.isValid() && this.players.contains(player)) {
            int index = this.players.indexOf(player);
            return this.players.get(index);
        } else {
            System.out.println(this.name + " does not contain " + player.getFirstName() + " " + player.getLastName());
        }
        return null;
    }
    
    public boolean isValid() {
        boolean isValid = false;
        if (this.id != 0 && this.city != null && this.name != null && this.sport != null) {
            isValid = true;
        }
        return isValid;
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

    @Override
    public String toString() {
        String output = "";
        if (isValid()) {
        output = "The " + this.city + " " + this.name + " are an active " + this.sport + " team, and they are " + this.age + " years old.";
        } else {
           output = "This team is not valid."; 
        }
        return output;
    }

}
