package common;

import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            //('a' + rnd.nextInt(27)) -- число Ascii, rnd.nextInt(27) - число от 0 до 26 -- нужно все привести к типу char
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }
}
