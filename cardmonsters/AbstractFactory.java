/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import gamebase.CardBase;

/**
 *
 * @author planb
 */
public abstract class AbstractFactory {
    
    abstract CardBase getCard(String Card);
    abstract MonsterPlayer getPlayer(String Player);
    
}
