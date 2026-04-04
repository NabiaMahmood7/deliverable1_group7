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
public class WarPlayer extends Player {
    
    //the hand of a player contains a list of WarCards
    private ArrayList<WarCard> hand = new ArrayList<>();

    
    public WarPlayer(String name) {
        super(name);
    }
    
    
    public void addCard(WarCard card){
        hand.add(card);
    }
    public void addCards(ArrayList<WarCard> cards){
        hand.addAll(cards);
    }
    
    //simple logic for placing a card down 
    public WarCard drawCard(){
        if(hand.isEmpty())
            return null;
        return hand.remove(0);
    }
    
    public int getHandSize(){
        return hand.size();
    }
    
    
    
    @Override
    public void play(){
        //handled by game logic
    }
}
