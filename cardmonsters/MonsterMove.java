package cardmonsters;

import java.io.IOException;
import gamebase.Move;
import gamebase.Player;

/**
 *
 * @author planb
 */
public class MonsterMove extends Move{
    
	
	public MonsterMove(int _handIndex){
		super(_handIndex);
	}

	@Override
	public void go(Player p) {
		
		String name = p.getHand().get(handIndex).getName();
		p.playCard(handIndex);
		
		System.out.println(p.getName() + " PLAYED " + name + " ONTO THE FIELD\n");

		try {
			System.in.read();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		p.setTurn();
		
	}



}
