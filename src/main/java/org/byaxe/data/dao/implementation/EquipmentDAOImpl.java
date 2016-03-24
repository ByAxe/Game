package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IEquipmentDAO;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentDAOImpl extends GenericAbstractDAO implements IEquipmentDAO {

    @Override
    public List<? extends AbstractEquipmentEntity> getEquipmentList(final Class<? extends AbstractEquipmentEntity> clazz) {
        return entityManager.createQuery("SELECT eq from" +
                clazz.getName() + " eq", clazz).getResultList();
    }

    @Override
    public AbstractEquipmentEntity getEquipmentById(final int id, final Class<? extends AbstractEquipmentEntity> clazz) {
        return entityManager.createQuery("SELECT eq from" +
                clazz.getName() + " eq", clazz).getSingleResult();
    }

}
