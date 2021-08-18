package solutions;

import utils.DataGetter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionDay10 {

    public int getMultipliedDiffs(List<Integer> input) {
        Collections.sort(input);

        int value = 0;
        int max = input.get(input.size() - 1);
        int oneDiff = 0;
        int threeDiff = 0;
        while(true) {
            if (value == max) {
                threeDiff++;
                break;
            }
            if(input.contains(value + 1)) {
                value += 1;
                oneDiff++;
            } else if(input.contains(value + 2)) {
                value += 2;
            } else if (input.contains(value + 3)) {
                threeDiff++;
                value += 3;
            }
        }

        return oneDiff * threeDiff;
    }

    public static void main(String... args) {
        SolutionDay10 solution = new SolutionDay10();

        List<Integer> numbers = new DataGetter().getIntsFromFile("data/day10.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getMultipliedDiffs(numbers));
    }
}
