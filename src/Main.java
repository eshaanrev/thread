public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        Thread[] threads = new Thread[1000];
        long[] totals = new long[1000];

        // Each thread calculates the same sum and stores it in its own slot.
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                long total = 0;
                for (int number = 1; number <= 1_000_000; number++) {
                    total += number;
                }
                totals[index] = total;
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for every thread before reading the results.
        for (Thread thread : threads) {
            thread.join();
        }

        // Combine all 1000 results using long to avoid overflow.
        long grandTotal = 0;
        for (long total : totals) {
            grandTotal += total;
        }

        // Measure elapsed time before printing the output.
        long endTime = System.nanoTime();
        double seconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Total: " + grandTotal);
        System.out.println("Time: " + seconds + " seconds");
    }
}