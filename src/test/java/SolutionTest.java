import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void day4() {
        SolutionDay4 solution = new SolutionDay4();

        Assert.assertEquals(solution.isValid(Arrays.asList(
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm")),
                true);
        Assert.assertEquals(solution.isValid(Arrays.asList(
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm")),
                true);
        Assert.assertEquals(solution.isValid(Arrays.asList(
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in")),
                false);
        Assert.assertEquals(solution.isValid(Arrays.asList(
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929"
                )),
                false);
    }
}
