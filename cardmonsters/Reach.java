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
public class Reach extends CardBase implements CardSkill, Card {
    
    private int attack;
    
    public Reach(String name, int attack, int health){
        super(name, attack, health);
        this.attack = attack;
    }
    
    @Override
    public void ability(MonsterPlayer p, MonsterPlayer o){
    
        int val = o.getCardInField();
       
        if(val == 1){
            int health = o.getCard(0).getHealth();
            health = health - attack;
            o.getCard(0).setHealth(health);
       }
        
        else if(val == 2){
            int health = o.getCard(1).getHealth();
            health = health - attack;
            o.getCard(1).setHealth(health);
        }
        else if(val == 3){
            int health = o.getCard(2).getHealth();
            health = health - attack;
            o.getCard(2).setHealth(health);
        }
        }

    @Override
    public void checkSkill() {
        System.out.println("Can attack any card regardless of position");
    }

    @Override
    public void checkName() {
        System.out.println(super.getName());
    }
    
    
    
}
