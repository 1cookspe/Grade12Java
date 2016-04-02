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

        if (row == col || col == 0) {
            number = 1;
        } else if (col == 1 || row - col == 1) {
            number = row;
        } else {
            number = term(row - 1, col) + term(row - 1, col - 1);
        }

        return number;
    }

    public static void row(int row) {
        int numbersOnLine = 0;
        int column = 0;

        if (row > 1) {
            row(row - 1);

        }

        for (int col = 0; col < row; col++) {
            System.out.print(term(row - 1, col) + " ");

            //triangle += term(row - 1, col) + " ";
            numbersOnLine++;
            if (numbersOnLine == row) {
                System.out.print("\n");
                //triangle += "\n";
            }
        }

       // System.out.print(triangle);
    }

}
