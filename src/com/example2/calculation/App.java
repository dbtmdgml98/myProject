package com.example2.calculation;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Calculator cal = new Calculator();  //Calculator 클래스 안의 메소드를 사용하기 위해 인스턴스화한다.

        int num1;   //변수 선언은 while문 안에서 계속 돌 필요가 없다.
        char operator;
        int num2;
        double result;

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = s.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = s.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = s.nextInt();

            cal.setNum1(num1);  //Setter메소드를 통해 Calculator클래스의 데이터를 수정한다.
            cal.setNum2(num2);
            cal.setOperator(operator);


            try{
                result = cal.calculator(cal.getOperator(), cal.getNum1(), cal.getNum2());   //Calculator클래스의 위에서 수정한 3개의 데이터를 Getter로 가져와서 바로 다시 Calculator클래스의 calculator 메소드를 호출한다.
            }catch(RuntimeException e){ //예외가 발생하면
                System.out.println(e.getMessage()); //메세지출력 후 처음으로 돌아간다.
                continue;
            }
            System.out.println("결과 : " + result);
            System.out.println("저장된 데이터를 보여드릴게요.");
            System.out.println(cal.getQueue());

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String comment = s.next();
            if("exit".equals(comment)) {  //일반적으로 equals 의 경우 NullPointerException 으로 인해 상수 값이 앞으로 오도록 작성하는 것이 좋다!
                break;
            }
            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String comment2 = s.next();
            if(comment2.equals("remove")){
                cal.removeResult();
                System.out.println("삭제 후 저장된 데이터를 보여드릴게요.");
                System.out.println(cal.getQueue());	//오른쪽부터 하나씩 꺼낸다.
            }
        }
    }
}
