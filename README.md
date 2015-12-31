#Simple Console Game
__________________________

##-This project is test task of one company. 

###Let's overview the structure (v0.3.8)
=======================================================================================================================

##- src/main/java |
    - abilities  - **Here is all our abilities**
        - IAbility - *interface*
        - AbstractAbility.java - *abstract class*
        - constructive  - *skills that use healing*
            - NaturePower.java
            - PlainHeal.java
        - destructive  - *skills that give the damage*
            - FireBall.java
            - FrostWave.java
            
    - aspects - **Here is the all aspects that should watch for the actions without explicit influence on the logic**
       - HeroWatcher.java
    
    - configuration - **Spring Configuration files**
        - AppConfig.java - *main configuration class*
        - SkillsAndEquipmentConfig - *a bit overloaded config, that will be solved at an early date*
        - HeroConfig.java
        - AspectConfig.java
        
    - creations - **Heroes' and Monsters' logic based here**
        - ICreation.java
        - IHero.java
        - AbstractCreation.java - *main abstract class for all creations, implements interface - ICreation*
        - AbstractHero.java - *extends AbstractCreation class*
        - AbstractMonster.java - *extends AbstractCreation class*
        - Monster.java - *implementation of all these abstract blocks for Monster*
        - Hero.java - *implementation of all these abstract blocks for Hero*
    
    - data - **Important data**
        - SystemData.java - *Information about required experience for the levels of hero*
        - TypeOfEquipment.java - *Enum type of equipment (WEAPON & ARMOR)*
        - equipment.txt  - *data on specific units of equipment*
        - texts
            - EpicText.java - *storage with epic texts*
        
    - equipment - **Equipment of the Hero and Monsters**
        - IEquipment.java - *markdown interface*
        - AbstractEquipment.java - *main abstract class in equipment' logic*
        - AbstractWeapon.java
        - AbstractArmor.java
        - armor
            - Armor.java - *implementation of all these abstract blocks for Armor*
        - weapon
            - Weapon.java - *implementation of all these abstract blocks for Weapon*
            
    - regular/expression
        - RegExp - *checker on correct values*
        
        
=======================================================================================================================
#Project logic will be described a bit later.