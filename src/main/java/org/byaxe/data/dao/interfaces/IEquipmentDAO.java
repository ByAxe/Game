package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;

import java.util.List;

public interface IEquipmentDAO {

    List<ArmorEntity> getArmorList();

    ArmorEntity getArmorById(final int id);

    List<WeaponEntity> getWeaponList();

    WeaponEntity getWeaponById(final int id);

}
