package solution;

import java.util.stream.IntStream;

public class StupidSolution extends Solution {
    @Override
    public long sumList(int[] listOfNumbers) {
        return (long) IntStream.of(listOfNumbers)
                .peek(i -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).sum();
    }
}
