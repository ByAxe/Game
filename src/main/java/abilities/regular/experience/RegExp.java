package abilities.regular.experience;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static final String ANSWER = "([Yy][Ee][Ss])|([Nn][Oo])";
    public static final String YES = "([Yy][Ee][Ss])";
    public static final String NUMERIC = "[0-9]+";
    public static final String WEAPON = "(WEAPON)\\s*";
    public static final String NAME = "^[a-zA-Z]{3,15}$";

    public static Scanner scan = new Scanner(System.in);

    public static boolean checkOnPattern(String testString, String requiredPattern) {
        Pattern p = Pattern.compile(requiredPattern);
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static String checkOnCorrectValue(String message, String requiredPattern) {
        String testString;

        while (true) {
            System.out.print(message);
            testString = scan.next();
            if (!checkOnPattern(testString, requiredPattern)) {
                System.out.println("\nYou've been entered incorrect value.\n\tTry it again, please.");
                testString = null;
            } else return testString;
        }
    }
}
