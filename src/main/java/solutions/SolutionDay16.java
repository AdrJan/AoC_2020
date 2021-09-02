package solutions;

import utils.DataGetter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            List<Integer> ticketValues = Arrays.stream(input.get(i).split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            resultSum += getInvalidValues(ticketValues, ranges)
                    .stream()
                    .reduce(0, Integer::sum);
        }

        return resultSum;
    }

    public int getMultipliedFieldValues(List<String> input, String fieldStartWith) {
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

        lineIndex += 2;
        List<Integer> yourTicket = Arrays.stream(input.get(lineIndex)
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lineIndex += 3;
        int ticketIndex = 0;
        List<List<Set<Integer>>> possibleValues = new ArrayList<>();
        for (int i = lineIndex; i < input.size(); i++) {
            possibleValues.add(new ArrayList<>());
            possibleValues.get(ticketIndex++).addAll(
                    Arrays.stream(input.get(i).split(","))
                            .map(Integer::parseInt)
                            .map(x -> getPossibleFields(ranges, x))
                            .collect(Collectors.toList()));

        }

        possibleValues = possibleValues
                .stream()
                .filter(x -> x.stream().noneMatch(Set::isEmpty))
                .collect(Collectors.toList());

        while (true) {
            Set<Integer> possibleValuesColumn;
            for (int i = 0; i < possibleValues.get(0).size(); i++) {
                possibleValuesColumn = new HashSet<>();
                for (int j = 0; j < possibleValues.size(); j++) {
                    if (j == 0)
                        possibleValuesColumn = possibleValues.get(j).get(i);
                    else
                        possibleValuesColumn.retainAll(possibleValues.get(j).get(i));
                }
                changeColumn(possibleValues, possibleValuesColumn, i);
            }

            for (int i = 0; i < possibleValues.get(0).size(); i++) {
                if (possibleValues.get(0).get(i).size() == 1)
                    for (int j = 0; j < possibleValues.get(0).size(); j++) {
                        if (j != i) {
                            possibleValues.get(0).get(j).removeAll(possibleValues.get(0).get(i));
                        }
                    }
            }

            if (isFound(possibleValues.get(0)))
                break;
        }

        return 0;
    }

//    12-0 73
//    8-1 59
//    4-2 79
//    14-3 167
//    19-4 179
//    2-5 149
    private void changeColumn(List<List<Set<Integer>>> possibleValues,
                              Set<Integer> updatedValue, int columnId) {
        for (int i = 0; i < possibleValues.get(0).size(); i++)
            possibleValues.get(i).set(columnId, updatedValue);
    }

    private Set<Integer> getPossibleFields(List<List<Integer>> ranges, int value) {
        return IntStream.range(0, ranges.size())
                .filter(i -> isInRange(value, ranges.get(i)))
                .mapToObj(i -> i)
                .collect(Collectors.toSet());
    }

    private List<Integer> getInvalidValues(List<Integer> ticketValues, List<List<Integer>> ranges) {
        return ticketValues.stream()
                .filter(x -> !isInRanges(x, ranges))
                .collect(Collectors.toList());
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

    private boolean isFound(List<Set<Integer>> possibleValuesRow) {
        boolean result = true;
        for(int i = 0; i < possibleValuesRow.size(); i++)
            result = result && (possibleValuesRow.get(i).size() == 1);
        return result;
    }

    public static void main(String... args) {
        SolutionDay16 solution = new SolutionDay16();

        List<String> input = new DataGetter().getLinesFromFile("data/day16.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getSumOfInvalids(input));
        Solution.printAnswer(
                Solution.Answer.Answer_2,
                solution.getMultipliedFieldValues(input, "departure"));
    }
}
