/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import gamebase.CardBase;
import java.io.Serializable;


/**
 *
 * @author planb
 */
public class Melee extends CardBase implements CardSkill, Card, Serializable {
    
    
    public Melee(String name, int Attack, int Health){
        super(name, Attack, Health);
    }
    
    public Melee(){
        super(null, 0, 0);
    }

    @Override
    public void checkSkill() {
        System.out.println("This card has no special skill");
    }

    @Override
    public void checkName() {
        System.out.println(super.getName());
    }

    @Override
    public void ability(MonsterPlayer p, MonsterPlayer o) {
        System.out.println("This card has no skill");
    }
}
