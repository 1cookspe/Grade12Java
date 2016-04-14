/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

/**
 *
 * @author 1cookspe
 */
public class SportsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team blueJays = new Team("Toronto", "Blue Jays");
        Player joshDonaldson = new Player("Josh", "Donaldson");
        joshDonaldson.setId(4323);
        joshDonaldson.setAge(30.4);
        joshDonaldson.setNationality("American");
        joshDonaldson.setTeam(blueJays);
        
        blueJays.add(joshDonaldson);
        
    }
    
}
