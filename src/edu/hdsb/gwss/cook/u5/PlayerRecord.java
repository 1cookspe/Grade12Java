/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

/**
 *
 * @author 1cookspe
 */
public class PlayerRecord {
    private String playerName;
    private String countryName;
    private int ranking;
    protected final static int RECORD_SIZE = 60;
    private final static int PLAYER_LENGTH = 16;
    private final static int COUNTRY_LENGTH = 12;

    public PlayerRecord(String playerName, String countryName, int ranking) {
        setPlayerName(playerName);
        setCountryName(countryName);
        this.ranking = ranking;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (playerName != null) {
            stringBuilder.append(playerName.trim());
        } else {
            stringBuilder.append("TBD");
        }
        stringBuilder.setLength(PLAYER_LENGTH);
        this.playerName = stringBuilder.toString();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (countryName != null) {
            stringBuilder.append(countryName.trim());
        } else {
            stringBuilder.append("TBD");
        }
        stringBuilder.setLength(COUNTRY_LENGTH);
        this.countryName = stringBuilder.toString();
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    

}
