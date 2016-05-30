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
public class ReadingFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long position, recordNumber;
        Scanner input = new Scanner(System.in);

        ClassRecord cRecord = new ClassRecord("", "", 0);
        RandomAccessFile recordFile = new RandomAccessFile("class_info.dat", "rw");

        // CALCULATE AMOUNT OF RECORDS
        long numRecords = recordFile.length() / cRecord.RECORD_SIZE;
        System.out.println("\nThere are " + numRecords + " records currently in the file.");

        // ASK FOR RECORD
        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");
        recordNumber = input.nextLong();
        while (recordNumber != 0) {
            
            position = cRecord.RECORD_SIZE * (recordNumber - 1);
            recordFile.seek(position);

            // WRITE TO CHAR ARRAY
            char[] teacherName = new char[ClassRecord.LENGTH];
            for (int i = 0; i < ClassRecord.LENGTH; i++) {
                teacherName[i] = recordFile.readChar();
            }
            cRecord.setTeacherName(new String(teacherName));

            //WRITE SUBJECT
            char[] subjectName = new char[ClassRecord.LENGTH];
            for (int i = 0; i < ClassRecord.LENGTH; i++) {
                subjectName[i] = recordFile.readChar();
            }
            cRecord.setSubjectName(new String(subjectName));

            cRecord.setClassSize(recordFile.readInt());

            System.out.println("Record number " + recordNumber + ": ");
            System.out.println(cRecord.toString());
        } 
    }

}
