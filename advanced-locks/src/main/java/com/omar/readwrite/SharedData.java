package com.omar.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int data = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readData(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " Is reading the data " + data);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally{
            lock.readLock().unlock();
        }
    }

    public void writeData(int value){
        lock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName() + " is writing " + value);
            data = value;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.writeLock().unlock();
        }
    }

}
