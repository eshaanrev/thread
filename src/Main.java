public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
            });
        }
    }
}