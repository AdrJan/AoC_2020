package solutions;

import utils.DataGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SolutionDay16 {

    public int getSumOfInvalids(List<String> input) {
        int lineIndex = 0;

        Pattern pattern = Pattern.compile("(\\d+)");
        List<List<Integer>> ranges = new ArrayList<>();
        while (true) {
            String line = input.get(lineIndex);
            if (line.equals("")) break;

            Matcher matcher = pattern.matcher(line);

            ranges.add(new ArrayList<>());
            while (matcher.find())
                ranges.get(lineIndex).add(Integer.parseInt(matcher.group(0)));
            lineIndex++;
        }

        int resultSum = 0;
        lineIndex += 5;
        for (int i = lineIndex; i < input.size(); i++) {
            List<Integer> ticketValues = Arrays.asList(input.get(i).split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

           resultSum += getInvalidValues(ticketValues, ranges).stream().reduce(0, Integer::sum);
        }

        return resultSum;
    }

    private boolean isInRange(int value, List<Integer> range) {
        return (((value >= range.get(0))
                && (value <= range.get(1)))
                || ((value >= range.get(2))
                && value <= range.get(3)));
    }

    private boolean isInRanges(int value, List<List<Integer>> ranges) {
        boolean result = false;
        for (List<Integer> range : ranges)
            result = result || isInRange(value, range);
        return result;
    }

    private List<Integer> getInvalidValues(List<Integer> ticketValues, List<List<Integer>> ranges) {
        return ticketValues.stream()
                .filter(x -> !isInRanges(x, ranges))
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        SolutionDay16 solution = new SolutionDay16();

        List<String> input = new DataGetter().getLinesFromFile("data/day16.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getSumOfInvalids(input));
    }
}
