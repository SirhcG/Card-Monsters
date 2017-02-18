package gamebase;

import cardmonsters.MonsterPlayer;

public abstract class Move {

	protected int handIndex;
	
	public Move(int _handIndex){
		handIndex = _handIndex;
	}

	@Override
	public String toString(){
		return String.valueOf(handIndex);
	}
	
	public abstract void go(Player p);
}
