# Console Game

* ~~This project is the test task from SC.
* My current course-work

### Let's overview the structure (v0.4.4)
---

##### - src/main/
- java/org/byaxe
    - Game.java - main method based here
    - Cycle.java - contains the main cycle of choices 

    - abilities  - **Here is all our abilities**
        - IAbility - *interface*
        - abstractLevel
            - AbstractAbility.java - *abstract class*
        - implementLevel
            - constructive  - *skills that use healing*
                - NaturePower.java
                - PlainHeal.java
            - destructive  - *skills that give the damage*
                - FireBall.java
                - FrostWave.java
            
    - aspects - **Here is the all aspects that should watch for the actions without explicit influence on the logic**
       - BattleWatcher.java - **Looks for the battle and hero moves**
       - InventoryWatcher.java - **Looks for the hero's inventory**
       - HeroMovesWatcher.java - **Looks for the hero's movement**
    
    - configuration - **Spring Configuration files**
        - AppConfig.java - *main configuration class*
        - AbilityConfig.java
        - EquipmentConfig.java
        - HeroConfig.java - *creates the hero into Spring context*
        - MonsterConfig.java
        - AspectConfig.java
        - DaoConfig.java
        - JpaConfig.java - **Hibernate Jpa configuration for DB**
        
    - creations - **Heroes' and Monsters' logic based here**
        - ICreation.java
        - abstractLevel
            - AbstractCreation.java - *main abstract class for all creations, implements interface - ICreation*
            - AbstractHero.java - *extends AbstractCreation class*
            - AbstractMonster.java - *extends AbstractCreation class*
        - implementLevel
            - Monster.java - *implementation of all these abstract blocks for Monster*
            - Hero.java - *implementation of all these abstract blocks for Hero*
    
    - data - **Important data**
        - SystemData.java - *Data class that contains a lot of information and common variables*
        - TypeOfEquipment.java - *Enum type of equipment (WEAPON & ARMOR)*
        - texts
            - Introduction.java - *introduction text*
            - FirstMeeting.java
            - InventoryInformation.java - *Include methods that output information about hero*
        - dao **Dao files\***
            - implementation
                - EffectsDAOImpl.java
                - EquipmentDAO.java
                - HeroDAOImpl.java
                - LevelsDAOImpl.java
                - MonsterDAOImpl.java
                - SkillsDAOImpl.java
            - interfaces
                - IEffectsDAO.java
                - IEquipmentDAO.java
                - IHeroDAO.java
                - ILevelsDAO.java
                - IMonsterDAO.java
                - ISkillsDAO.java
            GenericAbstractDAO.java
            
        - entities *Database maping*
            - creations
                - heroes
                    - HeroesEntity.java
                    - LevelsEntity.java
                    - ParametersEntity.java
                    - PointsEntity.java
                - monsters
                    - MonstersEntity.java
            - equipment
                - armor
                    - ArmorEntity.java
                    - ArmorTypeEntity.java
                - weapon
                    - WeaponEntity.java
                    - WeaponTypeEntity.java
                - AbstractEquipmentEntity.java - *Contains common columns for Weapon & Armor*
                - RarityEntity.java
            - AbstractEntity.java - *Abstract layer that contains id*
            - EffectsEntity.java
            - SkillsEntity.java
            - TextsEntity.java
            
    - regular/expression
        - RegExp - *checker on correct values*
        
    - exceptions
        - AlreadyContainsException.java
        - NotContainsException.java
        
- resources
      - equipment.txt  - *data on specific units of equipment*
      - monsters.txt - *data on specific units of monsters*
      - persistence.xml - *preferences for db-connection*
      
# DataBase Scheme
 * Since 0.4.2.x I have started to use PostgreSQL instead of plenty txt files for application purposes.
 * PostrgreSQL version: 9.5.1
 
[Here is a scheme of that database](DBScheme.png)
 
> *to make this image I used trial version of DBSchema*

# !Explanation for the mess in project
> 1. As I marked above project relocates from *.txt and class information-based application
     into Spring+Hibernate DB one.
  2. What have been done for now is:
    - created database
    - it was filled with the test data
    - created basic mapping files (entities)
    
# Plans for the next few commits
- [x] Create DAO layer
- [ ] Delete a useless classes a clean the project
          
# Project logic will be described a bit later

# Naming rules
    1. Classes in *dao* package named in according to the rules below:
        1.1 interfaces -> I + Class title + DAO
        1.2 implementation -> Class title + DAO + Impl
