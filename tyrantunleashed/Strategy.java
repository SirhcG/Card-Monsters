package tyrantunleashed;

public abstract class Strategy { 

	protected TyrantPlayer p, o;
	
	public Strategy(TyrantPlayer _p){
		p = _p;
	}
	
	public abstract Move nextMove();
	
}
