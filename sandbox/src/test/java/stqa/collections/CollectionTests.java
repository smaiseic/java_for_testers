package stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        //размер массива изменить после создания нельзя
        var array = new String[]{"a", "b", "c"};
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);

        var array2 = new String[3];
        Assertions.assertEquals(3, array.length);
    }

    @Test
    void listTests() {
        //в стандартной библиотеки есть несколько реализаций списка и ArrayList внутри себя работает с массивами
        var list = new ArrayList<String>();
        Assertions.assertEquals(0, list.size());

        list.add("d");
        list.add("b");
        Assertions.assertEquals(2, list.size());

        list.add("c");
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("c", list.get(2));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));
        list.add(1,"f");
        System.out.println(list.toString());

        // для инициализации списка можно использовать List.of(значения списка)
        // но такой список является неизменяемым
        var listImmutable = List.of("a", "b", "c"); // << immutable
        var list2 = new ArrayList<>(listImmutable);
        Assertions.assertEquals(3, list2.size());
    }
}
