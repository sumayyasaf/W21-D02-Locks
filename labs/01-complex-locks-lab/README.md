# Lab: Concurrency in Java - ReentrantLock and ReadWriteLock

## Objectives
By the end of this lab, students should be able to:
- Implement and use **ReentrantLock** to handle concurrency issues.
- Apply **ReadWriteLock** to optimize read-heavy operations.

## Prerequisites
- Basic knowledge of Java threading.
- Familiarity with `synchronized`, `Lock`, and `ExecutorService`.

---

## Part 1: Using ReentrantLock for Safe Account Transactions

### Task
Implement a `BankAccount` class where multiple threads attempt to deposit and withdraw money. Use `ReentrantLock` to ensure thread safety.

### Steps
1. Create a `BankAccount` class with:
   - A private `balance` variable.
   - A `ReentrantLock` to protect balance modifications.
   - `deposit(int amount)` and `withdraw(int amount)` methods.
2. Create multiple threads to simulate deposits and withdrawals.
3. Observe how `ReentrantLock` ensures safe transactions.

---

## Part 2: Implementing ReadWriteLock for Optimized Reads

### Task
Simulate a shared resource (e.g., a book library) where multiple threads read book details, but only one thread can modify them at a time.

### Steps
1. Create a `Library` class that contains:
   - A `ReadWriteLock` to manage concurrent access.
   - A `readBook()` method where multiple threads can read.
   - An `updateBook(String newTitle)` method where only one thread can modify.
2. Create multiple reader and writer threads.
3. Observe how `ReadWriteLock` optimizes read-heavy operations.

---

## Submission Instructions
- Implement both parts of the lab.
- Run the code and capture the outputs.
- Submit your source code and a short summary of what you observed in each part.

---

## Conclusion
This lab helps students understand:
- How **ReentrantLock** ensures thread safety for critical sections.
- How **ReadWriteLock** optimizes read-heavy operations.


