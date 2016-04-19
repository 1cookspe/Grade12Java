/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author 1cookspe
 */
public class Player {

    // Class variables
    private static int lastID = 0;

    // Instance variables
    private String firstName; // SECONDARY KEY
    private String lastName; // SECONDARY KEY
    private double age;
    private boolean active;
    private Team team;
    private int id; // PRIMARY KEY
    private String nationality;
    private String position;

    // DEFAULT CONSTRUCTOR
    public Player() {
        this.id = ++lastID;
        this.team = new Team();
    }

    // PRIMARY CONSTRUCTOR
    public Player(int id) {
        this();
        this.id = id;
    }

    // SECONDARY CONSTRUCTOR
    public Player(String firstName, String lastName) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 1 && firstName.length() < 10) {
            this.firstName = firstName;
        } else {
            this.firstName = firstName.substring(0, 1);
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 1 && lastName.length() < 10) {
            this.lastName = lastName;
        } else {
            this.lastName = lastName.substring(0, 1);
        }
    }

    public void setAge(double age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            DecimalFormat f = new DecimalFormat("##.00");
            this.age = Double.parseDouble(f.format(Math.random() * 120 + 10));
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTeam(Team team) {
        if (team != null) {
            this.team = team;
        } else {
            this.team = new Team();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNationality(String nationality) {
        if (nationality.length() > 1 && nationality.length() < 10) {
            this.nationality = nationality;
        } else {
            this.nationality = nationality.substring(0, 3);
        }
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public Team getTeam() {
        return team;
    }

    public int getId() {
        return id;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public boolean isValid() {
        boolean isValid = false;
        if (this.id > 0 && this.firstName != null && this.lastName != null) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public boolean equals(Object obj) {
        boolean doesEqual = false;
        if (obj == null) {
            doesEqual = false;
        }
        if (getClass() != obj.getClass()) {
            doesEqual = false;
        }
        final Player other = (Player) obj;
        if (Objects.equals(this.firstName, other.firstName)) {
            doesEqual = true;
        }
        if (Objects.equals(this.lastName, other.lastName)) {
            doesEqual = true;
        }
        if (this.id == other.id) {
            doesEqual = true;
        }
        return doesEqual;
    }

    @Override
    public String toString() {
        String output = "";
        if (isValid()) {
            String isActive = "";
            if (this.active) {
                isActive = " active ";
            } else {
                isActive = " retired ";
            }

            output = this.firstName + " " + this.lastName + " is a" + isActive + this.nationality + " " + this.team.getSport() + " player" + " who plays " + this.position + " for the " + this.team.getCity() + " " + this.team.getName();
        } else {
            System.out.println("This player is not valid");
        }
        return output;
    }

}
