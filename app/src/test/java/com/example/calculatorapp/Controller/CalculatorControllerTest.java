package com.example.calculatorapp.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;


import com.example.calculatorapp.Service.CalculatorService;
import com.example.calculatorapp.Controller.CalculatorController;
import com.example.calculatorapp.Controller.CalculatorControllerTest;



public class CalculatorControllerTest {

    private CalculatorController calculatorController;

    @Before
    public void setUp(){

        calculatorController = new CalculatorController();

    }

    @Test
    @DisplayName("Test name: Add")
    @Order(1)
    public void testAdd() {
        double result = calculatorController.add(1.0, 2.0);
        assertEquals(3.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Sub")
    @Order(2)
    public void testSub() {
        double result = calculatorController.sub(5.0, 3.0);
        assertEquals(2.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Multi")
    @Order(3)
    public void testMulti() {
        double result = calculatorController.multi(2.0, 3.0);
        assertEquals(6.0, result, 0);
    }

    @Test
    @DisplayName("Test name: Div")
    @Order(4)
    public void testDiv() {
        double result = calculatorController.div(6.0, 2.0);
        assertEquals(3.0, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test name: DivByZero")
    @Order(5)
    public void testDivByZero() {
        calculatorController.div(6.0, 0);
    }

    @Test
    @DisplayName("Test name: Mod")
    @Order(6)
    public void testMod() {
        double result = calculatorController.mod(5.0, 2.0);
        assertEquals(1.0, result, 0);
    }
}