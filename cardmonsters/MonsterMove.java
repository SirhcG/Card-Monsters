package cardmonsters;

import java.io.IOException;
import gamebase.Move;
import cardmonsters.MonsterPlayer;
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
	public void Monstergo(MonsterPlayer p) {
		
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

    @Override
    public void go(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


}
