package parser;

import data.TypeOfEquipment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static abilities.regular.experience.RegExp.WEAPON;
import static abilities.regular.experience.RegExp.checkOnPattern;

public class Parser {
    /**
     * Table inside of the EnumMap:
     * 1-parameter(Integer) is item' number,
     * 2-parameter(Byte) is string number in the item,
     * 3-parameter(String) is string by itself
     */
    public Map<TypeOfEquipment, Object> equipmentTable = new EnumMap<>(TypeOfEquipment.class);
    public Map<Integer, Object> row = new HashMap<>();
    public Map<Byte, String> column = new HashMap<>();

    private String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public void parsing() {
        int charSharp;
        int charDot;
        int numberOfCurrentEquipment = 0;
        byte numberOfCurrentString = 0;
        String typeOfEquipment;
        String info;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            do {
                charSharp = bufferedReader.read();
                if (charSharp == '#') {
                    typeOfEquipment = bufferedReader.readLine(); /*Will find WEAPON or ARMOR*/
                    ++numberOfCurrentEquipment;
                    do {
                        ++numberOfCurrentString;
                        info = bufferedReader.readLine();

                        if (info != null && info.compareTo("") != 0) {
//                            info = info.replace(".", "");
                            row.put(numberOfCurrentEquipment, column.put(numberOfCurrentString, info));
                        }

                    } while (info != null && info.compareTo("") != 0);
                    numberOfCurrentString = 0;

                    equipmentTable.put(checkOnPattern(typeOfEquipment, WEAPON) ?
                            TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR, row);
                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}