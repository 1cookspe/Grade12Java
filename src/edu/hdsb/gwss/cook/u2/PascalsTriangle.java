/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u2;

/**
 *
 * @author 1cookspe
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(term(4, 2));
        row(16);
    }

    public static int term(int row, int col) {
        int number = 1;

        if (row == col || col == 0) { // If number is on outside of triangle
            number = 1;
        } else if (col == 1 || row - col == 1) { // If number is second number in column or second last in column
            number = row;
        } else { // Any other number in triangle
            // Number is equal to the sum of the number in the last row and same column and the last row and last column
            number = term(row - 1, col) + term(row - 1, col - 1);
        }

        return number;
    }

    public static void row(int row) {
        int numbersOnLine = 0;
        int column = 0;

        // If row is greater than 1, call row - 1, because of the row numbering (starting at 0)
        if (row > 1) {
            row(row - 1);

        }

        for (int col = 0; col < row; col++) {
            // Loop through column in row
            System.out.print(term(row - 1, col) + " ");

            //Add new line if all columns have been filled in the rows
            numbersOnLine++;
            if (numbersOnLine == row) {
                System.out.print("\n");
            }
        }

    }

}
