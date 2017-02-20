package gamebase;

import java.io.Serializable;
import tyrantunleashed.TyrantMove;
import tyrantunleashed.TyrantPlayer;

public abstract class Strategy implements Serializable { 

	protected Player p, o;
	
	public Strategy(Player _p){
		p = _p;
	}
	
	public abstract Move nextMove();
	
}
