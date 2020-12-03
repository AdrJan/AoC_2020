import utils.DataGetter;

import java.util.List;

public class SolutionDay3 {

    public int getObstacleCnt(int xSlope, int ySlope, List<String> lines) {
        int width = lines.get(0).length();
        int height = lines.size();
        int x = 0;
        int y = 0;
        int obstacleCnt = 0;
        while (y < height) {
            if (lines.get(y).charAt(x) == '#')
                obstacleCnt++;
            y += ySlope;
            x += xSlope;
            x %= width;
        }
        return obstacleCnt;
    }

    public static void main(String... args) {
        DataGetter dataGetter = new DataGetter();
        SolutionDay3 solution = new SolutionDay3();

        List<String> data = dataGetter.getLinesFromFile("data/day3_1.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getObstacleCnt(3, 1, data));
        Solution.printAnswer(Solution.Answer.Answer_2,
                solution.getObstacleCnt(1, 1, data) *
                        solution.getObstacleCnt(3, 1, data) *
                        solution.getObstacleCnt(5, 1, data) *
                        solution.getObstacleCnt(7, 1, data) *
                        solution.getObstacleCnt(1, 2, data)
        );
    }
}
