/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

/**
 *
 * @author 1cookspe
 */
public class ClassRecord {
    private String teacherName;
    private String subjectName;
    private int classSize;
    protected final int RECORD_SIZE = 58;
    private final static int LENGTH = 15;

    public ClassRecord(String teacherName, String subjectName, int classSize) {
        setTeacherName(teacherName);
        this.subjectName = subjectName;
        this.classSize = classSize;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        StringBuilder builder = new StringBuilder();
        if (teacherName != null) {
            builder.append(teacherName.trim());
        } else {
            builder.append("TBD");
        }
        
        builder.setLength(LENGTH);
        this.teacherName = builder.toString();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        StringBuilder builder = new StringBuilder();
        if (subjectName != null) {
            builder.append(subjectName.trim());
        } else {
            builder.append("TBD");
        }
        
        builder.setLength(LENGTH);
        this.subjectName = builder.toString();
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }
    
    
}
