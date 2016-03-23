package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.EffectsEntity;

import java.util.List;

/**
 * Created by byaxe on 3/22/16.
 */
public interface IEffectsDAO {

    List<EffectsEntity> getListOfEffects();

    EffectsEntity getEffectById(final int id);
}
