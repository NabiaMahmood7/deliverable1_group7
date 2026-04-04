/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author trystankolenda
 */
public class WarCard extends Card{
    
    //having the enums within the WarCard class tightly couples the them.
    //we only want the suit and rank to be available only through the card.
    public enum Suit{  
    HEARTS, DIAMONDS, CLUBS, SPADES;
}
    
    public enum Rank {
    TWO(2),THREE(3),FOUR(4), FIVE(5),SIX(6),SEVEN(7),EIGHT(8), 
    NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13),ACE(14);
    
    //these values cannot be changed 
    private final int value;
    Rank(int value) {
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
}
    //
    private final Suit suit;
    private final Rank rank;

    //A card must be created with a rank and suit
    public WarCard(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public Rank getRank(){
        return rank;
    }
    
//    public int compareTo(WarCard card){
//        
//    }
    
    @Override
    public String toString(){
        return rank + " of " + suit;
    }
    
}
