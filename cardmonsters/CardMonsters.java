/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import gamebase.Player;
import gamebase.CardBase;
//import tyrantunleashed.*;

import java.util.ArrayList;
/**
 *
 * @author planb
 */
public class CardMonsters {
    
	AbstractFactory cardFactory;
	AbstractFactory playerFactory;
        MonsterPlayer copy;
	MonsterPlayer first;
	MonsterPlayer second;
        MonsterPlayer third;
        CampaignBattle battle;
	
     public CardMonsters() {
         
         cardFactory = FactoryProducer.getFactory("card");
         playerFactory = FactoryProducer.getFactory("player");
         
         
         CardBase one = cardFactory.getCard("melee");
         CardBase two = cardFactory.getCard("melee");
         CardBase three = cardFactory.getCard("melee");
         
         CardBase four = cardFactory.getCard("melee");
         CardBase five = cardFactory.getCard("melee");
         CardBase six = cardFactory.getCard("melee");
         
         CardBase seven = cardFactory.getCard("melee");
         CardBase eight = cardFactory.getCard("melee");
         CardBase nine = cardFactory.getCard("melee");
         
         first = playerFactory.getPlayer("user");
         second = playerFactory.getPlayer("opponent");
         third = playerFactory.getPlayer("opponent");
         
         ArrayList<MonsterPlayer> opp = new ArrayList<>();
         opp.add(second);
         opp.add(third);
         
        
         
         ArrayList<CardBase> val = new ArrayList<>();
         val.add((CardBase) one);
         val.add((CardBase) two);
         val.add((CardBase) three);
         
         ArrayList<CardBase> val2 = new ArrayList<>();
         val2.add((CardBase) four);
         val2.add((CardBase) five);
         val2.add((CardBase) six);
         
         ArrayList<CardBase> val3 = new ArrayList<>();
         val3.add((CardBase) seven);
         val3.add((CardBase) eight);
         val3.add((CardBase) nine);
         
         
         first.setCards(val);
         second.setCards(val2);
         third.setCards(val3);
         battle = new CampaignBattle(first, opp);
         
         //System.out.println(first.getHand());  
        // System.out.println(second.getHand());
         
        }
     
     public void go(){
         battle.begin();
     }
    
}


