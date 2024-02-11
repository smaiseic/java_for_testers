package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        var side = 8.0;
        /*
            var -- ключевое слово, для компилятора определить тип переменной на этапе компиляции
            — local variable type inference (выведение типа локальной переменной). Java 10.
            var side = 8.0; -- правильно
            ----------
            var side; -- не скомпилируется
            side = 10
            ----------
            Много ограничений и нюансов
            @TODO: почитать дополнительно
         */

        // System - класс стандартной библиотеки джава zulu-17 из пакета java.lang который хранится в модуле java.base
        // https://devdocs.io/openjdk~11
        System.out.println("Площадь квадрата со стороной " + side + " = " + (side * side));

////         Эксперименты со строками
//        System.out.println("side " + 6 + 7);
//        System.out.println("side " + (6 + 7) + 2 * 3);
//        var s = "10";
//        s = "" + 3; // строка
//        System.out.println(s);
//        s = String.valueOf(5.4);
//        System.out.println(s.getClass());


        // Методы
        Square.printSquareArea(new Square(8.0));
        Square.printSquareArea(new Square(5.0));

        Rectangle.printRectangleArea(3.0, 5.0);

    }

}
