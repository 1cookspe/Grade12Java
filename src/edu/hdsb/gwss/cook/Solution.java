/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

/**
 *
 * @author 1cookspe
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String inputNum = input.nextLine();
        StringTokenizer st = new StringTokenizer(inputNum);
        int[] numbers = new int[n];
        int index = 0;
        int positives = 0;
        int negatives = 0;
        int zeroes = 0;
        double perPos = 0;
        double perNeg = 0;
        double perZer = 0;
        
        while (st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positives++;
            } else if (numbers[i] < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }
        
        perPos = (double) positives / (double) index;
        System.out.println(perPos);
        
        perNeg = (double) negatives / (double) index;
        System.out.println(perNeg);
        
        perZer = (double) zeroes / (double) index;
        System.out.println(perZer);
        
    }
}