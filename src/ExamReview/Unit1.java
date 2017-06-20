/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author spencercook
 */
public class Unit1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        findWords("The cow jumped over the moon");
        panagram("The quick brown fox jumps over the lazy dog");
        System.out.println(euclidAlgorithm(54, 90));
        System.out.println(20 % 8);
        System.out.println("Yeah " + recur(7, 6));
        System.out.println(sumOdd(5));
        System.out.println("Triangle: " + triangle(10));
        System.out.println("Hi: " + countHi("xhixhix"));
        
        QuizObject qo2 = new QuizObject( 99 );
        System.out.println(qo2.getI());
        
        QuizObject qo3 = new QuizObject( 3.14 );
        System.out.println(qo3.getD());
        
        QuizObject qo4 = new QuizObject( 11.0, 22, "Object 4" );
        System.out.println(qo4.getD());
        System.out.println(qo4.getI());
    }

    public static void findWords(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        int numWords = 0;
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            numWords++;
        }
        System.out.println(numWords);
    }

    public static void panagram(String sentence) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        boolean isPanagram = true;

        for (int i = 0; i < alphabet.length; i++) {
            if (!sentence.contains("" + alphabet[i])) {
                isPanagram = false;
            }
        }

        System.out.println("" + isPanagram);
    }

    public static void matrix() {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

    }

    public static int euclidAlgorithm(int m, int n) {
        if (m == n) {
            return m;
        } else if (m > n) {
            return euclidAlgorithm(n, m - n);
        } else if (n > m) {
            return euclidAlgorithm(n, m);
        }
        return 0;
    }

    public static int recur(int x, int y) {
        if (x <= 2) {
            return (int) (Math.pow(x, 2) + y + 1);
        } else if (x % 2 == 0) {
            return recur(y - 3, x + 2) + 3;
        } else {
            return recur(x - 3, y + 1) - 4;
        }
    }

    public static int sumOdd(int n) {
        if (n == 1) {
            return 1;
        } else if (n % 2 == 1) {
            return n + sumOdd(n - 1);
        } else if (n % 2 == 0) {
            return sumOdd(n - 1);
        }
        return 0;

    }

    public static int triangle(int row) {
        if (row == 1) {
            return 1;
        } else {
            return row + triangle(row - 1);
        }
    }

    public static int countHi(String str) {
        if  (str.length() < 2) {
            return 0;
        } else if (str.substring(0, 2).equals("hi")) {
            return 1 + countHi(str.substring(2));
        } else {
            return countHi(str.substring(2));
        }
    }
    
    static void hey() {
        
    }
}
