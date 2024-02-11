package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateTriangleArea() {
        Assertions.assertEquals(9.7979589711327112, new Triangle(4.0, 5.0, 7.0).area());
    }
}
