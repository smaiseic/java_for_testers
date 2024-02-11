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

        System.out.println("Площадь квадрата со стороной " + side + " = " + (side * side));

        // Эксперименты со строками
        System.out.println("side " + 6 + 7);
        System.out.println("side " + (6 + 7) + 2 * 3);
        var s = "10";
        s = "" + 3; // строка
        System.out.println(s);
        s = String.valueOf(5.4);
        System.out.println(s.getClass());


        // Методы
        printSquareArea(100);
        printRectangleArea(3.0, 5.0);
    }

    // static -- глобальный метод, var нельзя использовать в объявлении параметров функции
    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь квадрата со сторонами " + a + " и " + b + " = " + rectangleArea(a, b));
    }

    static void printSquareArea(double a) {
        System.out.println("Площадь квадрата со стороной " + a + " = " + sqareArea(a));
    }

    private static double sqareArea(double a) {
        return a * a;
    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }
}
