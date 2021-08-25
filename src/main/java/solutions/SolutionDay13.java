package solutions;

import utils.DataGetter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay13 {

    public int getEarliestBusMultipliedByMinutes(List<String> input) {
        int earliestTimestamp = Integer.parseInt(input.get(0));

        List<Integer> buses = Arrays.stream(input.get(1).split(","))
                .filter(x -> !x.equals("x"))
                .map((Integer::parseInt))
                .collect(Collectors.toList());

        int minDiff = buses.get(0) - (earliestTimestamp % buses.get(0));
        int minBus = buses.get(0);
        for(Integer bus : buses) {
            int value = bus - (earliestTimestamp % bus);
            if (value < minDiff) {
                minDiff = value;
                minBus = bus;
            }
        }

        return minDiff * minBus;
    }

    public static void main(String... args) {
        SolutionDay13 solution = new SolutionDay13();

        List<String> input = new DataGetter().getLinesFromFile("data/day13.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getEarliestBusMultipliedByMinutes(input));
    }
}
