package gamebase;

import java.util.ArrayList;

import tyrantunleashed.CardBase;
import tyrantunleashed.Move;
import tyrantunleashed.Strategy;

public abstract class Player {

	public enum StrategyType{
		SIMPLE, DEFENSIVE
	}
	
	protected String name;
	protected ArrayList<CardBase> Field;
    protected ArrayList<CardBase> Hand;
    protected Strategy strategy;
    protected int turnCounter = 0;
    
    public Player(String _name){
    	name = _name;
    	
    	Hand = new ArrayList<>();
        Field = new ArrayList<>();
    }
    
    public Strategy getStrategy(){
    	return strategy;
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
    
    public String getName(){
    	return name;
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
    
    public abstract void showInfo(); //abstract method
}
