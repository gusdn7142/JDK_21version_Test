package com.example.jdk21Test;


public class Switch_Pattern_Matching {
    public static void main(String[] args) {

        Object number = null;

        String result = switch (number) {
            case null -> "Input is null";   // null 처리
            case Integer i -> "IntegerValue : " + i;
            case String s -> "StringValue : " + s;
            default -> "Other type";
        };
        System.out.println(result);
    }
}
