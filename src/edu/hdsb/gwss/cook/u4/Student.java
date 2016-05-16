/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u4;

/**
 *
 * @author 1cookspe
 */
public class Student {
  
    private long studentID;
    private String name;
    private String lastName;

    public Student( long studentID, String name, String lastName ) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
    }
    
    // TO DO
    public long getKey() {
        return -1;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID( long studentID ) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", lastName=" + lastName + '}';
    }

    
    
}
