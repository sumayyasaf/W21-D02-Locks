package com.omar;

public class DaemonHelper implements Runnable{
    @Override
    public void run() {
        int count = 0;

        while(count < 500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon Thread is running");
        }
    }
}
