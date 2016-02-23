package data;

import creations.ICreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.TreeMap;

@Component
public class SystemData {

    public static final double PERFORMANCE_FACTOR = 0.1;

    public static final byte MIN_RANDOM_DAMAGE = -5;
    public static final byte MAX_RANDOM_DAMAGE = 5;

    public static final byte MIN_RAND_LEVEL_LOW = -1;
    public static final byte MAX_RAND_LEVEL_LOW = 1;

    public static final byte MIN_RAND_LEVEL_HIGH = -2;
    public static final byte MAX_RAND_LEVEL_HIGH = 2;

    public static final byte MIN_LEVEL = 1;
    public static final byte MAX_LEVEL = 10;

    @Autowired
    @Qualifier("monstersParser")
    public TreeMap<Integer, ICreation> monstersTable; /*TODO I get here - null!*/

    @Autowired
    @Qualifier("experienceTable")
    private HashMap<Byte, Integer> requiredExperience; /*TODO I get here - null!*/

    public static int randomDistribution() {
        return MIN_RANDOM_DAMAGE + (int) (Math.random() * ((MAX_RANDOM_DAMAGE - MIN_RANDOM_DAMAGE) + 1));
    }

    public Integer getRequiredExperience(Byte level) {
        return requiredExperience.get(level);
    }
}
