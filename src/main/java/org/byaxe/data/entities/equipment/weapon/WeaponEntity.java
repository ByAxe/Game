package org.byaxe.data.entities.equipment.weapon;

import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "weapon")
public class WeaponEntity extends AbstractEquipmentEntity {

    private int damageMin;
    private int damageMax;
    private WeaponTypeEntity weaponType;
    private Set<EffectsEntity> effects = new HashSet<>();

    @Column(name = "damage_min")
    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    @Column(name = "damage_max")
    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_type")
    public WeaponTypeEntity getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponTypeEntity weaponType) {
        this.weaponType = weaponType;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "weapon_effects", joinColumns = {
            @JoinColumn(name = "weapon_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "effect_id")
    })
    public Set<EffectsEntity> getEffects() {
        return effects;
    }

    public void setEffects(Set<EffectsEntity> effects) {
        this.effects = effects;
    }
}