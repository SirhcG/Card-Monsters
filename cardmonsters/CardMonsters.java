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
	MonsterPlayer first;
	MonsterPlayer second;
        MonsterPlayer third;
        CampaignBattle battle;
	
     public CardMonsters() {
         
         cardFactory = FactoryProducer.getFactory("card");
         playerFactory = FactoryProducer.getFactory("player");
         
         
         Card one = cardFactory.getCard("melee");
         Card two = cardFactory.getCard("melee");
         Card three = cardFactory.getCard("melee");
         
         Card four = cardFactory.getCard("melee");
         Card five = cardFactory.getCard("melee");
         Card six = cardFactory.getCard("melee");
         
         Card seven = cardFactory.getCard("melee");
         Card eight = cardFactory.getCard("melee");
         Card nine = cardFactory.getCard("melee");
         
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


