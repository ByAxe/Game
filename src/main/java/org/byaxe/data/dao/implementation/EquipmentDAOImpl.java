package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IEquipmentDAO;
import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EquipmentDAOImpl extends GenericAbstractDAO implements IEquipmentDAO {

    @Override
    public List<ArmorEntity> getArmorList() {
        return entityManager.createQuery("SELECT a from ArmorEntity a",
                ArmorEntity.class).getResultList();
    }

    @Override
    public ArmorEntity getArmorById(final int id) {
        return entityManager.createQuery("SELECT a FROM ArmorEntity a WHERE id = " + id,
                ArmorEntity.class).getSingleResult();
    }

    @Override
    public List<WeaponEntity> getWeaponList() {
        return entityManager.createQuery("SELECT w from WeaponEntity w",
                WeaponEntity.class).getResultList();
    }

    @Override
    public WeaponEntity getWeaponById(final int id) {
        return entityManager.createQuery("SELECT a FROM WeaponEntity a WHERE id = " + id,
                WeaponEntity.class).getSingleResult();
    }

}
