package solutions;

import java.util.Arrays;
import java.util.List;

public class SolutionDay11 {

    public int countOccupied(List<String> input) {
        char[][] table = new char[input.size()][input.get(0).length()];

        //save input data into table
        for (int i = 0; i < input.size(); i++)
            for (int j = 0; j < input.get(i).length(); j++)
                table[i][j] = input.get(i).charAt(j);

        while (true) {
            boolean isChanged = false;
            char[][] newTable = Arrays.copyOf(table, table.length);
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(i).length(); j++) {
                    int occupiedAdjacents = 0;

                    if (i > 0 && j > 0 && table[i - 1][j - 1] == '#') occupiedAdjacents++;
                    if (i > 0 && table[i - 1][j] == '#') occupiedAdjacents++;
                    if (i > 0 && j < table[i].length - 1 && table[i - 1][j + 1] == '#') occupiedAdjacents++;
                    if (j > 0 && table[i][j - 1] == '#') occupiedAdjacents++;
                    if (j < table[i].length - 1 && table[i][j + 1] == '#') occupiedAdjacents++;
                    if (i < table.length - 1 && table[i + 1][j] == '#') occupiedAdjacents++;
                    if (i < table.length - 1 && j < table[i].length - 1 && table[i + 1][j + 1] == '#')
                        occupiedAdjacents++;
                    if (i < table.length - 1 && j > 0 && table[i + 1][j - 1] == '#') occupiedAdjacents++;

                    if (table[i][j] == 'L' && occupiedAdjacents == 0) {
                        newTable[i][j] = '#';
                        isChanged = true;
                    } else if (table[i][j] == '#' && occupiedAdjacents >= 4) {
                        newTable[i][j] = 'L';
                        isChanged = true;
                    }
                }
                System.out.println();
            }
            table = newTable;
            if (!isChanged) break;
        }

        int counter = 0;
        for (int i = 0; i < input.size(); i++)
            for (int j = 0; j < input.get(i).length(); j++)
                if (table[i][j] == '#') counter++;

        return counter;
    }
}
