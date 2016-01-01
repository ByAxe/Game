package abilities.implementLevel.constructive;

import abilities.abstractLevel.AbstractAbility;

public class NaturePower extends AbstractAbility {

    public NaturePower(String title, String description, int heal, int damage, byte requiredLevel, int requiredCountOfMP) {
        super(title, description, heal, damage, requiredLevel, requiredCountOfMP);
    }

    public NaturePower() {
    }

    @Override
    public int use() {
        return getHeal();
    }
}
