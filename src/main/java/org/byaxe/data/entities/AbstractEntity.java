package org.byaxe.data.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
