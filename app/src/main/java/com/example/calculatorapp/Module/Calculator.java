package com.example.calculatorapp.Module;

public class Calculator {
    public double add(double firstNumber,double secondNumber){
        return firstNumber+secondNumber;
    }
    public double sub(double firstNumber,double secondNumber){
        return firstNumber-secondNumber;}

    public double multi(double firstNumber,double secondNumber){
        return firstNumber*secondNumber;}
    public double div(double firstNumber,double secondNumber){
        if(secondNumber==0){
            throw new IllegalArgumentException("cannot divide by zero");
        }
        else {
            return firstNumber/secondNumber;
        }
    }
    public double mod(double firstNumber,double secondNumber){
        return firstNumber%secondNumber;
    }
}
