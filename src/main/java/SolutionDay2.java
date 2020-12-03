import utils.DataGetter;

import java.util.List;

public class SolutionDay2 {

    public boolean isValid(String line) {
        String[] data = line.split(" ");
        String[] ranges = data[0].split("-");

        int lowerRange = Integer.parseInt(ranges[0]);
        int higherRange = Integer.parseInt(ranges[1]);
        char c = data[1].charAt(0);
        String str = data[2];

        int cCnt = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                cCnt++;

        return (cCnt >= lowerRange && cCnt <= higherRange);
    }

    public boolean isValid2(String line) {
        String[] data = line.split(" ");
        String[] indexes = data[0].split("-");

        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);
        char c = data[1].charAt(0);
        String str = data[2];

        return (str.charAt(firstIndex - 1) == c ^ str.charAt(secondIndex - 1) == c);
    }

    public static void main(String... args) {
        DataGetter dataGetter = new DataGetter();
        SolutionDay2 solution = new SolutionDay2();

        List<String> data = dataGetter.getLinesFromFile("data/day2_1.txt");

        int validCnt = 0;
        for (String line : data)
            if (solution.isValid(line))
                validCnt++;

        int valid2Cnt = 0;
        for (String line : data)
            if (solution.isValid2(line))
                valid2Cnt++;

        Solution.printAnswer(Solution.Answer.Answer_1, validCnt);
        Solution.printAnswer(Solution.Answer.Answer_2, valid2Cnt);
    }
}
