package ru.stqa.geometry.figures;

public class Square {

    private double side;

    public Square(double side) {
        // cвойство объекта = параметр
        this.side = side;
    }

    public static void printSquareArea(double a) {
        System.out.println("Площадь квадрата со стороной " + a + " = " + area(a));
        String text = String.format("Площадь квадрата со стороной %f = %f", a , area(a));
        System.out.println(text);
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", a , area(a)));
    }

    public static double area(double a) {
        return a * a;
    }

    public static double perimeter(double a) {
        return 4 * a;
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
