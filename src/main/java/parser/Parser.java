package parser;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import data.TypeOfEquipment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import static abilities.regular.experience.RegExp.WEAPON;
import static abilities.regular.experience.RegExp.checkOnPattern;

public class Parser {
    /**
     * Table inside of the EnumMap:
     * 1-parameter is item' number,
     * 2-parameter is string number in the item,
     * 3-parameter is string by itself
     */
    public EnumMap<TypeOfEquipment, Map<Integer, Map<Byte, String>>> equipmentTable;
    public Table<Integer, Byte, String> tempTable = HashBasedTable.create();

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
                    numberOfCurrentEquipment++;
                    do {
                        numberOfCurrentString++;
                        info = bufferedReader.readLine();

                        if (info != null && info.compareTo("") != 0) {
                            tempTable.put(numberOfCurrentEquipment, numberOfCurrentString, info);
                        }

                    } while (info != null && info.compareTo("") != 0);

                    /*TODO Null Pointer Exception! Why?*/
                    equipmentTable.put(checkOnPattern(typeOfEquipment, WEAPON) ? TypeOfEquipment.WEAPON : TypeOfEquipment.ARMOR, tempTable.rowMap());
                }
            } while (charSharp != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}