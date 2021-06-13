package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CachedThreadPoolSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> result = new ArrayList<>();
        List<Future<Integer>> futureList = executorService.invokeAll(Stream.generate(this::createFuture)
                .limit(numbersToGenerate)
                .collect(Collectors.toList()));
        for (Future<Integer> future : futureList) {
            result.add(future.get());
        }
        executorService.shutdown();
        return result;
    }
    private Callable<Integer> createFuture() {
        return Generator::generate;
    }
}
