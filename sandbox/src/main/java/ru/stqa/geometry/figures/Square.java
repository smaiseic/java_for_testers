package ru.stqa.geometry.figures;

public record Square(double side) {
//
//    private double side;
//
//    public Square(double side) {
//        // cвойство объекта = параметр
//        this.side = side;
//    }

    public static void printSquareArea(Square square) {
        String text = String.format("Площадь квадрата со стороной %f = %f", square.side , square.area());
        System.out.println(text);
    }

    public static double area(double a) {
        return a * a;
    }

    // нет слова статик
    // static означает что метод вызывается у саомого класса, а значения передаются через параметры
    // данные берутся не из параметров функции а из самого созданного объекта
    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
