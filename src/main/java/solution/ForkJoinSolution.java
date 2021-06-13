package solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinSolution implements Solution {
    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(numbersToGenerate);
        commonPool.execute(customRecursiveTask);
        return customRecursiveTask.join();
    }

    private static class CustomRecursiveTask extends RecursiveTask<List<Integer>> {
        public static final int PART_PER_THREAD = 25;
        private final int sizeToGenerate;
        public CustomRecursiveTask(int sizeToGenerate) {
            this.sizeToGenerate = sizeToGenerate;
        }
        @Override
        protected List<Integer> compute() {
            if (sizeToGenerate > PART_PER_THREAD) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .map((ForkJoinTask<?> forkJoinTask) -> (List<Integer>) forkJoinTask.join())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
            } else {
                return processing(sizeToGenerate);
            }
        }

        private Collection<CustomRecursiveTask> createSubtasks() {
            List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
            dividedTasks.add(new CustomRecursiveTask(
                    sizeToGenerate / 2));
            dividedTasks.add(new CustomRecursiveTask(
                    sizeToGenerate / 2));
            return dividedTasks;
        }

        private List<Integer> processing(int numbersToGenerate) {
            return IntStream.range(0, numbersToGenerate)
                    .boxed()
                    .map(i -> Generator.generate())
                    .collect(Collectors.toList());
        }
    }
}
