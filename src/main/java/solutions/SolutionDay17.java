package solutions;

import java.util.List;

public class SolutionDay17 {

    public int getActiveCubes(int whichCycle, List<String> input) {
        int length = input.size();
        int[][][] activeCubes = new int[length + 6][length + 6][length + 6];
        //loading data
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                if (input.get(i).charAt(j) == '#') activeCubes[i + length / 2][j + length / 2][0] = 1;
            }
        }

        //go through all cycles

        return 0;
    }
}
