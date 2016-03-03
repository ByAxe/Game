# Console Game

## -This project is test task of one company.
### --Upd. Now it is my course work 

### Let's overview the structure (v0.4.2)
============================================================================================

##- src/main/java |
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
        - equipment.txt  - *data on specific units of equipment*
        - monsters.txt - *data on specific units of monsters*
        - texts
            - Introduction.java - *introduction text*
            - FirstMeeting.java
            - InventoryInformation.java - *Include methods that output information about hero*
        
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
        
        
=======================================================================================================================
#Project logic will be described a bit later.