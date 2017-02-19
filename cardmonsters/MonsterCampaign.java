/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import gamebase.Move;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author planb
 */
public abstract class MonsterCampaign {
    
    
    private ArrayList<MonsterPlayer> opponents;
    private ArrayList<MonsterPlayer> clones;
    MonsterMove move;
    MonsterdoMoveCommand mCommand;
    int dmg = 0, health = 0, val = 0, turn = 1, oppCount = 1;
    
    public MonsterCampaign(MonsterPlayer main, ArrayList<MonsterPlayer> array){
        opponents = new ArrayList<>();
        opponents = array;
        clones = new ArrayList<>();
        for(int i=0;i<opponents.size();i++){
            clones.add(main);
        }
      }
    
    public void begin(){
        
        Scanner val = new Scanner(System.in);
        int input = 0;
        MonsterPlayer boss = opponents.get(0);
        MonsterPlayer clone = clones.get(0);
        System.out.println("Welcome to the card monster campaign!!");
        
        
        while(true){
            
            System.out.println("Opponents remaining: " + opponents.size());
            clone.showInfo();
            boss.showInfo();
            
            if(clone.getHand().size() > 0){
    			
    			System.out.println("\nChoose which card to play. Numbering starts at 0\n");
        		input = val.nextInt(); //input for which card to play
        		
	    		while(input >= clone.getHand().size()){ //if invalid number
	    			System.out.println("\nInvalid choice. Choose which card to play. Numbering starts at 0\n");
	        		input = val.nextInt();
	    		}
	    		
	    		move = new MonsterMove(input); //make the move
	    		mCommand = new MonsterdoMoveCommand(clone, move); //attempting to implement command pattern
	    		mCommand.execute();
	    		
    		}
    		else{
    			System.out.println("\nYou have no cards to play. \n");
    			stop();
    		}
            
                clone.showInfo();
    		boss.showInfo();
    		
                
    		battle(1); //conducts battle for player 1
                check();
    		stop(); //waits for user button press to continue
    		
    		System.out.println("\nOpponent's turn starts!\n");
    		stop();
    		
    		move = (MonsterMove) boss.getStrategy().nextMove();
    		if (move != null){
    			
    			mCommand = new MonsterdoMoveCommand(boss, (MonsterMove) move);
    			mCommand.execute();
    			stop();
    		}else
    			System.out.println("\nOpponent has no cards to play! \n");
    		
    		 //conducts battle for player 2
                
    		battle(2);
    		check();
    		endOfTurn(); //end of turn stuff
    	}
    }
     
    
    public void battle(int turnPlayer){
	   
    	if(turn == 1) //cannot attack on first turn
    		return;
    	
	   //if its the players turn
		MonsterPlayer one = clones.get(0);
		MonsterPlayer two = opponents.get(0);

		//if its the opponents turn
		if(turnPlayer == 2){
			one = opponents.get(0);
			two = clones.get(0);
		}
	   
		one.showInfo();
		
		
		
		for(int i=0; i<one.getField().size(); i++){
	
			one.getCard(i).ability(one, two);
	    	   
	    	   if(two.getField().size() > 0){
	    		   dmg = one.getCard(i).getDamage();
		    	   health = two.getCard(0).getHealth();
		    	   val = health - dmg;
	    		   two.getCard(0).setHealth(val);	//deal damage to the card
	    		   
	    		   
	    		   System.out.println(one.getCard(i).getName()+ " attacks " + two.getCard(0).getName() +"!\n");
	    		   stop();
	    		   
	    		   if(two.getCard(0).getHealth() < 0){ // if the opposing card is dead
	    			   System.out.println(one.getCard(i).getName()+ " destroys " + two.getCard(0).getName() + "!\n");
	    			   stop();
	    			   two.getField().remove(0);	//remove it
	    		   }
	    	   }
	    	   
	       }    
   }
   
   private void check(){
	   if(clones.get(0).getCardInField() == 0 && turn > 2){
		   System.out.println("OPPONENT WINS");
		   System.exit(0);
		   
	   }   
	   else if(opponents.get(0).getCardInField() == 0 && turn > 2){
		   System.out.println("PLAYER BEAT OPPONENT " + oppCount);
                   turn = 1;
                   oppCount++;
                   opponents.remove(0);
                   opponents.trimToSize();
                   clones.remove(0);
                   clones.trimToSize();
                   
                   save();
           }
   }
   
   private void save(){
       System.out.println("Would you like to save?? [Y/N] ");
       begin();
       
   }

   private void stop(){
	   try {
			System.in.read();
		} catch (IOException e){
			e.printStackTrace();
		}
   }
   
   private void endOfTurn(){ 
	   for(int i = 0; i< clones.get(0).getHand().size();i++){ //clears any temporary damage boosts for player
		   clones.get(0).getHand().get(i).setDamage(clones.get(0).getHand().get(i).getAttack());
	   }
	   
	   for(int i = 0; i< opponents.get(0).getHand().size();i++){ //clears any temporary damage boosts for opponent
		   opponents.get(0).getHand().get(0).setDamage(opponents.get(0).getHand().get(0).getAttack());
	   }
	   
	   turn++;
	   
   }
}

            
            
            
    