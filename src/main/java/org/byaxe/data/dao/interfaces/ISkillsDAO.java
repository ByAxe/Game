package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.SkillsEntity;

import java.util.List;

/**
 * Created by byaxe on 3/22/16.
 */
public interface ISkillsDAO {
    List<SkillsEntity> getListOfSkills();

    SkillsEntity getSkillById(final int id);
}
