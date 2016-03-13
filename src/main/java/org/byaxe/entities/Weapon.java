package org.byaxe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by byaxe on 3/13/16.
 */
@Entity
@Table(name = "weapon")
public class Weapon extends AbstractEntity {

    private String title;
    private String description;
    private int requiredLevel;
    private int damageMin;
    private int damageMax;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "required_level")
    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int required_level) {
        this.requiredLevel = required_level;
    }

    @Column(name = "damage_min")
    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    @Column(name = "damage_max")
    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }
}
