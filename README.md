#Simple Console Game
__________________________

##-This project is test task of one company. 

###Let's overview the structure (v0.4.0)
=======================================================================================================================

##- src/main/java |
    - Game.java - main method based here

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
       - BattleWatcher.java
    
    - configuration - **Spring Configuration files**
        - AppConfig.java - *main configuration class*
        - AbilityConfig.java
        - EquipmentConfig.java
        - HeroConfig.java
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
        - SystemData.java - *Information about required experience for hero levels*
        - TypeOfEquipment.java - *Enum type of equipment (WEAPON & ARMOR)*
        - equipment.txt  - *data on specific units of equipment*
        - monsters.txt - *data on specific units of monsters*
        - texts
            - Introduction.java
            - FirstMeeting.java
        
    - equipment - **Equipment of the Hero and Monsters**
        - IEquipment.java - *markdown interface*
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