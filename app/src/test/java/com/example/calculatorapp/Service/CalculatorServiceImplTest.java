package com.example.calculatorapp.Service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

public class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService;

    @Before
    public void setUp() throws Exception {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    @DisplayName("Test name: Add")
    @Order(1)
    public void tesAdd() {
        double result = calculatorService.add(1.0, 2.0);
        assertEquals(3.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Sub")
    @Order(2)
    public void testSub() {
        double result = calculatorService.sub(5.0, 3.0);
        assertEquals(2.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Multi")
    @Order(3)
    public void testMulti() {
        double result = calculatorService.multi(2.0, 3.0);
        assertEquals(6.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Div")
    @Order(4)
    public void testDiv() {
        double result = calculatorService.div(6.0, 2.0);
        assertEquals(3.0, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test name: DivByZero")
    @Order(5)
    public void testDivByZero() {
        calculatorService.div(6.0, 0);
    }

    @Test
    @DisplayName("Test name: Mod")
    @Order(6)
    public void testMod() {
        double result = calculatorService.mod(5.0, 2.0);
        assertEquals(1.0, result, 0);
    }
}