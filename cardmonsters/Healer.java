/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;
import gamebase.CardBase;
import tyrantunleashed.*;

/**
 *
 * @author planb
 */
public class Healer extends CardBase implements CardSkill {
    
    private int Heal;
    
    public Healer(String name, int Attack, int Health){
        super(name, Attack, Health);
        this.Heal = 10;
    }
    
    @Override
    public void ability(MonsterPlayer p, MonsterPlayer o){
        int val = p.getCardInField();
        if(val >= 1){
           int health = p.getCard(0).getHealth();
           health = health + Heal;
           p.getCard(0).setHealth(health);
        }
        
        checkSkill();
    }

    @Override
    public void checkSkill() {
        System.out.println("This card will heal any monster in the main field");
    }
    
}
