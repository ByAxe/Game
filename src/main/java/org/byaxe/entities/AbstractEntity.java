package org.byaxe.entities;

import javax.persistence.*;

/**
 * Created by byaxe on 3/13/16.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
