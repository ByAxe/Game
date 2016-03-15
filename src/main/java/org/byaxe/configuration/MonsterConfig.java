package org.byaxe.configuration;

import org.byaxe.creations.ICreation;
import org.byaxe.creations.implementLevel.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import static org.byaxe.data.SystemData.FILE_MONSTERS;

@Configuration
public class MonsterConfig {

    @Bean(name = "monstersParser")
    public TreeMap<Integer, ICreation> monstersParser() {
        TreeMap<Integer, ICreation> monstersTable = new TreeMap<>();

        int charSharp;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_MONSTERS))) {
            do {
                charSharp = bufferedReader.read();

                if (charSharp == '#') {
                    String name = bufferedReader.readLine();
                    int id = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    byte level = Byte.parseByte(bufferedReader.readLine().replace(".", ""));
                    int MP = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    int HP = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    int agility = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    int strength = Integer.parseInt(bufferedReader.readLine().replace(".", ""));
                    String description = bufferedReader.readLine().replace(".", "");

                    monstersTable.put(id, new Monster(null, name, level, MP, HP, agility, strength, description));
                }

            } while (charSharp != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return monstersTable;
    }
}