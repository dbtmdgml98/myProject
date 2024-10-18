package com.example2.calculation;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private double result;
    private  int num1;
    private  int num2;
    private char operator;
    private final Queue<Double> queue = new LinkedList<>();

    public int getNum1(){
        return num1;
    }
    public void setNum1(int num1){
        this.num1 = num1;
    }

    public int getNum2(){
        return num2;
    }
    public void setNum2(int num2){
        this.num2 = num2;
    }

    public char getOperator(){
        return operator;
    }

    public void setOperator(char operator){
        this.operator = operator;
    }

    public Queue<Double> getQueue(){
        return this.queue;
    }

    public void removeResult(){ //가장 먼저 저장된 데이터 삭제하는 메소드
        this.queue.poll();  //선입선출 특징이 있는 큐를 이용하겠다.
    }

    public double calculator(char operator, int num1, int num2 ){
            result = 0;

            if(operator=='+'){
                result = num1 + num2;
            } else if(operator=='-') {
                result = num1 - num2;
            } else if(operator=='*') {
                result = num1 * num2;
            } else if(operator=='/') {
                if(num2==0) {
                    throw new RuntimeException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                else
                    result = (double)num1 / num2;
            }
            this.queue.add(result); //큐에 추가한다.
            return result;
    }
}
