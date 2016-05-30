/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author spencercook
 */
public class ClassStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Creating 4 Class Records");
        ClassRecord c1 = new ClassRecord("Mr. Sanderson", "Chemistry", 31);
        ClassRecord c2 = new ClassRecord("Ms. Smallbone", "Biology", 32);
        ClassRecord c3 = new ClassRecord("Mr. Tennant", "Physics", 34);
        ClassRecord c4 = new ClassRecord("Mr. Muir", "Computer Science", 20);
        System.out.println("*********************");

        RandomAccessFile recordFile = new RandomAccessFile("class_info.dat", "rw");

        // WRITE DATA
        recordFile.seek(0);
        recordFile.writeChars(c1.getTeacherName());
        recordFile.writeChars(c1.getSubjectName());
        recordFile.writeInt(c1.getClassSize());
//        recordFile.close();

        // CHANGE DATA
        // --- Change teacher's name
        int recordNumber = 1;
        System.out.println("Enter [new name] or [k]eep current name: ");
        String instructor = input.nextLine();

        if (!"k".equals(instructor)) {
            c1.setTeacherName(instructor);
        }

        // Change Subject
        System.out.println("Enter [new subject] or [k]eep current subject name: ");
        String subjectName = input.nextLine();

        if (!"k".equals(subjectName)) {
            c1.setTeacherName(subjectName);
        }

        // Change Class Size
        System.out.println("Enter [new class size] or [k]eep current current size: ");
        String classSize = input.nextLine();

        if (!"k".equals(classSize)) {
            c1.setClassSize(Integer.parseInt(classSize));
        }
        
        int position = c1.RECORD_SIZE * (recordNumber - 1);
        recordFile.seek(position);
        recordFile.writeChars(c1.getTeacherName());
        recordFile.writeChars(c1.getSubjectName());
        recordFile.writeInt(c1.getClassSize());
        recordFile.close();

    }

}
