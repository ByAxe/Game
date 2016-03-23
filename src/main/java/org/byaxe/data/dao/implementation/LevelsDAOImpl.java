package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.ILevelsDAO;
import org.byaxe.data.entities.creations.heroes.LevelsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LevelsDAOImpl extends GenericAbstractDAO implements ILevelsDAO {

    @Transactional
    public List<LevelsEntity> getLevelsList() {
        return entityManager.createQuery("SELECT l from LevelsEntity l",
                LevelsEntity.class).getResultList();
    }

}
