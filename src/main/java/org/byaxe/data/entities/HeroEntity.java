package org.byaxe.data.entities;

import javax.persistence.*;

/**
 * Created by byaxe on 3/13/16.
 */
@Entity
@Table(name = "heroes")
public class HeroEntity extends AbstractEntity {

    private String name;
    private int lvl;
    private int experience;
    private WeaponEntity weapon;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon")
    public WeaponEntity getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponEntity weapon) {
        this.weapon = weapon;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lvl")
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Column(name = "experience")
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
