package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.ISkillsDAO;
import org.byaxe.data.entities.SkillsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by byaxe on 3/22/16.
 */
@Repository
@Transactional
public class SkillsDAOImpl extends GenericAbstractDAO implements ISkillsDAO{

    @Override
    public List<SkillsEntity> getListOfSkills() {
        return entityManager.createQuery("SELECT s FROM SkillsEntity s",
                SkillsEntity.class).getResultList();
    }

    @Override
    public SkillsEntity getSkillById(int id) {
        return entityManager.createQuery("SELECT s FROM SkillsEntity s",
                SkillsEntity.class).getSingleResult();
    }
}
