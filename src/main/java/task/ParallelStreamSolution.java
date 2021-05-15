package task;

import java.util.stream.IntStream;

public class ParallelStreamSolution extends Solution {
    @Override
    public Long sumList(int[] listOfNumbers) {
        return (long) IntStream.of(listOfNumbers)
                .sum();
    }
}
