/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.util.Scanner;

/**
 *
 * @author 1cookspe
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// VARIABLES
        int year;
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        int k;
        int j;
        int m;
        int month;
        int p;
        int day;
        String monthName = "";
        Scanner input = new Scanner(System.in);
        
        // LOGIC
        // Get year
        System.out.print("Please enter the year: ");
        year = Integer.parseInt(input.nextLine());
        
        // Calculations
        a = year % 19;
        //System.out.println("a is " + a);
        
        b = year / 100;
        //System.out.println("b is " + b);
        c = year % 100;
        //System.out.println("c is " + c);
        
        d = b / 4;
        //System.out.println("d is " + d);
        e = b % 4;
        //System.out.println("e is " + e);
        
        f = (b + 8) / 25;
        //System.out.println("f is " + f);
        
        g = (b - f + 1) / 3;
        //System.out.println("g is " + g);
        
        h = (19 * a + b - d - g + 15) % 30;
        //System.out.println("h is " + h);
        
        i = c / 4;
        k = c % 4;
        
        j = (32 + 2*e + 2*i - h - k) % 7;
        
        m = (a + 11*h + 22*j) / 451;
        
        month = (h + j - 7*m + 114) / 31;
        p = (h + j - 7*m + 114) % 31;
        
        day = p + 1;
        
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                System.out.println("Error");
        }
        
        System.out.println("Easter is " + monthName + " " + day + " in " + year);
    }
    
    
}
