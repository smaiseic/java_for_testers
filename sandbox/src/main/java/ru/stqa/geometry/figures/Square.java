package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double a) {
        System.out.println("Площадь квадрата со стороной " + a + " = " + sqareArea(a));
        String text = String.format("Площадь квадрата со стороной %f = %f", a , sqareArea(a));
        System.out.println(text);
        System.out.println(String.format("Площадь квадрата со стороной %f = %f", a , sqareArea(a)));
    }

    private static double sqareArea(double a) {
        return a * a;
    }
}
