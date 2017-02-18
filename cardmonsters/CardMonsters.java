/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import cardmonsters.MonsterPlayer.StrategyType;
import tyrantunleashed.*;

import java.util.ArrayList;
/**
 *
 * @author planb
 */
public class CardMonsters {
    
	AbstractFactory cardFactory;
	AbstractFactory playerFactory;
	MonsterPlayer first;
	MonsterPlayer second;
	
     public CardMonsters() {
         
         cardFactory = FactoryProducer.getFactory("card");
         playerFactory = FactoryProducer.getFactory("player");
         
         Card one = cardFactory.getCard("melee");
         Card two = cardFactory.getCard("ranger");
         Card three = cardFactory.getCard("Heal");
         
         first = playerFactory.getPlayer("user");
         second = playerFactory.getPlayer("opponent");
         
         ArrayList<CardBase> val = new ArrayList<>();
         val.add((CardBase) one);
         val.add((CardBase) two);
         val.add((CardBase) three);
         
         first.setCards(val);
         System.out.println("Test");
         System.out.println(first.getHand());  
         
         
     }
    
}
