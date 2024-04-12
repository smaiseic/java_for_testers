package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0), new Square(3.0));

        Consumer<Square> print = (square) -> {
            Square.printSquareArea(square);
        };
        squares.forEach(print);
    }

}
