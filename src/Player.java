/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyrantunlashed2;

import java.util.ArrayList;

/**
 *
 * @author planb
 */
public class Player {
    
	public enum StrategyType{
		SIMPLE, DEFENSIVE
	}
	//variable names should not be capitalized
	private String name;
    private int Health;
    private ArrayList<CardBase> Field;
    private ArrayList<CardBase> Hand;
    private int turnCounter = 0;
    private int CardsInField = 0;
    private int FieldPosition = 0;
    private int Check = 0;
    Strategy strategy;
    
    public Player(String _name, int Health , int cardAmount, StrategyType s){ //why do you need to pass in cardAmmount? is this just the maximum field and handsize? 
    	
    	name = _name;
        this.Health = Health;
        Hand = new ArrayList<>();
        Field = new ArrayList<>();
        
        if(s == StrategyType.SIMPLE)
        	strategy = new SimpleStrategy(this);
        else if (s == StrategyType.DEFENSIVE)
        	strategy = new DefensiveStrategy(this);
        
    }
    
    public void setHealth(int Health){
        this.Health = Health;
    }
    
    public void setCards(ArrayList<CardBase> a){ 
        this.Hand = a;
    }
    
    public void setField(ArrayList<CardBase> b){
        this.Field = b;
    }
    
    
    public int getHealth(){
        return this.Health;
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
    
    public void doMove(Move move){ //takes in a move object and does that move
    	playCard(move.handIndex);
    	
    	
    }
    
    public void showInfo(){
    	System.out.println("\n"+ name + " INFORMATION");
        System.out.println("Health : " + getHealth());
        System.out.println(name + " HAND");
        System.out.println(getHand());
        System.out.println(name + " FIELD");
        System.out.println(getField());
    }
    
    public String getName(){
    	return name;
    }
}
