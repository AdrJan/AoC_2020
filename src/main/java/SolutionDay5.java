import utils.DataGetter;

import java.util.List;

public class SolutionDay5 {

    int getSeatId(String input) {
        return getSeatRow(input) * 8 + getSeatCol(input);
    }

    private int getSeatRow(String input) {
        int rangeFront = 127;
        int rangeDown = 0;
        for (int i = 0; i < 7; i++) {
            if (input.charAt(i) == 'B')
                rangeDown = (rangeFront + rangeDown) / 2 + 1;
            else
                rangeFront = (rangeFront + rangeDown) / 2;
        }

        return rangeDown;
    }

    private int getSeatCol(String input) {
        int rangeLeft = 0;
        int rangeRight = 7;
        for (int i = 7; i < 10; i++) {
            if (input.charAt(i) == 'R')
                rangeLeft = (rangeLeft + rangeRight) / 2 + 1;
            else
                rangeRight = (rangeLeft + rangeRight) / 2;
        }

        return rangeLeft;
    }

    public static void main(String... args) {
        SolutionDay5 solution = new SolutionDay5();
        DataGetter dataGetter = new DataGetter();

        List<String> lines = dataGetter.getLinesFromFile("data/day5.txt");
        boolean[][] isOccupiedSeatArray = new boolean[128][8];

        int maxSeatId = 0;
        for (String line : lines) {
            maxSeatId = Math.max(solution.getSeatId(line), maxSeatId);
            isOccupiedSeatArray[solution.getSeatRow(line)][solution.getSeatCol(line)] = true;
        }

        boolean emptySeats = true;
        boolean found = false;
        int santaSeatId = 0;
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 8; j++) {
                if (!isOccupiedSeatArray[i][j] && !emptySeats) {
                    santaSeatId = i * 8 + j;
                    found = true;
                    break;
                }
                if (isOccupiedSeatArray[i][j])
                    emptySeats = false;
            }
            if (found)
                break;
        }

        Solution.printAnswer(Solution.Answer.Answer_1, maxSeatId);
        Solution.printAnswer(Solution.Answer.Answer_2, santaSeatId);
    }
}
