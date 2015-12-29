package abilities;

public abstract class AbstractAbility implements IAbility {

    private String title;
    private String description;
    private int heal;
    private int damage;
    private byte requiredLevel;
    private int requiredCountOfMP;

    public AbstractAbility(String title, String description, int heal, int damage, byte requiredLevel, int requiredCountOfMP) {
        this.title = title;
        this.description = description;
        this.heal = heal;
        this.damage = damage;
        this.requiredLevel = requiredLevel;
        this.requiredCountOfMP = requiredCountOfMP;
    }

    public AbstractAbility() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getHeal() {
        return heal;
    }

    public int getDamage() {
        return damage;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public int getRequiredCountOfMP() {
        return requiredCountOfMP;
    }

}
