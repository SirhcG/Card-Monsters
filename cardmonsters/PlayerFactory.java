/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import cardmonsters.MonsterPlayer.StrategyType;

/**
 *
 * @author planb
 */
public class PlayerFactory extends AbstractFactory{

   
    @Override
    MonsterPlayer getPlayer(String playerType) {
        
        if(playerType == null){
            return null;
        }
        else if(playerType.equalsIgnoreCase("Opponent")){
            return new MonsterPlayer("Opponent", StrategyType.SIMPLE);
        }
        else if(playerType.equalsIgnoreCase("User")){
            return new MonsterPlayer("User", StrategyType.SIMPLE);
        }
        
        return null;
    }
    
     @Override
    Card getCard(String Card) {
        return null;
    }
    
}
