package com.example.calculatorapp.Service;

public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double sub(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multi(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double div(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("cannot divide by zero");
        }
        return firstNumber / secondNumber;
    }

    @Override
    public double mod(double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }
}
