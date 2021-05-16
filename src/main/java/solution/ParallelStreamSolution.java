package solution;

import java.util.stream.IntStream;

public class ParallelStreamSolution extends Solution {
    @Override
    public long sumList(int[] listOfNumbers) {
        return (long) IntStream.of(listOfNumbers)
                .parallel()
                .sum();
    }
}
