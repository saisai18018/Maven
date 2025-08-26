package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calc.add(6, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(6, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(24, calc.multiply(6, 4));
    }

    @Test
    void testDivide() {
        assertEquals(3, calc.divide(12, 4));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }
}
