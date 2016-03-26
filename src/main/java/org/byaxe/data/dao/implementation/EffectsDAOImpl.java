package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IEffectsDAO;
import org.byaxe.data.entities.EffectsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by byaxe on 3/22/16.
 */
@Repository
@Transactional
public class EffectsDAOImpl extends GenericAbstractDAO implements IEffectsDAO {

    @Override
    public List<EffectsEntity> getListOfEffects() {
        return entityManager.createQuery("SELECT e FROM EffectsEntity e",
                EffectsEntity.class).getResultList();
    }

    @Override
    public EffectsEntity getEffectById(final int id) {
        return entityManager.createQuery("SELECT e FROM EffectsEntity e WHERE id = " + id,
                EffectsEntity.class).getSingleResult();
    }
}
