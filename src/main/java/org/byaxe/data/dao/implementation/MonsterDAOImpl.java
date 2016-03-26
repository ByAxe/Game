package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IMonsterDAO;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by byaxe on 3/21/16.
 */
@Repository
public class MonsterDAOImpl extends GenericAbstractDAO implements IMonsterDAO {

    @Override
    public List<MonstersEntity> getMonstersList() {
        return entityManager.createQuery("SELECT m from MonstersEntity m",
                MonstersEntity.class).getResultList();
    }

    @Override
    public MonstersEntity getMonsterById(final int id) {
        return entityManager.createQuery("SELECT m from MonstersEntity m WHERE id = " + id,
                MonstersEntity.class).getSingleResult();
    }
}
