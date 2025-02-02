package com.example.jdk21Test;

// 중첩된 레코드 정의
record Address(String city, String street) { }

record Person(String name, int age, Address address) { }


public class RecordPatternMatchingTest {
    public static void main(String[] args) {
        // 중첩된 레코드 객체 생성
        Address address = new Address("Seoul", "Gangnam");
        Person person = new Person("Depth", 28, address);

        // 1) 레코드 패턴을 사용한 필드 추출
        if (person instanceof Person(String name, int age, Address addr)) {
            // 필드 추출
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("City: " + addr.city());
            System.out.println("Street: " + addr.street());
        }

        System.out.println();

        // 2) 중첩된 레코드 패턴을 사용한 필드 추출
        if (person instanceof Person(String name, int age, Address(String city, String street))) {
            // 중첩된 레코드 패턴 사용
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("City: " + city);
            System.out.println("Street: " + street);
        }

        // 3) 레코드와 switch 표현식 통합
        String result = switch (person) {
            case Person(String name, int age, Address(String city, String street)) -> {
                if (age >= 18) {
                    yield name + " is an adult living in " + city + ", " + street;
                } else {
                    yield name + " is a minor living in " + city + ", " + street;
                }
            }
            default -> "Unknown person";
        };

        System.out.println(result);
    }
}
