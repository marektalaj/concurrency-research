package solution;

import java.util.stream.IntStream;

public class BoxedStreamSolution extends Solution {
    @Override
    public long sumList(int[] listOfNumbers) {
        return IntStream.of(listOfNumbers)
                .boxed()
                .reduce(0, Integer::sum).longValue();
    }
}
