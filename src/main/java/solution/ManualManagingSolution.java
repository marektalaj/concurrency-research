package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ManualManagingSolution implements Solution {

    private static final int THREAD_COUNT = 10;
    @Override
    public List<Integer> generateList(int numbersToGenerate) throws InterruptedException, ExecutionException {
        int numbersToGenerateRemaining = numbersToGenerate;
        List<Integer> result = new ArrayList<>();
        while (numbersToGenerateRemaining > 0) {
            List<FutureTask<Integer>> taskList = new ArrayList<>();
            for (int i = 0; i < THREAD_COUNT && numbersToGenerateRemaining > 0; i++) {
                FutureTask<Integer> futureTask = new FutureTask<>(Generator::generate);
                taskList.add(futureTask);
                new Thread(futureTask).start();
                numbersToGenerateRemaining--;
            }
            for (Future<Integer> future : taskList) {
                result.add(future.get());
            }
        }
        return result;
    }

}
