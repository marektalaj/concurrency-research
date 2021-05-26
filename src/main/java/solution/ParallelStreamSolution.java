package solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) {

        return IntStream.range(0, numbersToGenerate)
                .boxed()
                .map(i -> Generator.generate())
                .parallel()
                .collect(Collectors.toList());
    }
}
