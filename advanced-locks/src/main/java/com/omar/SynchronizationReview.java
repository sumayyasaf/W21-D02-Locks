package com.omar;

public class SynchronizationReview {
    private static int counter = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) {

        Thread incrementThread = new Thread(()->{
            for(int i =0; i<1000; i++){
                increment();
            }
        });
        Thread decrementThread = new Thread(()->{
            for(int i =0; i<1000; i++){
                decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);

    }

    public static void increment(){

        synchronized (lock){
            counter++;
        }
    }

    public static void decrement(){

        synchronized (lock){
            counter--;
        }
    }
}
