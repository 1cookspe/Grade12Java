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
        
        System.out.println( "-------------------" );
        System.out.println( "Test #1 - Empty Constructor" );
        Team penguins = new Team();
        Player malkin = new Player();
        System.out.println("PRE-CONDITION:");
        assert(penguins.getCity() == null);
        assert(penguins.getId() == 1);
        assert(malkin.getId() == 1);
        assert(malkin.getFirstName() == null);
        System.out.println("POST-CONDITION:");
        penguins.setCity("Pittsburgh");
        penguins.setName("Penguins");
        assert(penguins.getCity() == "Pittsburgh");
        assert(penguins.getName() == "Penguins");
        assert(!penguins.isActive());
        assert(penguins.getAge() == 0.0);
        malkin.setFirstName("Evgeni");
        malkin.setLastName("Malkin");
        penguins.setAge(49.2);
        penguins.setActive(true);
        assert(penguins.getAge() == 49.2);
        assert(penguins.isActive());
        assert(malkin.getFirstName().equals("Evgeni"));
        assert(malkin.getLastName().equals("Malkin"));
        
        System.out.println( "-------------------" );
        System.out.println( "Test #2 - Second Constructor" );
        Team barcelona = new Team(342363);
        Player messi = new Player(120932);
        System.out.println("PRE-CONDITION:");
        assert(barcelona.getId() == 342363);
        assert(messi.getId() == 120932);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - Third Constructor" );
        Team patriots = new Team("New England", "Patriots");
        Player brady = new Player("Tom", "Brady");
        System.out.println("PRE-CONDITION:");
        assert(patriots.getCity().equals("New England"));
        assert(patriots.getName().equals("Patriots"));
        assert(brady.getFirstName().equals("Tom"));
        assert(brady.getLastName().equals("Brady"));
        assert(patriots.getId() == 5);
        assert(brady.getId() == 3);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #2 - isValid()" );
        System.out.println("PRE-CONDITION:");
        assert(penguins.isValid() == false);
        penguins.setId(314725);
        assert(!penguins.isValid());
        System.out.println("POST-CONDITION:");
        penguins.setSport("hockey");
        assert(penguins.isValid());
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - add(..) invalid Player" );
        System.out.println("PRE-CONDITION:");
        Player sidneyCrosby = new Player("Sidney", "Crosby");
        assert(penguins.getPlayers().size() == 0);
        System.out.println("POST-CONDITION:");
        penguins.add(sidneyCrosby);
        assert(penguins.getPlayers().size() == 1);
        penguins.remove(sidneyCrosby);
        assert(penguins.getPlayers().size() == 0);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - isValid(..) invalid Team" );
        Team blueJays = new Team("Toronto", "Blue Jays");
        System.out.println("PRE-CONDITION:");
        assert(!blueJays.isValid());
        blueJays.setId(235762);
        blueJays.setSport("baseball");
        System.out.println("POST-CONDITION:");
        assert(blueJays.isValid());
        
        System.out.println( "-------------------" );
        System.out.println( "Test #3 - remove(..) invalid Player" );
        System.out.println("PRE-CONDITION:");
        Player joshDonaldson = new Player(518626);
        blueJays.remove(joshDonaldson);
        assert(blueJays.getPlayers().size() == 0);
        joshDonaldson.setFirstName("Josh");
        joshDonaldson.setLastName("Donaldson");
        blueJays.add(joshDonaldson);
        blueJays.add(joshDonaldson);
        System.out.println("POST-CONDITION:");
        assert(blueJays.getPlayers().size() == 1);
        blueJays.remove(joshDonaldson);
        assert(blueJays.getPlayers().size() == 0);
        blueJays.add(sidneyCrosby);
        blueJays.add(joshDonaldson);
        assert(blueJays.getPlayers().size() == 2);
        assert(blueJays.get("Crosby") == sidneyCrosby);
        blueJays.remove(sidneyCrosby);
        assert(blueJays.get("Crosby") == null);
        
        System.out.println( "-------------------" );
        System.out.println( "Test #4 - equals(..) equal Players and Teams" );
        System.out.println("PRE-CONDITION:");
        assert(sidneyCrosby.equals(joshDonaldson) == false);
        Team blueJoes = new Team(235762);
        assert(!blueJoes.equals(blueJays));
        System.out.println("POST-CONDITION:");
        Player joseBautistsa = new Player("Josh", "Donaldson");
        joseBautistsa.setId(518626);
        assert(joseBautistsa.equals(joshDonaldson));
        blueJoes.setCity("Toronto");
        blueJoes.setName("Blue Jays");
        assert(blueJoes.equals(blueJoes));
        
        System.out.println( "-------------------" );
        System.out.println( "Test #5 - Player properties" );
        System.out.println("PRE-CONDITION:");
        assert(joshDonaldson.getAge() == 0.0);
        assert(!sidneyCrosby.isActive());
        Team yankees = new Team();
        assert(joseBautistsa.getNationality() == null);
        assert(sidneyCrosby.getPosition() == null);
        assert(joseBautistsa.getNationality() == null);
        Player davidBeckham = new Player();
        assert(!davidBeckham.isValid());
        System.out.println("POST-CONDITION:");
        joshDonaldson.setAge(30.4);
        sidneyCrosby.setActive(true);
        assert(joshDonaldson.getAge() == 30.4);
        assert(sidneyCrosby.isActive());
        joseBautistsa.setTeam(yankees);
        assert(joseBautistsa.getTeam() == yankees);
        joseBautistsa.setNationality("Dominican Republic");
        assert(joseBautistsa.getNationality().equals("DOM"));
        sidneyCrosby.setPosition("Center");
        assert(sidneyCrosby.getPosition().equals("Center"));
        davidBeckham.setFirstName("David");
        davidBeckham.setLastName("Beckham");
        assert(davidBeckham.isValid());
        
        System.out.println( "-------------------" );
        System.out.println( "Test #6 - toString of players and teams" );
        Team floridaPanthers = new Team("Florida", "Panthers");
        floridaPanthers.setActive(true);
        floridaPanthers.setAge(23.2);
        floridaPanthers.setSport("hockey");
        Player jaromirJagr = new Player();
        jaromirJagr.setFirstName("Jaromir");
        jaromirJagr.setLastName("Jagr");
        jaromirJagr.setActive(true);
        jaromirJagr.setAge(42.3);
        jaromirJagr.setNationality("Czech");
        jaromirJagr.setPosition("Right Wing");
        jaromirJagr.setTeam(floridaPanthers);
        System.out.println(jaromirJagr.toString());
    }
    
}
