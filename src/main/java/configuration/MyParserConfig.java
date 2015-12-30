package configuration;

import abilities.IAbility;
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

import static abilities.regular.experience.RegExp.WEAPON;
import static abilities.regular.experience.RegExp.checkOnPattern;

@Configuration
public class MyParserConfig {

    @Autowired
    @Qualifier("weaponMap")
    public TreeMap<Integer, IEquipment> weaponTable;
    @Autowired
    @Qualifier("armorMap")
    public TreeMap<Integer, IEquipment> armorTable;

    @Autowired
    @Qualifier("abilityMap")
    public HashMap<String, IAbility> abilityMap;

    private int charSharp;
    private int numberOfCurrentEquipment = 0;
    private TypeOfEquipment typeOfEquipment;
    private IAbility ability;
    private String title;
    private String description;
    private int requiredLevel;
    private int damageOrHeal;
    private String fileName;

    public MyParserConfig() {
    }

/*
    @Autowired
    public MyParser(String fileName) {
        this.fileName = fileName;
    }
*/

    @Bean(name = "weaponMap")
    @DependsOn("abilityMap")
    public TreeMap<Integer, IEquipment> parseWeapon() {
        Path relativePath = Paths.get("src/main/java/equipment", "equipment.txt");
        fileName = relativePath.toString();

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


    /*TODO Null Pointer Exception - abilityMap is empty! WHY?*/
    public IAbility findEqualsTitle(String info) {
        IAbility ability = null;
        for (Map.Entry<String, IAbility> entry : abilityMap.entrySet()) {
            if ((entry.getKey()).equals(info)) ability = entry.getValue();
        }
        return ability;
    }

}