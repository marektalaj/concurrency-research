package solution;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CachedThreadPoolSolution extends Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> result;
        try {
            result = executorService.invokeAll(Stream.generate(this::createFuture)
                    .limit(numbersToGenerate)
                    .collect(Collectors.toList()))
                    .stream()
                    .map(getFuture())
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = null;
        }
        executorService.shutdown();
        return result;
    }

    private Function<Future<Integer>, Integer> getFuture() {
        return integerFuture -> {
            try {
                return integerFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        };
    }

    private Callable<Integer> createFuture() {
        return Generator::generate;
    }
}
