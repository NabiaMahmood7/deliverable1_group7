/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trystankolenda
 */
public class WarGame extends Game {
    
    //creates the deck the will be split and used by the players
    private ArrayList<WarCard> deck = new ArrayList<>(); 
    

    public WarGame(String name) {
        super(name);
    }
    
    public void createDeck(){
        for(WarCard.Suit s : WarCard.Suit.values()){
            for(WarCard.Rank r : WarCard.Rank.values()){
                deck.add(new WarCard(s, r));
            }
        }
        Collections.shuffle(deck);
    }
    
    public void dealCards() {
    ArrayList<Player> players = getPlayers(); 
    
    for (int i = 0; i < deck.size(); i++) {
        // Cast the Player to WarPlayer to access addCard 
        ((WarPlayer) players.get(i % 2)).addCard(deck.get(i));
        }
    }
    
    @Override
    //starts the game and continues to play rounds as long as both players
    // have more than 0 cards
    // each round is handled by a different class that doesnt have to be called
    // by main file.
    public void play(){
        createDeck();
        dealCards();
        
        //casts player into WarPlayer
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);
        
        while(player1.getHandSize() > 0 && player2.getHandSize() > 0){
            ArrayList<WarCard> pile = new ArrayList<>();
            playRound(player1, player2, pile);
        }
        
    }
    //the specifics of each round is handled in this class
    //private because its started from game logic.
    private void playRound(WarPlayer player1, WarPlayer player2, ArrayList<WarCard> pile){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(WarGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WarCard card1 = player1.drawCard();
        WarCard card2 = player2.drawCard();
        
        if(card1 == null || card2 == null)
            return;
        
        pile.add(card1);
        pile.add(card2);
        
        System.out.println(player1.getName() + " plays " + card1 + " | " + player2.getName() + " plays " + card2);
        
        if(card1.getRank().getValue() > card2.getRank().getValue()){
            player1.addCards(pile);
            System.out.println(player1.getName() + " wins the round!");
        }else if(card1.getRank().getValue() < card2.getRank().getValue()){
            player2.addCards(pile);
            System.out.println(player2.getName() + " wins the round!");
        }else{
            System.out.println("WAR!");
            //rules of war handled outside this class for SRP
            beginWar(player1, player2, pile);
        }
        
    }
    //private because the begginning of war is determined by the game logic.s
    private void beginWar(WarPlayer player1, WarPlayer player2, ArrayList<WarCard> pile){
        //each player must have at least three cards to play
        //if requirement is not meant, a winner is declared.
        if(player1.getHandSize() > 3 && player2.getHandSize() > 3){
            for (int i = 0; i < 3; i++){
                if(player1.getHandSize() > 1) 
                    pile.add(player1.drawCard());
                if(player2.getHandSize() > 1)
                    pile.add(player2.drawCard());
            }
            playRound(player1, player2, pile);
        }else{
            declareWinner();
        }
    }
    
    
    
    /*
    * declare winner only checks which player has the bigger hand so that
    * Play and beginWar method can both determine seperate conditions for calling a winner.
    */
    @Override
    public void declareWinner(){
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);
        
        if(player1.getHandSize() > player2.getHandSize()){
            System.out.println("GAME OVER: " + player1.getName() + " WINS THE WAR!");
        }else{
            System.out.println("GAME OVER: " + player2.getName() + " WINS THE WAR!");
        }
        
    }
    
    
}
