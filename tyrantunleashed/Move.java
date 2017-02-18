/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyrantunleashed;

import java.io.IOException;

/**
 *
 * @author planb
 */
public class Move{
    
	public int handIndex;

	
	public Move(int _handIndex){
		handIndex = _handIndex;
	}
	
	@Override
	public String toString(){
		return String.valueOf(handIndex);
	}

	public void go(TyrantPlayer p) {
		
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
