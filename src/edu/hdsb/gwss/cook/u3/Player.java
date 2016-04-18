/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

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
        this.firstName = firstName;
        this.lastName = lastName;
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
            System.out.println("Yes");
        } else {
            this.lastName = lastName.substring(0, 1);
            System.out.println("No");
        }
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

}
