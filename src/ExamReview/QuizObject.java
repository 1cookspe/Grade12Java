/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

/**
 *
 * @author spencercook
 */
public class QuizObject {
    static int x;
    
    int i;
    double d;
    String s;

    public QuizObject() {
        x++;
        this.s = "Quiz Object";
    }

    public QuizObject( int i ) {
        this();
        i++;
    }
    
    public QuizObject( double d ) {
        this();
        this.d = d;
    }
    
    public QuizObject( double d, int i ) {
        this( i );
        i = 2;
    }
    
    public QuizObject( double d, int i, String s ) {
        this( d, i );
        this.d = d;
        this.i = i;
    }

    public static int getX() {
        return x;
    }

    public int getI() {
        return i;
    }

    public double getD() {
        return d;
    }

    public String getS() {
        return s;
    }
}
