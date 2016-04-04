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
public class Student {
    // CLASS CONSTANT
    private static String SCHOOL_NAME = "Garth Webb";
    
    // CLASS VARIABLE
    private static int lastIDUsed = 0;

    // OBJECT VARIABLES
    private String firstName;
    private int grade;
    private String dob;
    private String lastName;
    private int oen;

    public int getOen() {
        return oen;
    }

    public void setOen(int oen) {
        this.oen = oen;
    }

    public Student(String firstName, int grade, String dob, String lastName, int oen) {
        this.firstName = firstName;
        this.grade = grade;
        this.dob = dob;
        this.lastName = lastName;
        this.oen = oen;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student() {
        //lastIDUsed++;
        this.setOen(++lastIDUsed);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (this.grade != other.grade) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        
        return true;
    }


    public void setGrade(int grade) {
        if (grade < 13 && grade > 8) {
            this.grade = grade;
        } else {
            this.grade = 9;
        }
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", grade=" + grade + ", dob=" + dob + ", lastName=" + lastName + ", oen=" + oen +'}';
    }

}
