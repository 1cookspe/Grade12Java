/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

import java.util.ArrayList;

/**
 *
 * @author 1cookspe
 */
public class SportsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Team blueJays = new Team("Toronto", "Blue Jays");
//        Player joshDonaldson = new Player("Josh", "Donaldsondsjfklasdjflkasdfjalsdfas");
//        joshDonaldson.setId(4323);
//        joshDonaldson.setAge(230.4);
//        joshDonaldson.setNationality("American");
//        joshDonaldson.setTeam(blueJays);
//        joshDonaldson.setPosition("Outfield");
//        
//        Player jose = new Player("Jose", "Baustisa");
//        Player sidney = new Player("Sidney", "Crosby");
//        
//        blueJays.add(joshDonaldson);
//        blueJays.add(jose);
//        blueJays.remove(jose);
//        blueJays.remove(sidney);
//        System.out.println(blueJays.toString());
//        System.out.println(joshDonaldson.toString());
        
        System.out.println( "-------------------" );
        System.out.println( "Test #1 - Empty Constructor" );
        Team penguins = new Team();
        assert(penguins.getCity() == null);
        assert(penguins.getId() == 1);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #2 - isValid()" );
        assert(penguins.isValid() == false);
        
        penguins.setCity("Pittsburgh");
        penguins.setName("Penguins");
        penguins.setId(314725);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - add(..) invalid Player" );
        Player sidneyCrosby = new Player("Sidney", "Crosby");
        assert(penguins.getPlayers().size() == 0);
        penguins.add(sidneyCrosby);
        assert(penguins.getPlayers().size() == 1);
        penguins.remove(sidneyCrosby);
        assert(penguins.getPlayers().size() == 0);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - isValid(..) invalid Team" );
        Team blueJays = new Team("Toronto", "Blue Jays");
        assert(!blueJays.isValid());
        blueJays.setId(235762);
        blueJays.setSport("baseball");
        assert(blueJays.isValid());
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - remove(..) invalid Player" );
        Player joshDonaldson = new Player(518626);
        blueJays.remove(joshDonaldson);
        assert(blueJays.getPlayers().size() == 0);
        joshDonaldson.setFirstName("Josh");
        joshDonaldson.setLastName("Donaldson");
        blueJays.add(joshDonaldson);
        blueJays.add(joshDonaldson);
        assert(blueJays.getPlayers().size() == 1);
        blueJays.remove(joshDonaldson);
        assert(blueJays.getPlayers().size() == 0);
        blueJays.add(sidneyCrosby);
        assert(blueJays.get(sidneyCrosby) == sidneyCrosby);
        
    }
    
}
