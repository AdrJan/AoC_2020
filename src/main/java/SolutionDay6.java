import utils.DataGetter;

import java.util.*;

public class SolutionDay6 {

    public int getAnyoneYesCount(List<String> input) {
        Set<Character> yesCount = new HashSet<>();
        for (String line : input)
            for (int i = 0; i < line.length(); i++)
                yesCount.add(line.charAt(i));

        return yesCount.size();
    }

    public int getEveryoneYesCount(List<String> input) {
        Map<Character, Integer> yesCount = new HashMap<>();
        for (String line : input)
            for (int i = 0; i < line.length(); i++)
                yesCount.merge(line.charAt(i), 1, Integer::sum);

        int everyoneYesCount = 0;
        int groupSize = input.size();
        for (Map.Entry<Character, Integer> entry : yesCount.entrySet())
            if (entry.getValue() == groupSize)
                everyoneYesCount++;

        return everyoneYesCount;
    }

    public static void main(String... args) {
        SolutionDay6 solution = new SolutionDay6();
        DataGetter dataGetter = new DataGetter();

        List<String> input = dataGetter.getLinesFromFile("data/day6.txt");
        List<String> groupData = new ArrayList<>();
        int sumAnyone = 0;
        int sumEveryone = 0;
        for (String line : input) {
            if (line.length() == 0) {
                sumAnyone += solution.getAnyoneYesCount(groupData);
                sumEveryone += solution.getEveryoneYesCount(groupData);
                groupData.clear();
            } else
                groupData.add(line);
        }
        sumAnyone += solution.getAnyoneYesCount(groupData);
        sumEveryone += solution.getEveryoneYesCount(groupData);

        Solution.printAnswer(Solution.Answer.Answer_1, sumAnyone);
        Solution.printAnswer(Solution.Answer.Answer_2, sumEveryone);
    }
}
