package org.byaxe.data.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericAbstractDAO {

    @PersistenceContext(unitName = "GAME_PERSISTENCE_UNIT")
    protected EntityManager entityManager;
}
