/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

import java.io.Serializable;

/**
 *
 * @author spencercook
 */
public class Clothes implements Serializable {
    private String name;
    private int size;

    public Clothes(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    
}
