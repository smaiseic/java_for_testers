package ru.stqa.geometry.figures;

public record Square(double side) {

    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }
    public static void printSquareArea(Square square) {
        String text = String.format("Площадь квадрата со стороной %f = %f", square.side , square.area());
        System.out.println(text);
    }

    public static void printPerimeter(Square square) {
        System.out.println(String.format("Периметр квадрата со стороной %f = %f", square.side, square.side * 2));
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
