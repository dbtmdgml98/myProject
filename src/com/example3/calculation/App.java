package com.example3.calculation;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num1 = s.nextInt();
        char operator = s.next().charAt(0);
        int num2 = s.nextInt();

        ArithmeticCalculator<Integer> calculator = new ArithmeticCalculator<>();
        double operator1 = calculator.operator(num1,num2,operator);
        calculator.setResultList(operator1);
        double operator2 = calculator.operator(2,5,operator);
        calculator.setResultList(operator2);
        double operator3 = calculator.operator(5,3,operator);
        calculator.setResultList(operator3);

        List<Double> result1 = calculator.getResultList();
        for(Double num3 : result1){
            System.out.println(num3);
        }

        System.out.println("========람다적용========");
        List<Double> goeList = calculator.getGoeList(10.0);
        for(Double num4 : goeList){
            System.out.println(num4);
        }
    }
}
