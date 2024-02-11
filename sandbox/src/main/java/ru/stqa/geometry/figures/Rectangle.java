package ru.stqa.geometry.figures;

public class Rectangle {
    // static -- глобальный метод, var нельзя использовать в объявлении параметров функции
    // отсутствие модификатора доступа -- функция доступна в пределах пакета
    // private -- в пределах класса
    // public -- отовсюду
    public static void printRectangleArea(double a, double b) {
        //System.out.println("Площадь квадрата со сторонами " + a + " и " + b + " = " + rectangleArea(a, b));
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectangleArea(a, b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }
}
