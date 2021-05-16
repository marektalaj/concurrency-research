package solution;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolSolution extends Solution {

    @Override
    public long sumList(int[] listOfNumbers) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int[] part1 = Arrays.copyOfRange(listOfNumbers, 0, listOfNumbers.length / 5);
        int[] part2 = Arrays.copyOfRange(listOfNumbers, listOfNumbers.length / 5, (listOfNumbers.length / 5) * 2);
        int[] part3 = Arrays.copyOfRange(listOfNumbers, (listOfNumbers.length / 5) * 2, (listOfNumbers.length / 5) * 3);
        int[] part4 = Arrays.copyOfRange(listOfNumbers, (listOfNumbers.length / 5) * 3, (listOfNumbers.length / 5) * 4);
        int[] part5 = Arrays.copyOfRange(listOfNumbers, (listOfNumbers.length / 5) * 4, listOfNumbers.length);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Future<Long> part1Result = createFuture(part1, executorService);
        Future<Long> part2Result = createFuture(part2, executorService);
        Future<Long> part3Result = createFuture(part3, executorService);
        Future<Long> part4Result = createFuture(part4, executorService);
        Future<Long> part5Result = createFuture(part5, executorService);

        try {
            long l = part1Result.get() + part2Result.get() + part3Result.get() + part4Result.get() + part5Result.get();
            stopWatch.stop();
            System.out.println(l);
            System.out.println("inside: " + stopWatch.formatTime());

            return l;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Future<Long> createFuture(int[] partOfArray, ExecutorService executorService) {
        return executorService.submit(() -> {
            long partialSum = 0L;
            for (int i = 0; i < partOfArray.length; i++) {
                partialSum += partOfArray[i];
            }
            return partialSum;
        });
    }
}
