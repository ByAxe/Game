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
import org.springframework.context.annotation.Lazy;

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

}