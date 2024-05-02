package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {

        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));

        // строим поток объектов
        var squares = Stream.generate(randomSquare).limit(5);

        // peak -- обрабатывает объект, двигающийся по потоку -- пассивный потребитель
        // forEach -- терминальный косьюмер, который потребляет все, что осталось и дальше никакие объекты не идут
        // чтобы поток заработал, нужно чтобы в конце потока стоял активный потребитель (forEach)

        squares.peek(Square::printSquareArea).forEach(Square::printPerimeter);


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

}
