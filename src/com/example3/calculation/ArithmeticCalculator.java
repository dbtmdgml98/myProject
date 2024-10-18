package com.example3.calculation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {   //제네릭을 사용하여 double타입의 값을 받아도 연산이 수행되도록 한다.

    private final List<Double> resultList = new ArrayList<>();

    public double operator(T num1, T num2, char operator){
        OperatorType type = OperatorType.fromOperator(operator);    //입력받은 연산자의 타입을 fromOperator로 확인하고 그 리턴값을 type에 저장한다.

        return switch(type){    //type이 각 케이스에 해당하면 리턴한다.
            case ADD -> num1.doubleValue() + num2.doubleValue();
            case MINUS -> num1.doubleValue() - num2.doubleValue();
            case MULTIPLICATION -> num1.doubleValue() * num2.doubleValue();
            case DIVISION -> num1.doubleValue() / num2.doubleValue() ;
        };
    }

    public List<Double> getResultList(){
        return resultList;
    }

    public void setResultList(double resultList){
        this.resultList.add(resultList);
    }

    public List<Double> getGoeList(Double targetNum){ //사인에 따라서 결과를 보고싶은 메소드
        return resultList.stream()
                .filter(result -> result >= targetNum)     //resultQueue안에 있는 값을 하나하나 접근해서 tragetNum보다 큰 것만 필터링 한다.
                .collect(Collectors.toList());     //모은다.
    }
    /*
    //위에서 스트림을 이용한 getGoeList를 람다로 표현한 경우
    public List<Double> getGoeList1(Double targetNum) {
        List<Double> newList = new ArrayList<>();
        for(Double result : resultList){
            if(result > targetNum){
                newList.add(result);
            }
        }
        return  newList;
    }
     */
}
