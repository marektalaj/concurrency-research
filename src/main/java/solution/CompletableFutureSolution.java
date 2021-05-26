package solution;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        List<CompletableFuture<Integer>> collect = IntStream.range(0, numbersToGenerate)
                .boxed()
                .map(number -> CompletableFuture.supplyAsync(Generator::generate))
                .collect(Collectors.toList());
        try {
            return allOf(collect).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
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
