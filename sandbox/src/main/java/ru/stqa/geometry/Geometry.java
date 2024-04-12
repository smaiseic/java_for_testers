package ru.stqa.geometry;

import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0), new Square(3.0));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }

        // Выделяют 3 типа функций:
        // Сonsumer (принимает на вход параметр, но ничего не возвращает)
        // Producer (ничего на вход не принимает, но что-то возвращаетж; как-то генерирует данные)
        // Function (что-то принимает и что-то возвращает, т.е. у нее есть и вход и выход;
        //      трансформирует данные, которые в нее передают)

//        Consumer<Square> print = (square) -> {
//            Square.printSquareArea(square);
//        };

        // (параметры) но можно скобки не ставить, если параметр один
//        Consumer<Square> print = (square) -> {
//            Square.printSquareArea(square);
//        };

//        Consumer<Square> print = square -> {
//            Square.printSquareArea(square);
//        };


        Consumer<Square> print = (square) -> {
            Square.printSquareArea(square);
        };
        squares.forEach(print);

        squares.forEach(Square::printSquareArea);;

//        Rectangle.printRectangleArea(3.0, 5.0);
//
//        Triangle.printTriangleArea(new Triangle(2.0, 4.0, 5.0));
//        Triangle.printTriangleArea(new Triangle(4.0, 2.0, 9.0));
//
//        Triangle.printTrianglePerimeter(new Triangle(4.0, 2.0, 5.0));
    }

}
