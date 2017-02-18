/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;
import tyrantunleashed.*;

/**
 *
 * @author planb
 */
public class DefensiveMonsterStrategy extends Strategy {
    
    public DefensiveMonsterStrategy(MonsterPlayer _p){
		super(_p);
	}

	@Override
	public Move nextMove() { //returns a move object with the handindex for the card to be played onto the field from the hand
		
		int maxHp = 0;
		int index = 0;
		
		if(p.getHand().size() == 0)
			return null;
		
		for(int i = 0; i < p.getHand().size() ; i++){ //nextMove = card with the most HP
			if(p.getHand().get(i).getHealth() > maxHp){
				maxHp = p.getHand().get(i).getHealth();
				index = i;
			}
		}
		
		Move nextMove = new Move(index);
		return nextMove;

	}

}

    
