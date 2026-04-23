package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class StunnedState implements HeroState {

    @Override
    public String getName() { return "Stunned"; }

    @Override
    public int modifyOutgoingDamage(int basePower) { return 0; }

    @Override
    public int modifyIncomingDamage(int rawDamage) { return (int)(rawDamage * 1.5); }

    @Override
    public void onTurnStart(Hero hero) {
        System.out.println(hero.getName() + " is stunned and cannot act!");
    }

    @Override
    public void onTurnEnd(Hero hero) {
        if (hero.getState() == this) {
            System.out.println(hero.getName() + " recovers from stun!");
            hero.setState(new NeutralState());
        }
    }

    @Override
    public boolean canAct() { return false; }
}

