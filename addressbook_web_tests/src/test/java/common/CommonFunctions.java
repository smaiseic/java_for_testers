package common;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonFunctions {
    public static String randomStringOld(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            //('a' + rnd.nextInt(27)) -- число Ascii, rnd.nextInt(27) - число от 0 до 26 -- нужно все привести к типу char
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        return result;
    }


    public static String randomString(int n) {
        var rnd = new Random();
        Supplier<Integer> randomNumber = () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumber)
                .limit(n)
                .map(i -> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());
        return result;
    }
}
