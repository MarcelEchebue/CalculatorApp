package com.example.calculatorapp.Controller;


import com.example.calculatorapp.Service.CalculatorServiceImpl;
import com.example.calculatorapp.Service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorServiceImpl();
    }

    public double add(double firstNumber, double secondNumber) {
        return calculatorService.add(firstNumber, secondNumber);
    }

    public double sub(double firstNumber, double secondNumber) {
        return calculatorService.sub(firstNumber, secondNumber);
    }

    public double multi(double firstNumber, double secondNumber) {
        return calculatorService.multi(firstNumber, secondNumber);
    }

    public double div(double firstNumber, double secondNumber) {
        return calculatorService.div(firstNumber, secondNumber);
    }

    public double mod(double firstNumber, double secondNumber) {
        return calculatorService.mod(firstNumber, secondNumber);
    }
}
