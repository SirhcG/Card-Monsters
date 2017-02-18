/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import tyrantunlashed2.*;

/**
 *
 * @author planb
 */
public class Ranger extends CardBase implements CardSkill, Card {
    
    private int Attack;
    
    public Ranger(String name, int Attack, int Health){
        super(name, Attack, Health);
        this.Attack = Attack;
    }
    
    @Override
    public void ability(MonsterPlayer p, MonsterPlayer o){
        
       int val = o.getCardInField();
       
        if(val == 1){
           System.out.println("Cannot attack first position");
       }
        
        else if(val == 2){
            int health = o.getCard(1).getHealth();
            health = health - Attack;
            o.getCard(1).setHealth(health);
        }
        else if(val == 3){
            int health = o.getCard(2).getHealth();
            health = health - Attack;
            o.getCard(2).setHealth(health);
        }
        }
    
    
    @Override
    public void checkSkill() {
        System.out.println("Card can only attack field spots 2 and 3");
    }

    @Override
    public void checkName() {
        System.out.println(super.getName());
    }
    
}
