package com.omar.locks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
//    Locks

//    ReentrantLock

    private static final ReentrantLock lock = new ReentrantLock();

    public static void safeMethod(){
//        .lock(): aquires the lock if it is available
        lock.lock();
        try {
            System.out.println("The lock has been acquired by: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
//            .unlock(): releases the lock
            System.out.println(Thread.currentThread().getName() + " Has released the lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Thread firstThread = new Thread(Main::safeMethod);
        Thread secondThread = new Thread(Main::safeMethod);


        firstThread.start();
        secondThread.start();
    }


}
