/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyrantunlashed2;

import java.util.ArrayList;

import tyrantunlashed2.Player.StrategyType;

/**
 *
 * @author planb
 */
public class TyrantUnlashed2 {

    public static void main(String[] args) {
        
        Player cg = new Player("Player", 100, 3, StrategyType.SIMPLE);
        Player opponent = new Player("Opponent", 40, 3, StrategyType.DEFENSIVE);
        Battle battle = new Battle(cg,opponent);
        createSampleHand(cg,opponent);
        
        battle.start();
        
        /*
        createSampleHand(cg,opponent);
        showInfo(cg,opponent);
           
        Move move = new Move(0); //the 0 refers to the handindex of the card being played
        cg.doMove(move);
        showInfo(cg,opponent);
        
        move = opponent.strategy.nextMove(); //testing defensive strategy. it should return a move with the highest hp card set to be 200 for testing
        opponent.doMove(move);
        showInfo(cg,opponent);
        
        System.out.println("\n!!!!!!!!PLAYER DOES BATTLE!!!!!!!!\n");
        battle.battle(1); //do the battle for player 1
        showInfo(cg,opponent);
        
        System.out.println("\n!!!!!!!!OPPONENT DOES BATTLE!!!!!!!!\n");
        battle.battle(2); //do the battle for player 2
        showInfo(cg,opponent);
        */
    
    }
    
    public static void createSampleHand(Player cg, Player opponent){
    	
    	//creating sample cards for player
    	 AttackBoost one = new AttackBoost("name", 20, 30);
         AttackBoost card0 = new AttackBoost("card1", 20, 30);
         ArmorBoost card1 = new ArmorBoost("card2", 20, 30);
         StrikeBoost card2 = new StrikeBoost("card3", 20, 30);
         
         ArrayList<CardBase> val = new ArrayList<>();
          
         val.add(card0);
         val.add(card1);
         val.add(card2);
         
         cg.setCards(val);
         
         //creating sample hand for opponent
         AttackBoost card3 = new AttackBoost("card4", 20, 20);
         AttackBoost card4 = new AttackBoost("card5", 20, 100);
         AttackBoost card5 = new AttackBoost("card6", 20, 200);
         
         ArrayList<CardBase> opponentHand = new ArrayList<>() ;
         
         opponentHand.add(card3);
         opponentHand.add(card4);
         opponentHand.add(card5);
         
         opponent.setCards(opponentHand);
    }
    
    public static void showInfo(Player cg, Player opponent){
    	System.out.println("\nPLAYER INFORMATION");
        System.out.println("Health : " + cg.getHealth());
        System.out.println("PLAYER HAND");
        System.out.println(cg.getHand());
        System.out.println("PLAYER FIELD");
        System.out.println(cg.getField());
        
        System.out.println("\nOPPONENT INFORMATION");
        System.out.println("Health : " + opponent.getHealth());
        System.out.println("OPPONENT HAND");
        System.out.println(opponent.getHand());
        System.out.println("OPPONENT FIELD");
        System.out.println(opponent.getField());
    }

}
