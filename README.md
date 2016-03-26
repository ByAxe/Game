# Console Game

* ~~This project is the test task from SC~~.
* My current course-work

### Let's overview the structure (v0.4.6)
---

##### - src/main/
- java/org/byaxe/
    - Game.java - main method based here
    - Cycle.java - contains the main cycle of choices 
    
    - aspects/ - **Here is the all aspects that should watch for the actions without explicit influence on the logic**
        - BattleWatcher.java - **Looks for the battle and hero moves**
        - InventoryWatcher.java - **Looks for the hero's inventory**
        - HeroMovesWatcher.java - **Looks for the hero's movement**
    
    - configuration/ - **Spring Configuration files**
        - AppConfig.java - **main configuration class**
        - AspectConfig.java
        - DaoConfig.java
        - HeroConfig.java - **Creates hero bean**
        - JpaConfig.java - **Hibernate Jpa configuration for DB**
    
    - data/ - **Important data**
        - SystemData.java - **Data class that contains a lot of information and common variables**
        - texts/
            - Introduction.java - **Introduction text**
            - FirstMeeting.java
            - InventoryInformation.java - **Include methods that output information about hero**
        - dao/ - **Dao files\***
            - implementation/
                - EffectsDAOImpl.java
                - EquipmentDAO.java
                - HeroDAOImpl.java
                - LevelsDAOImpl.java
                - MonsterDAOImpl.java
                - SkillsDAOImpl.java
            - interfaces/
                - IEffectsDAO.java
                - IEquipmentDAO.java
                - IHeroDAO.java
                - ILevelsDAO.java
                - IMonsterDAO.java
                - ISkillsDAO.java
            GenericAbstractDAO.java
            
        - entities/ - **Database maping**
            - creations/ - **Heroes and Mosters entities is here**
                - heroes/
                    - HeroesEntity.java
                    - LevelsEntity.java
                    - ParametersEntity.java
                    - PointsEntity.java
                - monsters/
                    - MonstersEntity.java
            - equipment/ - **Equipment entities is here**
                - armor/
                    - ArmorEntity.java
                    - ArmorTypeEntity.java
                - weapon/
                    - WeaponEntity.java
                    - WeaponTypeEntity.java
                - AbstractEquipmentEntity.java - *Contains common columns for Weapon & Armor*
                - RarityEntity.java
            - AbstractEntity.java - **Abstract layer that contains id**
            - EffectsEntity.java
            - SkillsEntity.java
            - TextsEntity.java
            
    - regular/expression/
        - RegExp - **Regular expression class**
        
    - exceptions/ - **My own Exception classification for Game purposes**
        - AlreadyContainsException.java
        - NotContainsException.java
        - WeakHeroException.java
        - LowParametersException.java - **Descendant of WeakHeroException**
        - NotEnoughLevelException.java - **Descendant of WeakHeroException**
        
    - logic/ - **Logical operations with entities**
        - implementation/
            - HeroBusinessLogicImpl.java
            - MonsterBusinessLogicImpl.java
        - interface/
            - IHeroBusinessLogic.java
            - IMonsterBusinessLogic.java
        
- resources/
      - persistence.xml - **preferences for db-connection**
      
# DataBase Scheme
 * Since 0.4.2.x I have started to use PostgreSQL instead of plenty txt files for application purposes.
 * PostrgreSQL version: 9.5.1
 
[Here is a scheme of that database](DBScheme.png)
 
> *to make this image I used trial version of DBSchema*

# Explanation for the mess in project
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
    2. Classes in *exceptions* package named in according to the rule:
        2.1 Class title + Exception
    3. Classes in *enities* package named in according to the rule:
        3.1 Class title + Entity
    4. Classes in *configuration* package named in according to the rule:
        4.1 Class title + Config
    5. Classes in *aspects* package named in according to the rule:
        5.1 Class title + Watcher