/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author trystankolenda
 */
public class WarMain {
    public static void main(String args[]){
        
        WarGame myGame = new WarGame("Card War");
        
        WarPlayer p1 = new WarPlayer("Trystan");
        WarPlayer p2 = new WarPlayer("Jessie");
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        
        myGame.setPlayers(players);
        myGame.play();
      
    }
}
