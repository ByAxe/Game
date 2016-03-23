package org.byaxe.data.entities.creations.heroes;

import org.byaxe.data.entities.AbstractEntity;

import javax.persistence.*;

/**
 * Created by byaxe on 3/21/16.
 */
@Entity
@Table(name = "points")
public class PointsEntity extends AbstractEntity {
    private int commonPoints;
    private int skillPoints;
    private HeroesEntity hero;

    public PointsEntity() {

    }

    public PointsEntity(int commonPoints, int skillPoints, HeroesEntity hero) {
        this.commonPoints = commonPoints;
        this.skillPoints = skillPoints;
        this.hero = hero;
    }

    @Column(name = "common_points")
    public int getCommonPoints() {
        return commonPoints;
    }

    public void setCommonPoints(int commonPoints) {
        this.commonPoints = commonPoints;
    }

    @Column(name = "skill_points")
    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public HeroesEntity getHero() {
        return hero;
    }

    public void setHero(HeroesEntity hero) {
        this.hero = hero;
    }
}
