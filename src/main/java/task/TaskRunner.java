package task;

import org.apache.commons.lang3.time.StopWatch;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
public class TaskRunner {

    private int[] listOfNumbers;

    @Setup
    public void setUpList() {
        this.listOfNumbers = TableGenerator.createList(1000000);
    }

    @Benchmark
    public Long sequentialSum() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        Solution solution = new SequentialSolution();
        Long result = solution.sumList(this.listOfNumbers);
//        stopWatch.stop();
//        System.out.println(result);
//        System.out.println("Sequential: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public Long parallelStreamSum() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        Solution solution = new ParallelStreamSolution();
        Long result = solution.sumList(this.listOfNumbers);
//        stopWatch.stop();
//        System.out.println(result);
//        System.out.println("Parallel: " + stopWatch.formatTime());
        return result;
    }

//    @Benchmark
//    public Long parallelStreamSum(){
//        Solution solution = new ParallelStreamSolution();
//        return solution.sumList(this.listOfNumbers);
//    }

}
