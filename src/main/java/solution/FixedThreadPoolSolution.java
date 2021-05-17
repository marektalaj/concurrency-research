package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolSolution extends Solution {

    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < numbersToGenerate; i++) {
            futureList.add(createFuture(executorService));
        }
        for (int i = 0; i < numbersToGenerate; i++) {
            try {
                resultList.add(futureList.get(i).get());

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return resultList;
    }

    private Future<Integer> createFuture(ExecutorService executorService) {
        return executorService.submit(Generator::generate);
    }
}
