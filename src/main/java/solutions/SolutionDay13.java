package solutions;

import utils.DataGetter;

import java.math.BigInteger;
import java.util.ArrayList;
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
        for (Integer bus : buses) {
            int value = bus - (earliestTimestamp % bus);
            if (value < minDiff) {
                minDiff = value;
                minBus = bus;
            }
        }

        return minDiff * minBus;
    }

    public String getMatchedTimestamps(List<String> input) {
        List<Integer> buses = new ArrayList<>();
        List<Integer> offsets = new ArrayList<>();
        String[] busesArray = input.get(1).split(",");

        for (int i = 0; i < busesArray.length; i++)
            if (!busesArray[i].equals("x")) {
                buses.add(Integer.parseInt(busesArray[i]));
                offsets.add(i);
            }

        BigInteger syncTimestamp = BigInteger.valueOf(buses.get(0));
        BigInteger diffTimestamp = BigInteger.valueOf(buses.get(0));
        for (int i = 0; i < buses.size() - 1; i++) {
            BigInteger busTimestamp = BigInteger.valueOf(buses.get(i + 1));
            while (true) {
                syncTimestamp = syncTimestamp.add(diffTimestamp);

                if (syncTimestamp
                        .add(BigInteger.valueOf(offsets.get(i + 1)))
                        .mod(busTimestamp)
                        .equals(BigInteger.ZERO)) {
                    diffTimestamp = diffTimestamp.multiply(busTimestamp);
                    break;
                }
            }
        }

        return syncTimestamp.toString();
    }

    public static void main(String... args) {
        SolutionDay13 solution = new SolutionDay13();

        List<String> input = new DataGetter().getLinesFromFile("data/day13.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getEarliestBusMultipliedByMinutes(input));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getMatchedTimestamps(input));
    }
}
