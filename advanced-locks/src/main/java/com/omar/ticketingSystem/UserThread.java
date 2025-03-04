package com.omar.ticketingSystem;

public class UserThread implements Runnable{
    private TicketSystem ticketSystem;

    public UserThread(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    @Override
    public void run() {
//        gets a random number between 1-10
        int seatToBuy = (int) (Math.random()*10);
//        buys the ticket with the number
        ticketSystem.buyTicket(seatToBuy);
    }
}
