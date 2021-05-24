package solution;

import task.TaskRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class ManualManagingSolution extends Solution{
    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

        for (int i = 0; i < numbersToGenerate; i++) {
            FutureTask<Integer> rf = new FutureTask<>(Generator::generate);
            taskList.add(rf);
            new Thread(rf).start();
        }

        List<Integer> result = new ArrayList<>();
        for (Future<Integer> future : taskList) {
            try {
                result.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private FutureTask<Integer> getFutureTask() {
        return new FutureTask<>(Generator::generate);
    }
}
