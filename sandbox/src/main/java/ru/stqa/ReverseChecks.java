package ru.stqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReverseChecks {

    @Test
    void testSqrt() {
        var input = 5.0;

        var result = Math.sqrt(input);
        var revers = result * result;
        Assertions.assertEquals(input, revers, 0.000001);
    }

    @Test
    void testSort() {
        var input = new ArrayList<>(List.of(3, 7, 4, 9, 0));
        input.sort(Integer::compareTo);
        Assertions.assertEquals(List.of(0, 3, 4, 7, 9), input);
        for (int i = 0; i < input.size() - 1; i++) {
            Assertions.assertTrue(input.get(i) <= input.get(i + 1));
        }
    }

    @Test
    void testMap() {
        var map = new HashMap<Character, String>();
        map.put('1', "one");
        map.put('2', "two");
        System.out.println(map.get('2'));
    }
}
