package com.example.jdk21Test;

public class Virtual_Thread_Test {
    public static void main(String[] args) {

        //1) Native Thread 테스트
        long startTimeNative = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread nativeThread = new Thread(() -> {
                // 단순 작업: 아무 것도 하지 않음
            });
            nativeThread.start();
            try {
                nativeThread.join();  // 각 스레드가 완료될 때까지 기다림
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTimeNative = System.currentTimeMillis();
        System.out.println("Native Threads took " + (endTimeNative - startTimeNative) + " ms");


        //2) Virtual Thread 테스트
        long startTimeVirtual = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread virtualThread = Thread.ofVirtual().start(() -> {
                // 단순 작업: 아무 것도 하지 않음
            });
            try {
                virtualThread.join();  // 각 스레드가 완료될 때까지 기다림
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTimeVirtual = System.currentTimeMillis();
        System.out.println("Virtual Threads took " + (endTimeVirtual - startTimeVirtual) + " ms");

    }
}
