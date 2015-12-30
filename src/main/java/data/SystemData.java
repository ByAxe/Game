package data;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class SystemData {

    public static final byte MIN_RANDOM = -5;
    public static final byte MAX_RANDOM = 5;
    public static final double PERFORMANCE_FACTOR = 0.1;

    /*TODO I not sure that the Map will be filled by the fillMap() method when the program begins*/
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
