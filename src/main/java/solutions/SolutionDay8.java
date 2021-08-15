package solutions;

import utils.DataGetter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionDay8 {

    public int getAccumulator(List<String> instructions) {
        int accumulator = 0;
        Set<Integer> usedInstructions = new HashSet<>();
        int i = 0;

        while(true) {
            if (usedInstructions.contains(i))
                break;
            else
                usedInstructions.add(i);

            String[] splittedInstruction = instructions.get(i).split(" ");
            String instructionName = splittedInstruction[0];
            int instructionValue = Integer.valueOf(splittedInstruction[1]);
            switch (instructionName) {
                case "acc":
                    accumulator += instructionValue;
                    break;
                case "jmp":
                    i += instructionValue - 1;
                    break;
                default:
                    break;
            }
            i++;
        }

        return accumulator;
    }

    public static void main(String... args) {
        SolutionDay8 solution = new SolutionDay8();

        List<String> instructions =  new DataGetter().getLinesFromFile("data/day8.txt");

        solution.getAccumulator(instructions);

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getAccumulator(instructions));
    }
}
