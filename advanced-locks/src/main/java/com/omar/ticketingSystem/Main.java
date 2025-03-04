package com.omar.ticketingSystem;

public class Main {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem(10);
        ticketSystem.printSeatStatus();

        Thread sumayyaThread = new Thread(new UserThread(ticketSystem),"Sumayya");
        Thread aronThread = new Thread(new UserThread(ticketSystem),"Aron");
        Thread hasanThread = new Thread(new UserThread(ticketSystem),"Hasan");


        sumayyaThread.start();
        aronThread.start();
        hasanThread.start();

    }
}
