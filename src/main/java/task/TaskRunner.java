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
import solution.BoxedStreamSolution;
import solution.FixedThreadPoolSolution;
import solution.ParallelStreamSolution;
import solution.SequentialSolution;
import solution.Solution;
import solution.StreamSolution;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
public class TaskRunner {

    private int[] listOfNumbers;

    @Setup
    public void setUpList() {
        this.listOfNumbers = TableGenerator.createList(100000000);
    }

    @Benchmark
    public long parallelStreamSum() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        Solution solution = new ParallelStreamSolution();
        long result = solution.sumList(this.listOfNumbers);
//        stopWatch.stop();
//        System.out.println(result);
//        System.out.println("Parallel: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public long sequentialSum() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        Solution solution = new SequentialSolution();
        long result = solution.sumList(this.listOfNumbers);
//        stopWatch.stop();
//        System.out.println(result);
//        System.out.println("Sequential: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public long streamSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new StreamSolution();
        long result = solution.sumList(this.listOfNumbers);
        stopWatch.stop();
        System.out.println(result);
        System.out.println("IntStream: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public long boxedStreamSum() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        Solution solution = new BoxedStreamSolution();
        long result = solution.sumList(this.listOfNumbers);
//        stopWatch.stop();
//        System.out.println(result);
//        System.out.println("Parallel: " + stopWatch.formatTime());
        return result;
    }


    @Benchmark
    public long fixedThreadPoolSolution() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new FixedThreadPoolSolution();
        long result = solution.sumList(this.listOfNumbers);
        stopWatch.stop();
        System.out.println(result);
        System.out.println("Parallel2: " + stopWatch.formatTime());
        return result;
    }

//    @Benchmark
//    public long parallelStreamSum(){
//        Solution solution = new ParallelStreamSolution();
//        return solution.sumList(this.listOfNumbers);
//    }

}
