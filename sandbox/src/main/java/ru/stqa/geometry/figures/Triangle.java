package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle should has only non-negative sides");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Triangle inequality is violated");
        }
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double area() {
        double semiPerimeter = this.perimeter() / 2;
        return sqrt(semiPerimeter * (semiPerimeter - this.a) * (semiPerimeter - this.b) * (semiPerimeter - this.c));
    }

    private boolean exists() {
        if ((this.a + this.b) > this.c) {
            return true;
        } else return false;
        //return ((this.a + this.b) > this.c);
    }

    public static void printTriangleArea(Triangle triangle) {
        if (!triangle.exists()) {
            System.out.println(String.format("Треугольника со сторонами %.1f, %.1f и %.1f не существует", triangle.a, triangle.b, triangle.c));
        } else {
            System.out.println(
                    String.format("Площадь треугольника со сторонами %.1f, %.1f и %.1f = %f", triangle.a, triangle.b, triangle.c, triangle.area()));
        }
    }

    public static void printTrianglePerimeter(Triangle triangle) {
        System.out.println(String.format("Периметр треугольника со сторонами %.1f, %.1f и %.1f = %f", triangle.a, triangle.b, triangle.c, triangle.perimeter()));
    }


    /*
        Available combinations:
        ('a', 'b', 'c')
        ('a', 'c', 'b')
        ('b', 'a', 'c')
        ('b', 'c', 'a')
        ('c', 'a', 'b')
        ('c', 'b', 'a')
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, c) == 0)
                || (Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, c) == 0 && Double.compare(triangle.c, b) == 0)
                || (Double.compare(triangle.a, b) == 0 && Double.compare(triangle.b, a) == 0 && Double.compare(triangle.c, c) == 0)
                || (Double.compare(triangle.a, c) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, a) == 0)
                || (Double.compare(triangle.a, b) == 0 && Double.compare(triangle.b, c) == 0 && Double.compare(triangle.c, a) == 0)
                || (Double.compare(triangle.a, c) == 0 && Double.compare(triangle.b, a) == 0 && Double.compare(triangle.c, b) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
