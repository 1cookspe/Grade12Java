/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author spencercook
 */
public class ClassClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ClassRecord cr = new ClassRecord("Bertoe", "Mathematics", 12);
        RandomAccessFile raf = new RandomAccessFile("exam.dat", "rw");
        raf.seek(0);
        raf.writeChars(cr.getTeacherName());
        raf.writeChars(cr.getName());
        raf.writeInt(cr.getGrade());
        
        int recordNumber = 0;
        int position = (recordNumber - 1) * ClassRecord.RECORD_LENGTH;
        
        raf.seek(0);
        char[] teacher = new char[ClassRecord.TEACHER_LENGTH];
        for (int i = 0; i < teacher.length; i++) {
            teacher[i] = raf.readChar();
        }
        cr.setTeacherName(new String(teacher));
        System.out.println(cr.getTeacherName());
        
    }
    
}
