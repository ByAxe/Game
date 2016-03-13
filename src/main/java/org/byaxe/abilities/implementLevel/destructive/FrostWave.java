package org.byaxe.abilities.implementLevel.destructive;

import org.byaxe.abilities.abstractLevel.AbstractAbility;

public class FrostWave extends AbstractAbility{

    public FrostWave(String title, String description, int heal, int damage, byte requiredLevel, int requiredCountOfMP) {
        super(title, description, heal, damage, requiredLevel, requiredCountOfMP);
    }

    public FrostWave() {
    }

    @Override
    public int use() {
        return getDamage();
    }
}
