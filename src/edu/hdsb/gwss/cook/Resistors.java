/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1cookspe
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTS
        final String[] COLOURS = {"BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET", "GREY", "WHITE"};

        // VARIABLES
        String colourCode = "";
        Scanner input = new Scanner(System.in);
        StringTokenizer st;
        String[] codes = new String[3];
        int index = 0;
        String value = "";
        int power = 0;
        int finalValue;

        // INPUT
        System.out.print("Enter your colour code, each colour seperated by hyphens: ");
        colourCode = input.nextLine().toUpperCase();
        st = new StringTokenizer(colourCode, "-");

        // BREAK COLOUR CODE IN SEPERATE COLOURS
        while (st.hasMoreTokens()) {
            codes[index] = st.nextToken();
            index++;
        }

        // LOOP THROUGH CODE ARRAY TO FIND THE COLOR VALUE FROM THE COLOURS ARRAY
        for (int i = 0; i < codes.length; i++) {
            for (int j = 0; j < COLOURS.length; j++) {
                if (codes[i].equals(COLOURS[j])) {
                    if (i < 2) {
                        value += "" + j;
                    } else {
                        power = (int) Math.pow(10, j);
                    }
                    
                }
            }
        }
        
        
        finalValue = Integer.parseInt(value) * power;
        System.out.println("The resistor is " + finalValue + "Ω");
    }

}
