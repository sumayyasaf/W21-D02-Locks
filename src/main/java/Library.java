import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Library {
    private String bookTitle = "Let us C";
    //A ReadWriteLock to manage concurrent access
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    //A readBook() method where multiple threads can read
    public void readBook(String bookTitle) {
        lock.readLock().lock();
       try {
           System.out.println(Thread.currentThread().getName() + ": Reading book " + bookTitle);
           Thread.sleep(500);
       } catch (InterruptedException e) {
           e.printStackTrace();
       } finally {
           lock.readLock().unlock();
       }
    }
    public void writeBook(String bookTitle) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Writing book " + bookTitle);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                library.readBook("Let us C");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = () -> {
            library.writeBook("Let us Java");
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable2);
        Thread waitingThread = new Thread(thread1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        waitingThread.start();

    }
}
