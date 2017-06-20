/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

/**
 *
 * @author spencercook
 */
public class ClassRecord {

    public static final int NAME_LENGTH = 12;
    public static final int TEACHER_LENGTH = 15;
    public static final int RECORD_LENGTH = 58;
    private String teacherName;
    private String name;
    private int grade;

    public ClassRecord(String teacherName, String name, int grade) {

        setTeacherName(teacherName);
        setName(name);
        setGrade(grade);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        StringBuilder temp = new StringBuilder();
        if (teacherName != null) {
            temp.append(teacherName);
        }
        temp.setLength(TEACHER_LENGTH);
        this.teacherName = temp.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.setLength(NAME_LENGTH);
        this.name = sb.toString();
    }

    public int getGrade() {
        return grade;
        
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
