package parser;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static abilities.regular.experience.RegExp.WEAPON;
import static abilities.regular.experience.RegExp.checkOnPattern;

@Component
public class MyParser {

    public Map<Integer, IEquipment> weaponTable = new TreeMap<>();
    public Map<Integer, IEquipment> armorTable = new TreeMap<>();

    @Autowired
    public Map<String, IAbility> abilityMap;

    private String fileName;

    public MyParser(String fileName) {
        this.fileName = fileName;
    }

    public void parseEquipment() {
        int charSharp;
        int numberOfCurrentWeapon = 0;
        int numberOfCurrentArmor = 0;

        TypeOfEquipment typeOfEquipment;
        IAbility ability;
        String title;
        String description;
        int requiredLevel;
        int damageOrHeal;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            do {
                charSharp = bufferedReader.read();
                if (charSharp == '#') {

                    typeOfEquipment = (checkOnPattern(bufferedReader.readLine(), WEAPON) ?  /*Will find WEAPON or ARMOR*/
                            TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR);

                    ability = findEqualsTitle(bufferedReader.readLine().replace(".", ""));  /*Will find "" or Title of the Ability*/

                    title = bufferedReader.readLine().replace(".", ""); /*Will find title of the Equipment*/

                    description = bufferedReader.readLine().replace(".", ""); /*Will find description of the Equipment*/

                    requiredLevel = Integer.parseInt(bufferedReader.readLine().replace(".", ""));

                    damageOrHeal = Integer.parseInt(bufferedReader.readLine().replace(".", ""));

                    if (typeOfEquipment == TypeOfEquipment.WEAPON) {
                        weaponTable.put(++numberOfCurrentWeapon,
                                new Weapon(typeOfEquipment, ability, title, description, requiredLevel, damageOrHeal));
                    } else {
                        armorTable.put(++numberOfCurrentArmor,
                                new Armor(typeOfEquipment, ability, title, description, requiredLevel, damageOrHeal));
                    }
                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IAbility findEqualsTitle(String info) {
        IAbility ability = null;
        for (Map.Entry<String, IAbility> entry : abilityMap.entrySet()) {
            if ((entry.getKey()).equals(info)) ability = entry.getValue();
        }
        return ability;
    }

}