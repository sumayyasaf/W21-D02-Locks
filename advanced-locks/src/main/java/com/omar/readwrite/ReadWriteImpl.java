package com.omar.readwrite;

public class ReadWriteImpl {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread writer = new Thread(()->sharedData.writeData((int) (Math.random()*100)),"Write-1");
        Thread writer2 = new Thread(()->sharedData.writeData((int) (Math.random()*100)),"Write-2");

        Thread read = new Thread(sharedData::readData,"Reader-1");
        Thread read2 = new Thread(sharedData::readData,"Reader-2");

        writer.start();
        writer2.start();
        read.start();
        read2.start();


    }
}
