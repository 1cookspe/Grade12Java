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
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTS
        final double CONVERSION = 180 / Math.PI;
        Scanner input = new Scanner(System.in);

        // VARIABLES
        double lat1;
        double lon1;
        double lat2;
        double lon2;
        String place1 = "";
        String place2 = "";
        double distance;
        
        // LOGIC
        // Get data about locations
        
        System.out.print("Place 1: ");
        place1 = String.valueOf(input.nextLine());
        
        System.out.print("Latitude of " + place1 + ": ");
        lat1 = input.nextDouble();
        
        System.out.print("Longitude of " + place1 + ": ");
        lon1 = input.nextDouble();
        
        System.out.print("Place 2: ");
        place2 = input.next();
        
        System.out.print("Latitude of " + place2 + ": ");
        lat2 = input.nextDouble();
        
        System.out.print("Longitude of " + place2 + ": ");
        lon2 = input.nextDouble();
        
        // Convert degrees to radians
        lat1 = lat1 / CONVERSION;
        lon1 = lon1 / CONVERSION;
        lat2 = lat2 / CONVERSION;
        lon2 = lon2 / CONVERSION;
        
        // Calculate distance using Great Circle Distance Formula
        distance = 6378.8 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2-lon1));
        
        // Print out results
        System.out.println("The distance between " + place1 + " and " + place2+ " is approximately " + distance + " km.");
    }
    
}
