package ru.stqa.geometry.figures;

// record (сокращенная нотация)-- Java 14 -- пошло из прошлого из профессии оператора баз данных,
// когда анкету заполняли рукой на бумаге, а оператор потом вносил в базу данных
// из каждой анкеты создавалась запись (рекорд) в базе данных.
// cвойста полей называют полями, в честь тех самых полей в бумажных анкетах

public record Rectangle(double a, double b) {
    // static -- глобальный метод, var нельзя использовать в объявлении параметров функции
    // отсутствие модификатора доступа -- функция доступна в пределах пакета
    // private -- в пределах класса
    // public -- отовсюду

//    заменяется нотацией record
//    private double a;
//    private double b;
//
//    public Rectangle(double a, double b) {
//        this.a = a;
//        this.b = b;
//    }


    public static void printRectangleArea(double a, double b) {
        //System.out.println("Площадь квадрата со сторонами " + a + " и " + b + " = " + rectangleArea(a, b));
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectangleArea(a, b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }
}
