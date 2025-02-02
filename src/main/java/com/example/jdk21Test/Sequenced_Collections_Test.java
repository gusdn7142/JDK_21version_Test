package com.example.jdk21Test;


import java.util.*;

public class Sequenced_Collections_Test {
    public static void main(String[] args) {


        //1) Java 17 - List 기반의 ArrayList 사용
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        //1-1) 첫 번째와 마지막 요소 가져오기
        System.out.println("First Element: " + list.get(0)); // 출력: A
        System.out.println("Last Element: " + list.get(list.size() - 1)); // 출력: C

        //1-2) 첫 번째와 마지막에 요소 추가 (ArrayList에서 add는 뒤에만 추가 가능)
        list.add(0, "Start"); // 첫 번째에 요소 추가
        list.add("End"); // 마지막에 요소 추가
        System.out.println("Updated List: " + list); // 출력: [Start, A, B, C, End]

        //1-3) 첫 번째와 마지막 요소 제거
        list.remove(0); // 첫 번째 요소 제거
        list.remove(list.size() - 1); // 마지막 요소 제거
        System.out.println("Final List: " + list); // 출력: [A, B, C]


        //2) Java 21 - SequencedCollection 기반의 ArrayList 사용
        SequencedCollection<String> listInJava21 = new ArrayList<>(List.of("A", "B", "C"));

        //2-1) 첫 번째와 마지막 요소 가져오기
        System.out.println("First Element: " + listInJava21.getFirst()); // 출력: A
        System.out.println("Last Element: " + listInJava21.getLast());   // 출력: C

        //2-2) 첫 번째와 마지막에 요소 추가
        listInJava21.addFirst("Start");
        listInJava21.addLast("End");
        System.out.println("Updated List: " + listInJava21); // 출력: [Start, A, B, C, End]

        //2-3) 첫 번째와 마지막 요소 제거
        listInJava21.removeFirst();
        listInJava21.removeLast();
        System.out.println("Final List: " + listInJava21); // 출력: [A, B, C]

    }
}
