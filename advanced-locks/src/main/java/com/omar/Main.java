package com.omar;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        Daemon threads vs User Theads:
//        THe program keeps runnning as long as a User thread is active

        Thread userThread = new Thread(new UserHelper());
        Thread daemonThread = new Thread(new DaemonHelper());

        daemonThread.setPriority(10);
        System.out.println(userThread.getPriority());
        System.out.println(daemonThread.getPriority());


        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        boolean[] boolArr = new boolean[10];

        System.out.println(Arrays.toString(boolArr));


    }
}