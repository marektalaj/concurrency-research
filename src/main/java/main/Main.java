package main;

import task.TaskRunner;

public class Main {


    public static void main(String[] args) {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.setUpList();
        System.out.println("start");
//        taskRunner.sequentialSum();
        taskRunner.streamSum();
        taskRunner.fixedThreadPoolSolution();
    }

//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }


}
