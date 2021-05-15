package task;

public class SequentialSolution extends Solution {

    @Override
    public Long sumList(int[] listOfNumbers) {
        Long accumulator = 0L;
        for (int i = 0; i < listOfNumbers.length; i++) {
            accumulator += listOfNumbers[i];
        }
        return accumulator;
    }

}
