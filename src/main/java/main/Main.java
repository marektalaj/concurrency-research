package main;

import task.TaskRunner;

public class Main {


    public static void main(String[] args) {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.setUpTaskNumber();
        System.out.println("start");
//        taskRunner.sequentialSum();
        taskRunner.streamSum();
//        taskRunner.parallelStreamSum();
//        taskRunner.fixedThreadPoolSolution();
//        taskRunner.cashedThreadPoolSolution();
        taskRunner.manualManagingSolution();
        taskRunner.forkJoinSolution();
        taskRunner.completableFutureSolution();
    }
//
//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }


}
