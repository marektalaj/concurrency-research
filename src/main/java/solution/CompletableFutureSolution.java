package solution;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Integer>> collect = IntStream.range(0, numbersToGenerate)
                .boxed()
                .map(number -> CompletableFuture.supplyAsync(Generator::generate))
                .collect(Collectors.toList());
        return allOf(collect).get();
    }

    public CompletableFuture<List<Integer>> allOf(List<CompletableFuture<Integer>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        return allFuturesResult.thenApply(v ->
                futuresList.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.toList())
        );
    }
}
