package org.byaxe.data.entities.equipment.armor;

import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "armor")
public class ArmorEntity extends AbstractEquipmentEntity {

    private int protectionMin;
    private int protectionMax;
    private ArmorTypeEntity armorType;
    private Set<EffectsEntity> effects = new HashSet<>();

    @Column(name = "protection_min")
    public int getProtectionMin() {
        return protectionMin;
    }

    public void setProtectionMin(int protection_min) {
        this.protectionMin = protection_min;
    }

    @Column(name = "protection_max")
    public int getProtectionMax() {
        return protectionMax;
    }

    public void setProtectionMax(int protection_max) {
        this.protectionMax = protection_max;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "armor_type")
    public ArmorTypeEntity getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorTypeEntity armorType) {
        this.armorType = armorType;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "armor_effects", joinColumns = {
            @JoinColumn(name = "armor_id", nullable = false)
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