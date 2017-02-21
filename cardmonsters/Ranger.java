/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import gamebase.CardBase;
import java.io.Serializable;
import tyrantunleashed.*;

/**
 *
 * @author planb
 */
public class Ranger extends CardBase implements CardSkill, Serializable {
    
    private int Attack;
    
    public Ranger(String name, int Attack, int Health){
        super(name, Attack, Health);
        this.Attack = Attack;
    }
    
    public Ranger(){
        super(null, 0, 0);
    }
    
    @Override
    public void ability(MonsterPlayer p, MonsterPlayer o){
        
       int val = o.getCardInField();
       
        if(val == 1){
           this.Attack = 0;
           System.out.println("Cannot attack first position");
           checkSkill();
       }
        
        else if(val == 2){
            this.Attack = 10;
            int health = o.getCard(1).getHealth();
            health = health - Attack;
            o.getCard(1).setHealth(health);
            checkSkill();
        }
        else if(val == 3){
            int health = o.getCard(2).getHealth();
            health = health - Attack;
            o.getCard(2).setHealth(health);
            checkSkill();
        }
        
        }
    
    
    @Override
    public void checkSkill() {
        System.out.println("Card can only attack field spots 2 and 3");
    }
    
}
