package com.omar.ticketingSystem;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSystem {
    private final boolean[] seats;
    private final ReentrantLock lock;


    public TicketSystem(int numberOfSeats) {
        this.seats = new boolean[numberOfSeats];
//        FIFO: Queue structure for our threads to aquire the locks we add true to the constructor
        this.lock = new ReentrantLock(true);
        Arrays.fill(this.seats, true);
    }

    public void printSeatStatus(){
        System.out.println("Seat Availability: ");
        for(int i =0; i<this.seats.length; i++){
            System.out.println("Seat " + i + ": " + (seats[i] ? "Available" : "Sold"));
        }
    }

    public void buyTicket(int seatNumber) {
        lock.lock();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " Has the lock");

        if(seatNumber < 0 || seatNumber >= seats.length){
            System.out.println("Seat number invalid");
        }
        if(seats[seatNumber]){
            seats[seatNumber] = false;
            System.out.println("Seat " + seatNumber + " sold to thread with name " + Thread.currentThread().getName());
            printSeatStatus();
        }
        else{
            System.out.println("Seat Number: " + seatNumber + " is already sold");
            printSeatStatus();
        }

        try{
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " Has Released lock");


    }

}
