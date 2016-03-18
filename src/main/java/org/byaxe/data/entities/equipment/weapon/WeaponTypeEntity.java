package org.byaxe.data.entities.equipment.weapon;

import org.byaxe.data.entities.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "weapon_type")
public class WeaponTypeEntity extends AbstractEntity {
    private String weaponType;
    private List<WeaponEntity> weaponList = new ArrayList<>();

    @OneToMany
    public List<WeaponEntity> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<WeaponEntity> weaponList) {
        this.weaponList = weaponList;
    }

    @Column(name = "weapon_type")
    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
