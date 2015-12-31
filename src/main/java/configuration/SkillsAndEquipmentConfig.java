package configuration;

import abilities.IAbility;
import abilities.skills.constructive.NaturePower;
import abilities.skills.constructive.PlainHeal;
import abilities.skills.destructive.FireBall;
import abilities.skills.destructive.FrostWave;
import data.SystemData;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static regular.expression.RegExp.WEAPON;
import static regular.expression.RegExp.checkOnPattern;

@Configuration
public class SkillsAndEquipmentConfig {

    @Autowired
    @Qualifier("weaponMap")
    public TreeMap<Integer, IEquipment> weaponTable;

    @Autowired
    @Qualifier("armorMap")
    public TreeMap<Integer, IEquipment> armorTable;

    private int charSharp;
    private int numberOfCurrentEquipment = 0;
    private TypeOfEquipment typeOfEquipment;
    private IAbility ability;
    private String title;
    private String description;
    private int requiredLevel;
    private int damageOrHeal;
    private String fileName;

    @Bean
    public SystemData systemData() {
        SystemData sd = new SystemData();
        sd.fillMap();
        return sd;
    }

    @Bean
    public FireBall fireBall() {
        return new FireBall("Fire Ball",
                "Fire ball can cause a lot of damage to the enemy.",
                0, 20, (byte) 3, 20);
    }

    @Bean
    public FrostWave frostWave() {
        return new FrostWave("Frost Wave",
                "Frost wave is very dangerous magic. Use it only if it necessary.",
                0, 100, (byte) 8, 50);
    }

    @Bean
    public NaturePower naturePower() {
        return new NaturePower("Nature Power",
                "Take these power of the Nature and let it pass throughout your body.",
                60, 0, (byte) 5, 30);
    }

    @Bean
    public PlainHeal plainHeal() {
        return new PlainHeal("Plain Heal",
                "It's just a plain healing magic that everybody knows.",
                20, 0, (byte) 1, 10);
    }

    /*TODO transport Beans above in another Configuration file*/

    @Bean(name = "abilityMap")
    public HashMap<String, IAbility> abilityMap() {
        HashMap<String, IAbility> abilityMap = new HashMap<>();

        abilityMap.put(fireBall().getDescription(), fireBall());
        abilityMap.put(frostWave().getDescription(), frostWave());
        abilityMap.put(naturePower().getDescription(), naturePower());
        abilityMap.put(plainHeal().getDescription(), plainHeal());

        return abilityMap;
    }

    @Bean
    @DependsOn("weaponMap")
    public Weapon firstWeapon() {
        Weapon weapon = (Weapon) weaponTable.get(1);
        return weapon;
    }

    @Bean
    @DependsOn("armorMap")
    public Armor firstArmor() {
        Armor armor = (Armor) armorTable.get(1);
        return armor;
    }

    @Bean(name = "weaponMap")
    @DependsOn("abilityMap")
    public TreeMap<Integer, IEquipment> parseWeapon() {
        Path relativePath = Paths.get("src/main/java/data", "equipment.txt");
        this.fileName = relativePath.toString();

        TreeMap<Integer, IEquipment> weaponTable = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            do {
                charSharp = bufferedReader.read();
                if (charSharp == '#') {

                    typeOfEquipment = (checkOnPattern(bufferedReader.readLine(), WEAPON) ?  /*Will find WEAPON or ARMOR*/
                            TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR);
                    if (typeOfEquipment == TypeOfEquipment.ARMOR) continue;

                    ability = findEqualsTitle(bufferedReader.readLine().replace(".", ""));  /*Will find "" or Title of the Ability*/
                    title = bufferedReader.readLine().replace(".", ""); /*Will find title of the Equipment*/
                    description = bufferedReader.readLine().replace(".", ""); /*Will find description of the Equipment*/
                    requiredLevel = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    damageOrHeal = Integer.parseInt(bufferedReader.readLine().replace(".", ""));

                    weaponTable.put(++numberOfCurrentEquipment,
                            new Weapon(typeOfEquipment, ability, title, description, requiredLevel, damageOrHeal));

                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        numberOfCurrentEquipment = 0;
        return weaponTable;
    }

    @Bean(name = "armorMap")
    @DependsOn("abilityMap")

    public TreeMap<Integer, IEquipment> parseArmor() {

        TreeMap<Integer, IEquipment> armorTable = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            do {
                charSharp = bufferedReader.read();
                if (charSharp == '#') {

                    typeOfEquipment = (checkOnPattern(bufferedReader.readLine(), WEAPON) ?  /*Will find WEAPON or ARMOR*/
                            TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR);

                    if (typeOfEquipment == TypeOfEquipment.WEAPON) continue;

                    ability = findEqualsTitle(bufferedReader.readLine().replace(".", ""));  /*Will find "" or Title of the Ability*/
                    title = bufferedReader.readLine().replace(".", ""); /*Will find title of the Equipment*/
                    description = bufferedReader.readLine().replace(".", ""); /*Will find description of the Equipment*/
                    requiredLevel = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    damageOrHeal = Integer.parseInt(bufferedReader.readLine().replace(".", ""));

                    armorTable.put(++numberOfCurrentEquipment,
                            new Armor(typeOfEquipment, ability, title, description, requiredLevel, damageOrHeal));

                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        numberOfCurrentEquipment = 0;
        return armorTable;

    }

    public IAbility findEqualsTitle(String info) {
        IAbility ability = null;
        for (Map.Entry<String, IAbility> entry : abilityMap().entrySet()) {
            if ((entry.getKey()).equals(info)) ability = entry.getValue();
        }
        return ability;
    }
}