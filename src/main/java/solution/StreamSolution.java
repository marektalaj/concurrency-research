package solution;

import java.util.stream.IntStream;

public class StreamSolution extends Solution {
    @Override
    public long sumList(int[] listOfNumbers) {
        return (long) IntStream.of(listOfNumbers)
                .sum();
    }
}
