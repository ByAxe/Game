package data;

import org.springframework.stereotype.Component;

import java.util.Map;
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

    private Map<Byte, Integer> requiredExperience;

    public void fillMap() {
        requiredExperience = new TreeMap<>();
        for (byte i = 1; i <= 10; i++) {
            requiredExperience.put(i, i * 100);
        }
    }

    public Map<Byte, Integer> getRequiredExperience() {
        return requiredExperience;
    }
}
