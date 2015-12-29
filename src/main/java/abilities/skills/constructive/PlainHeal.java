package abilities.skills.constructive;

import abilities.AbstractAbility;

public class PlainHeal extends AbstractAbility {

    public PlainHeal(String title, String description, int heal, int damage, byte requiredLevel, int requiredCountOfMP) {
        super(title, description, heal, damage, requiredLevel, requiredCountOfMP);
    }

    public PlainHeal() {
    }

    @Override
    public int use() {
        return getHeal();
    }
}
