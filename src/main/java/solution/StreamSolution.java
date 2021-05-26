package solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) {

        return IntStream.range(0, numbersToGenerate)
                .boxed()
                .map(i -> Generator.generate())
                .collect(Collectors.toList());
    }
}
