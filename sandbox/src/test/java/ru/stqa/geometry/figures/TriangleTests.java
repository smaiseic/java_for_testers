package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea() {
        Assertions.assertEquals(9.7979589711327112, new Triangle(4.0, 5.0, 7.0).area());
    }

    @Test
    void canCalculateTrianglePerimeter() {
        Assertions.assertEquals(15, new Triangle(4.0, 5.0, 6.0).perimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSideA() {
        try {
            new Triangle(5.0, -4.0, 7.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void cannotCreateTriangleWithViolatedInequality() {
        try {
            new Triangle(5.0, 11.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void canCreateCorrectTriangle() {
        try {
            new Triangle(5.0, 4.0, 9.0);
            System.out.println("Triangle was successfully created");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
