import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void day1_1() {
        List<Integer> input = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        SolutionDay1 solution = new SolutionDay1();

        Assert.assertEquals(solution.getMultiplyResultFor2(input), Integer.valueOf(514579));
    }

    @Test
    public void day2_1() {
        SolutionDay2 solution = new SolutionDay2();

        Assert.assertEquals(solution.isValid("1-3 a: abcde"), true);
        Assert.assertEquals(solution.isValid("1-3 b: cdefg"), false);
        Assert.assertEquals(solution.isValid("2-9 c: ccccccccc"), true);

        Assert.assertEquals(solution.isValid2("1-3 a: abcde"), true);
        Assert.assertEquals(solution.isValid2("1-3 b: cdefg"), false);
        Assert.assertEquals(solution.isValid2("2-9 c: ccccccccc"), false);
    }

    @Test
    public void day3_1() {
        SolutionDay3 solution = new SolutionDay3();

        List<String> input = Arrays.asList(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        );

        Assert.assertEquals(solution.getObstacleCnt(3, 1, input), 7);
        Assert.assertEquals(
                solution.getObstacleCnt(1, 1, input) *
                        solution.getObstacleCnt(3, 1, input) *
                        solution.getObstacleCnt(5, 1, input) *
                        solution.getObstacleCnt(7, 1, input) *
                        solution.getObstacleCnt(1, 2, input),
                336
        );
    }
}
