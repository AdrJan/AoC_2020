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

        while (true) {
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

    //TODO: refactor!!!
    //Its working, but it is a pure spaghetti code
    public int getFixedAccumulator(List<String> instructions) {
        int accumulator = 0;
        int accumulatorTemp = 0;
        Set<Integer> usedInstructions = new HashSet<>();
        Set<Integer> usedInstructionsFromChange = new HashSet<>();
        int i = 0;
        int indexOfChange = -1;
        boolean flagIsChanged = false;
        boolean flagWasChanged = false;

        while (true) {
            if (usedInstructions.contains(i)) {
                i = indexOfChange;
                usedInstructions.removeAll(usedInstructionsFromChange);
                usedInstructionsFromChange.clear();
                accumulator -= accumulatorTemp;
                accumulatorTemp = 0;
                flagIsChanged = false;
                flagWasChanged = true;
            } else {
                usedInstructions.add(i);
                if (flagIsChanged)
                    usedInstructionsFromChange.add(i);
            }

            String[] splittedInstruction = instructions.get(i).split(" ");
            String instructionName = splittedInstruction[0];

            int instructionValue = Integer.parseInt(splittedInstruction[1]);
            switch (instructionName) {
                case "acc":
                    accumulator += instructionValue;
                    if (flagIsChanged)
                        accumulatorTemp += instructionValue;
                    break;
                case "jmp":
                    if (!flagIsChanged && !flagWasChanged) {
                        flagIsChanged = true;
                        indexOfChange = i;
                    } else
                        i += instructionValue - 1;
                    flagWasChanged = false;
                    break;
                case "nop":
                    if (!flagIsChanged && !flagWasChanged) {
                        flagIsChanged = true;
                        indexOfChange = i;
                        if(i != 0)
                            i += instructionValue - 1;
                    }
                    flagWasChanged = false;
                    break;
                default:
                    break;
            }

            if (i == instructions.size() - 1)
                break;
            i++;
        }

        return accumulator;
    }

    public static void main(String... args) {
        SolutionDay8 solution = new SolutionDay8();

        List<String> instructions = new DataGetter().getLinesFromFile("data/day8.txt");

        solution.getAccumulator(instructions);

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getAccumulator(instructions));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getFixedAccumulator(instructions));
    }
}
