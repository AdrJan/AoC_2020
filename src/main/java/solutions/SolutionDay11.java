package solutions;

import utils.DataGetter;

import java.util.Arrays;
import java.util.List;

public class SolutionDay11 {

    public int countOccupied(List<String> input, boolean isInLine) {
        char[][] table = new char[input.size()][input.get(0).length()];

        //save input data into table
        for (int i = 0; i < input.size(); i++)
            for (int j = 0; j < input.get(i).length(); j++)
                table[i][j] = input.get(i).charAt(j);

        while (true) {
            boolean isChanged = false;
            char[][] newTable = Arrays.stream(table).map(char[]::clone).toArray(char[][]::new);
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(i).length(); j++) {
                    int occupiedAdjacents = isInLine
                            ? getOccupiedInLineAdjacents(i, j, table)
                            : getOccupiedAdjacents(i, j, table);
                    int occupiedToEmpty = isInLine ? 5 : 4;

                    if (table[i][j] == 'L' && occupiedAdjacents == 0) {
                        newTable[i][j] = '#';
                        isChanged = true;
                    } else if (table[i][j] == '#' && occupiedAdjacents >= occupiedToEmpty) {
                        newTable[i][j] = 'L';
                        isChanged = true;
                    }
                }
            }
            table = newTable;
            if (!isChanged) break;
        }

        //get occupied seats in the end
        int counter = 0;
        for (int i = 0; i < input.size(); i++)
            for (int j = 0; j < input.get(i).length(); j++)
                if (table[i][j] == '#') counter++;

        return counter;
    }

    private int getOccupiedAdjacents(int i, int j, char[][] table) {
        int occupiedAdjacents = 0;

        if (i > 0 && j > 0 && table[i - 1][j - 1] == '#') occupiedAdjacents++;
        if (i > 0 && table[i - 1][j] == '#') occupiedAdjacents++;
        if (i > 0 && j < table[i].length - 1 && table[i - 1][j + 1] == '#') occupiedAdjacents++;
        if (j > 0 && table[i][j - 1] == '#') occupiedAdjacents++;
        if (j < table[i].length - 1 && table[i][j + 1] == '#') occupiedAdjacents++;
        if (i < table.length - 1 && table[i + 1][j] == '#') occupiedAdjacents++;
        if (i < table.length - 1 && j < table[i].length - 1 && table[i + 1][j + 1] == '#') occupiedAdjacents++;
        if (i < table.length - 1 && j > 0 && table[i + 1][j - 1] == '#') occupiedAdjacents++;

        return occupiedAdjacents;
    }

    private int getOccupiedInLineAdjacents(int i, int j, char[][] table) {
        int occupiedAdjacents = 0;

        if (isSideOccupied(+1, +1, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(+1, -1, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(+1, 0, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(-1, +1, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(-1, -1, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(-1, 0, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(0, +1, i, j, table)) occupiedAdjacents++;
        if (isSideOccupied(0, -1, i, j, table)) occupiedAdjacents++;


        return occupiedAdjacents;
    }

    private boolean isSideOccupied(int iDiff, int jDiff, int i, int j, char[][] table) {
        while (true) {
            try {
                if (table[i + iDiff][j + jDiff] == '#') return true;
                if (table[i + iDiff][j + jDiff] == 'L') return false;
                i += iDiff;
                j += jDiff;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static void main(String... args) {
        SolutionDay11 solution = new SolutionDay11();

        List<String> input = new DataGetter().getLinesFromFile("data/day11.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.countOccupied(input, false));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.countOccupied(input, true));
    }
}
