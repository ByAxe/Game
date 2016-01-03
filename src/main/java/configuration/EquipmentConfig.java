package configuration;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.implementLevel.Armor;
import equipment.implementLevel.Weapon;
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
import java.util.Map;
import java.util.TreeMap;

import static regular.expression.RegExp.*;

@Configuration
public class EquipmentConfig {

    @Autowired
    @Qualifier("weaponParser")
    public TreeMap<Integer, IEquipment> weaponTable;

    @Autowired
    @Qualifier("armorParser")
    public TreeMap<Integer, IEquipment> armorTable;

    private Path relativePath = Paths.get("src/main/java/data", "equipment.txt");
    private String fileName = relativePath.toString();

    private TypeOfEquipment typeOfEquipment;
    private IAbility ability;
    private int charSharp;
    private int numberOfCurrentEquipment = 0;
    private String title;
    private String description;
    private int requiredLevel;
    private int damageOrHeal;

    @Bean(name = "firstWeapon")
    @DependsOn("weaponParser")
    public Weapon firstWeapon() {
        return (Weapon) weaponTable.get(1);
    }

    @Bean(name = "firstArmor")
    @DependsOn("armorParser")
    public Armor firstArmor() {
        return (Armor) armorTable.get(1);
    }


    @Bean(name = "weaponParser")
    @DependsOn("abilityMap")
    public TreeMap<Integer, IEquipment> weaponParser() {

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

                    weaponTable.put(requiredLevel,
                            new Weapon(typeOfEquipment, ability, title, description, requiredLevel, damageOrHeal));

                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        numberOfCurrentEquipment = 0;
        return weaponTable;
    }

    @Bean(name = "armorParser")
    @DependsOn("abilityMap")

    public TreeMap<Integer, IEquipment> armorParser() {

        TreeMap<Integer, IEquipment> armorTable = new TreeMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            do {
                charSharp = bufferedReader.read();
                if (charSharp == '#') {

                    typeOfEquipment = (checkOnPattern(bufferedReader.readLine(), ARMOR) ?  /*Will find WEAPON or ARMOR*/
                            TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR);

                    if (typeOfEquipment == TypeOfEquipment.WEAPON) continue;

                    ability = findEqualsTitle(bufferedReader.readLine().replace(".", ""));  /*Will find "" or Title of the Ability*/
                    title = bufferedReader.readLine().replace(".", ""); /*Will find title of the Equipment*/
                    description = bufferedReader.readLine().replace(".", ""); /*Will find description of the Equipment*/
                    requiredLevel = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    damageOrHeal = Integer.parseInt(bufferedReader.readLine().replace(".", ""));

                    armorTable.put(requiredLevel,
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
        for (Map.Entry<String, IAbility> entry : (new AbilityConfig()).abilityMap().entrySet()) {
            if ((entry.getKey()).equals(info)) ability = entry.getValue();
        }
        return ability;
    }
}