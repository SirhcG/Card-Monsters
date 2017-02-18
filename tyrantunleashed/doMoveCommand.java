package tyrantunleashed;

import java.io.IOException;

public class doMoveCommand implements Command{

	Move m;
	TyrantPlayer p;
	
	public doMoveCommand(TyrantPlayer _p, Move _m){
		p = _p;
		m = _m;
	}
	
	@Override
	public void execute() {
		
		m.go(p);
	}

}
