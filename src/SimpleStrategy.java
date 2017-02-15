package tyrantunlashed2;

public class SimpleStrategy extends Strategy{
	
	public SimpleStrategy(Player _p){
		super(_p);
		
	}
	
	@Override
	public Move nextMove() { //returns a move object with the handindex for the card to be played onto the field from the hand
		
		if(p.getHand().size()>0){
			Move nextMove = new Move(0); //plays the first card in hand
			return nextMove;
		}
			
		return null; //returns null if no moves can be played
	}

}
