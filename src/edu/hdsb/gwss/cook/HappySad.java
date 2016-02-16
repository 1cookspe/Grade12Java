/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 1cookspe
 */
public class HappySad {

   public static final String H = ":-)";
    public static final String S = ":-(";

    public static void main( String[] args ) throws Exception {

        Scanner input = new Scanner( new File( "HappySad.txt" ) );

        while( input.hasNext() ) {
            System.out.println( count( input.nextLine() ) );
        }

    }

    public static String count( String s ) {
        String mood = "";
        String copyS = s;

        // HAPPY
        int happyCount = 0;
        int index = s.indexOf( H );
        if( index < 0 ) {
            mood = "none";
        } else {
            do {
                happyCount++;
                s = s.substring( index + 3 );
                index = s.indexOf( H );
            } while( index >= 0 );
            //System.out.println( happyCount );
        }

        // SAD
        s = copyS;
        int sadCount = 0;
        index = s.indexOf( S );
        if( index < 0 ) {
            mood = "none";
        } else {
            do {
                sadCount++;
                s = s.substring( index + 3 );
                index = s.indexOf( S );
            } while( index >= 0 );
            //System.out.println( sadCount );
        }

        if( happyCount == 0 && sadCount == 0 ) {
            mood = "none";
        } else if( happyCount == sadCount ) {
            mood = "unknown";
        } else if( happyCount > sadCount ) {
            mood = "happy";
        } else {
            mood = "sad";
        }

        return mood;
    }
}
