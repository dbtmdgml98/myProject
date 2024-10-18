package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num1;   //변수 선언은 while문 안에서 계속 돌 필요가 없다.
        char operator;
        int num2;
        double result = 0.0;

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = s.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = s.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = s.nextInt();

            if(operator=='+'){
                result = num1 + num2;
            } else if(operator=='-') {
                result = num1 - num2;
            } else if(operator=='*') {
                result = num1 * num2;
            } else if(operator=='/') {
                if(num2==0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                }
                else
                    result = (double)num1 / num2;
            }
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료/계속 계산하려면 아무 문자 입력 )");
            String comment = s.next();
            if(comment.equals("exit")) {
                break;
            }
        }
    }
}
