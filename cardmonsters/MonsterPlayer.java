/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;
import gamebase.CardBase;
import gamebase.Player;
import java.io.Serializable;

import java.util.ArrayList;

import tyrantunleashed.*;
/**
 *
 * @author planb
 */
public class MonsterPlayer extends Player implements Serializable {
    
    public MonsterPlayer(String _name, StrategyType s){  
    	super(_name);
    	name = _name;
        
        if(s == StrategyType.SIMPLE)
        	strategy = new SimpleMonsterStrategy(this);
        else if (s == StrategyType.DEFENSIVE)
        	strategy = new DefensiveMonsterStrategy(this);
        
    }
    
    
    
   
    
    public void setCards(ArrayList<CardBase> a){ 
        this.Hand = a;
    }
    
    public void setField(ArrayList<CardBase> b){
        this.Field = b;
    }
    
    
    
    public int getTurn(){
        return this.turnCounter;
    }
    
    public void setTurn(){
        this.turnCounter++;
    }
    
    public void setCardInField(){
        this.CardsInField++;
    }
    
    public int getCardInField(){
        
    	return Field.size();
    }
    
    public void removeCard(){
       int temp = this.CardsInField--;
       if(temp < 0){
           this.CardsInField = 0;
       }
    }
    
    public void setCheck(){
        this.Check++;
    }
    public int Check(){
        return Check;
    }
    
    public void setPosition(){
        this.FieldPosition++;
    }
    
    public int getPosition(){
        return FieldPosition;
    }
    
    public void removePosition(){
        int temp = this.FieldPosition--;
        if(temp < 0){
            this.FieldPosition = 0;
        }
    }
    
    public void setCard(){
        
       CardBase temp = getHandCard(0); 
       Field.set(FieldPosition, temp); 
       Hand.remove(0);
       Hand.trimToSize(); 
    }
    
   public CardBase getCard(int index){ 
       return Field.get(index);
   }
   
   public CardBase getHandCard(int index){ 
       return Hand.get(index);
   }
   
   
  
   
   public void remove(int index){ 
       Field.remove(index);
   }
   
   public void removeHand(int index){ 
        Hand.remove(index);
        
   }
    
    public ArrayList<CardBase> getField(){
    	return Field;
    }
    
    public ArrayList<CardBase> getHand(){
        return Hand;
    }
    
    public void playCard(int i){ //plays a card from hand to field
    	
    	CardBase c = Hand.get(i);
    	Field.add(c);
    	Hand.remove(i);
    }
    
    public void doMove(MonsterMove move){ //takes in a move object and does that move
    	playCard(move.handIndex);
    	
    	
    }
    
    public void showInfo(){
    	System.out.println("\n"+ name + " INFORMATION");
        System.out.println(name + " HAND");
        System.out.println(getHand());
        System.out.println(name + " FIELD");
        System.out.println(getField());
    }
    
    public String getName(){
    	return name;
    }
}

    

