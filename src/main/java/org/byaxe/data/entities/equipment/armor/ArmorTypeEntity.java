package org.byaxe.data.entities.equipment.armor;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "armor_type")
public class ArmorTypeEntity extends AbstractEntity {
    private String armorType;
    private List<ArmorEntity> armorList = new ArrayList<>();

    @OneToMany
    public List<ArmorEntity> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<ArmorEntity> armorList) {
        this.armorList = armorList;
    }

    @Column(name = "armor_type")
    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }
}
