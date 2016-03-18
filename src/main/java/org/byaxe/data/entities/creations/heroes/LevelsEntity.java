package org.byaxe.data.entities.creations.heroes;

import org.byaxe.data.entities.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class LevelsEntity extends AbstractEntity {
    private long requiredExperience;

    @Basic
    @Column(name = "required_experience", nullable = false)
    public long getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(long requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LevelsEntity that = (LevelsEntity) o;

        if (requiredExperience != that.requiredExperience) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (requiredExperience ^ (requiredExperience >>> 32));
    }
}
