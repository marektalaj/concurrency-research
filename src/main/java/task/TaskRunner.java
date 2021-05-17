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
import solution.CachedThreadPoolSolution;
import solution.CompletableFutureSolution;
import solution.FixedThreadPoolSolution;
import solution.ManualManagingSolution;
import solution.ParallelStreamSolution;
import solution.SequentialSolution;
import solution.Solution;
import solution.StreamSolution;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@State(Scope.Benchmark)
public class TaskRunner {

    private int numberToGenerate;

    @Setup
    public void setUpTaskNumber() {
        this.numberToGenerate = 1_000;
    }

    @Benchmark
    public List<Integer> parallelStreamSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new ParallelStreamSolution();
        List<Integer> result = solution.generateList(this.numberToGenerate);
        stopWatch.stop();
        // System.out.println(result.size());
        // System.out.println("Parallel stream: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public List<Integer> sequentialSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new SequentialSolution();
        List<Integer> result = solution.generateList(this.numberToGenerate);
        stopWatch.stop();
        // System.out.println(result);
        // // System.out.println("Sequential: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public List<Integer> streamSum() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new StreamSolution();
        List<Integer> result = solution.generateList(this.numberToGenerate);
        stopWatch.stop();
        // System.out.println(result);
        // System.out.println("Stream: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public List<Integer> fixedThreadPoolSolution() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new FixedThreadPoolSolution();
        List<Integer> result = solution.generateList(this.numberToGenerate);
        stopWatch.stop();
        // System.out.println(result);
        // System.out.println("Fixed thread pool: " + stopWatch.formatTime());
        return result;
    }

    @Benchmark
    public List<Integer> cashedThreadPoolSolution() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Solution solution = new CachedThreadPoolSolution();
        List<Integer> result = solution.generateList(this.numberToGenerate);
        stopWatch.stop();
        // System.out.println(result.size());
        // System.out.println("Cashed thread pool: " + stopWatch.formatTime());
        return result;
    }

//
//    @Benchmark
//    public List<Integer> completableFutureSolution() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        Solution solution = new CompletableFutureSolution();
//        List<Integer> result = solution.generateList(this.numberToGenerate);
//        stopWatch.stop();
//        // System.out.println(result.size());
//        // System.out.println("Completable future: " + stopWatch.formatTime());
//        return result;
//    }
//
//
//    @Benchmark
//    public List<Integer> forkJoinSolution() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        Solution solution = new CachedThreadPoolSolution();
//        List<Integer> result = solution.generateList(this.numberToGenerate);
//        stopWatch.stop();
//        // System.out.println(result.size());
//        // System.out.println("Cashed thread pool: " + stopWatch.formatTime());
//        return result;
//    }
//
//
//    @Benchmark
//    public List<Integer> manualManagingSolution() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        Solution solution = new ManualManagingSolution();
//        List<Integer> result = solution.generateList(this.numberToGenerate);
//        stopWatch.stop();
//        // System.out.println(result.size());
//        // System.out.println("Cashed thread pool: " + stopWatch.formatTime());
//        return result;
//    }

//    @Benchmark
//    public long parallelStreamSum(){
//        Solution solution = new ParallelStreamSolution();
//        return solution.sumList(this.listOfNumbers);
//    }

}
