package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolSolution implements Solution {

    public static final int THREADS_COUNT = 10;
    @Override
    public List<Integer> generateList(int numbersToGenerate) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<Integer>> futureList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < numbersToGenerate; i++) {
            futureList.add(createFuture(executorService));
        }
        for (int i = 0; i < numbersToGenerate; i++) {
            resultList.add(futureList.get(i).get());
        }
        executorService.shutdown();
        return resultList;
    }
    private Future<Integer> createFuture(ExecutorService executorService) {
        return executorService.submit(Generator::generate);
    }
}
