package solution;

public class SequentialSolution extends Solution {

    @Override
    public long sumList(int[] listOfNumbers) {
        long accumulator = 0L;
        for (int i = 0; i < listOfNumbers.length; i++) {
            accumulator += listOfNumbers[i];
        }
        return accumulator;
    }

}
