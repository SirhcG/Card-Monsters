/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

/**
 *
 * @author planb
 */
public class CardFactory extends AbstractFactory {

    @Override
    Card getCard(String cardType) {
        
        if(cardType == null){
            return null;
        }
        
        if(cardType.equalsIgnoreCase("Melee")){
            return new Melee("Melee", 10, 50);
        }
        
        if(cardType.equalsIgnoreCase("Ranger")){
            return new Ranger("Ranger", 10, 30);
        }
        
        if(cardType.equalsIgnoreCase("Healer")){
            return new Healer("Healer", 0, 70);
        }
        
        if(cardType.equalsIgnoreCase("Heal")){
            return new Heal("Heal", 0, 0);
        }
        
        if(cardType.equalsIgnoreCase("Reach")){
            return new Reach("Reach", 10, 30);
        }
        
        return null;
}

    @Override
    MonsterPlayer getPlayer(String Player) {
        return null;
    }
}