package abilities.implementLevel.destructive;


import abilities.abstractLevel.AbstractAbility;

public class FireBall extends AbstractAbility {

    public FireBall(String title, String description, int heal, int damage, byte requiredLevel, int requiredCountOfMP) {
        super(title, description, heal, damage, requiredLevel, requiredCountOfMP);
    }

    public FireBall() {
    }

    @Override
    public int use() {
        return getHeal();
    }

}
