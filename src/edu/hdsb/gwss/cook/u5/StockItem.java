/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

import java.io.*;
/**
 *
 * @author spencercook
 */
public class StockItem implements Serializable {
    private String itemName;
    private double cost;

    public StockItem(String itemName, double cost) {
        this.itemName = itemName;
        this.cost = cost;
    }
    
    public String toString() {
        String data;
        data = itemName + " cost: " + cost;
        return data;
    }
}
