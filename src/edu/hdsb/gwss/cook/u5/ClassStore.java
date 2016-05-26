/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author spencercook
 */
public class ClassStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Creating 4 Class Records");
        ClassRecord c1 = new ClassRecord("Mr. Sanderson", "Chemistry", 31);
        ClassRecord c2 = new ClassRecord("Ms. Smallbone", "Biology", 32);
        ClassRecord c3 = new ClassRecord("Mr. Tennant", "Physics", 34);
        ClassRecord c4 = new ClassRecord("Mr. Muir", "Computer Science", 20);
        System.out.println("*********************");

        RandomAccessFile recordFile = new RandomAccessFile("class_info.txt", "rw");

    }

}
