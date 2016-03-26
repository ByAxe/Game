package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.creations.monsters.MonstersEntity;

import java.util.List;

/**
 * Created by byaxe on 3/21/16.
 */
public interface IMonsterDAO {
    List<MonstersEntity> getMonstersList();

    MonstersEntity getMonsterById(final int id);
}
