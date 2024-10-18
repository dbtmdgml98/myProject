package com.example3.calculation;

public enum OperatorType {
    ADD('+'),
    MINUS('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char symbol;

    // 생성자
    OperatorType(char symbol){
        this.symbol = symbol;
    }

    // 연산자 체크
    public static OperatorType fromOperator(char operator){    //특정기호를 입력 받았을 때 해당 타입을 체크하고 맞다면 타입을 리턴
        for(OperatorType type : OperatorType.values()){
            if(type.symbol == operator){
                return type;
            }
        }

        throw new IllegalArgumentException("해당 연산자가 없습니다!" + operator);
    }
}
