Java Thread Summation

Creates 1000 threads. Each sums integers from 1 through 1000000.
Each thread stores its result in its own array slot. The main thread
waits for all workers, combines their totals, and prints elapsed seconds.

Requires a JDK (use Java 19 if your class requires it).
Compile from the project folder: javac -d out src/Main.java
Run: java -cp out Main
Expected total: 500000500000000
