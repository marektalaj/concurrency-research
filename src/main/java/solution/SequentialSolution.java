package solution;

import java.util.ArrayList;
import java.util.List;

public class SequentialSolution extends Solution {

    @Override
    public List<Integer> generateList(int numbersToGenerate) {
        List<Integer> generatedList = new ArrayList<>();
        for (int i = 0; i < numbersToGenerate; i++) {
            generatedList.add(Generator.generate());
        }
        return generatedList;
    }

}
