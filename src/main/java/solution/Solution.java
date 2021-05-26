package solution;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface Solution {
    List<Integer> generateList(int numbersToGenerate) throws InterruptedException, ExecutionException;
}

