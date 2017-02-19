package gamebase;

import tyrantunleashed.TyrantMove;
import tyrantunleashed.TyrantPlayer;

public abstract class Strategy { 

	protected Player p, o;
	
	public Strategy(Player _p){
		p = _p;
	}
	
	public abstract Move nextMove();
	
}
