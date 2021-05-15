package task;

import java.security.SecureRandom;

public class TableGenerator {

    public static int[] createList(int listSize) {
        int[] table = new int[listSize];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < listSize; i++) {
            table[i] = secureRandom.nextInt(100);
        }
        return table;
    }

//    public void runTasks() {
//        System.out.println("Start running different methods run!");
//        stopWatch.start();
//        long sum = runSynchronizedIntStreamSumming();
//        stopWatch.stop();
//        System.out.println("Synchronized int stream: " + stopWatch.formatTime());
//        System.out.println("Synchronized int stream sum: " + sum);
//        stopWatch.reset();
//        stopWatch.start();
//        sum = runParallelIntStreamSumming();
//        stopWatch.stop();
//        System.out.println("Parallel int stream: " + stopWatch.formatTime());
//        System.out.println("Parallel stream sum: " + sum);
//        stopWatch.reset();
//        stopWatch.start();
//        sum = runParallelIntStreamSumming();
//        stopWatch.stop();
//        System.out.println("For loop: " + stopWatch.formatTime());
//        System.out.println("For loop: " + sum);
//    }
//
//    private long runSynchronizedIntStreamSumming() {
//        return IntStream.of(listOfNumbers)
//                .sum();
//    }
//
//    private long runParallelIntStreamSumming() {
//        return IntStream.of(listOfNumbers)
//                .parallel()
//                .sum();
//    }
//
//    private long runForLoop() {
//        long accumulator = 0L;
//        for (int i = 0; i < LIST_SIZE; i++) {
//            accumulator += listOfNumbers[i];
//        }
//        return accumulator;
//    }
//
//    private long runByExecutors() {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//
//        return this.accumulator;
//    }

}
