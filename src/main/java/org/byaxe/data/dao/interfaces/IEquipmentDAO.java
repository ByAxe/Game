package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;

import java.util.List;

public interface IEquipmentDAO {

    List<? extends AbstractEquipmentEntity> getEquipmentList(
            final Class<? extends AbstractEquipmentEntity> clazz);

    AbstractEquipmentEntity getEquipmentById(
            final int id, final Class<? extends AbstractEquipmentEntity> clazz);

}
