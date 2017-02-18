/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmonsters;

import java.util.Scanner;
import tyrantunlashed2.*;

/**
 *
 * @author planb
 */
public class Heal  extends CardBase implements CardSkill, Card {
    
    private int healAmount;
    
    public Heal(String name, int attack, int health){
        super(name, 0, 0);
        this.healAmount = 20;
        
    }
    
    public void ability(MonsterPlayer p, MonsterPlayer o){
        System.out.println("Please choose a monster to heal");
        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        int base = p.getCard(val).getHealth();
        base = base + healAmount;
        p.getCard(val).setHealth(base);
        p.getField().remove(this);
        
    }

    @Override
    public void checkSkill() {
        System.out.println("Equip card heals a monster by 20hp points!!");
    }

    @Override
    public void checkName() {
        System.out.println(super.getName());
    }
    
}
