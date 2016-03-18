# Console Game

* This project was the test task from SC.

### Let's overview the structure (v0.4.3)
---

##### - src/main/java/org
- java
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
        - HeroConfig.java - **creates the hero into Spring context
        - MonsterConfig.java
        - AspectConfig.java
        
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
            
        - entities *Database maping*
            - creations
                - heroes
                    - HeroesEntity.java
                    - LevelsEntity.java
                    - ParametersEntity.java
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
            
    - equipment - **Equipment of the Hero and Monsters**
        - IEquipment.java - *interface that contains approximately all necessary methods for Equipment*
        - abstractLevel
            - AbstractEquipment.java - *main abstract class in equipment' logic*
            - AbstractWeapon.java
            - AbstractArmor.java
        - implementLevel
            - Armor.java - *implementation of all these abstract blocks for Armor*
            - Weapon.java - *implementation of all these abstract blocks for Weapon*
            
    - regular/expression
        - RegExp - *checker on correct values*
- resources
      - equipment.txt  - *data on specific units of equipment*
      - monsters.txt - *data on specific units of monsters*
      - hibernate-config.xml - *hibernate configuration file*
      - persistence.xml - *preferences for db-connection*
# DataBase Scheme
 * Since 0.4.2.x I have started to use PostgreSQL instead of plenty txt files for application purposes.
 * PostrgreSQL version: 9.5.1
 
[Here is a scheme of that database](DBScheme.png)
 
(*to make this image I used trial version of DBSchema*)

# !Explanation for the mess in project
* As I marked above project relocates from *.txt and class information-based application
     into Spring+Hibernate DB one.
* What have been done for now is:
    * created database
    * it was filled with the test data
    * created basic mapping files (entities) 
    
# Plans for the next few commits
* *Create DAO layer*
* *Delete a useless classes a clean the project*
          
# Project logic will be described a bit later
