import org.junit.Assert;
import org.junit.Test;
import solutions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionTest {

    @Test
    public void day1() {
        List<Integer> input = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        SolutionDay1 solution = new SolutionDay1();

        Assert.assertEquals(solution.getMultiplyResultFor2(input), Integer.valueOf(514579));
    }

    @Test
    public void day2() {
        SolutionDay2 solution = new SolutionDay2();

        Assert.assertTrue(solution.isValid("1-3 a: abcde"));
        Assert.assertFalse(solution.isValid("1-3 b: cdefg"));
        Assert.assertTrue(solution.isValid("2-9 c: ccccccccc"));

        Assert.assertTrue(solution.isValid2("1-3 a: abcde"));
        Assert.assertFalse(solution.isValid2("1-3 b: cdefg"));
        Assert.assertFalse(solution.isValid2("2-9 c: ccccccccc"));
    }

    @Test
    public void day3() {
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

        Assert.assertTrue(solution.isValid(Arrays.asList(
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm")));
        Assert.assertTrue(solution.isValid(Arrays.asList(
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm")));
        Assert.assertFalse(solution.isValid(Arrays.asList(
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in")));
        Assert.assertFalse(solution.isValid(Arrays.asList(
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929")));

        Assert.assertFalse(solution.isStrictValid(Arrays.asList(
                "eyr:1972 cid:100",
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926")));
        Assert.assertFalse(solution.isStrictValid(Arrays.asList(
                "iyr:2019",
                "hcl:#602927 eyr:1967 hgt:170cm",
                "ecl:grn pid:012533040 byr:1946")));
        Assert.assertFalse(solution.isStrictValid(Arrays.asList(
                "hcl:dab227 iyr:2012",
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277")));
        Assert.assertFalse(solution.isStrictValid(Arrays.asList(
                "hgt:59cm ecl:zzz",
                "eyr:2038 hcl:74454a iyr:2023",
                "pid:3556412378 byr:2007")));

        Assert.assertTrue(solution.isStrictValid(Arrays.asList(
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
                "hcl:#623a2f")));
        Assert.assertTrue(solution.isStrictValid(Arrays.asList(
                "eyr:2029 ecl:blu cid:129 byr:1989",
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm")));
        Assert.assertTrue(solution.isStrictValid(Arrays.asList(
                "hcl:#888785",
                "hgt:164cm byr:2001 iyr:2015 cid:88",
                "pid:545766238 ecl:hzl",
                "eyr:2022")));
        Assert.assertTrue(solution.isStrictValid(Collections.singletonList(
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719")));
    }

    @Test
    public void test5() {
        SolutionDay5 solution = new SolutionDay5();

        Assert.assertEquals(solution.getSeatId("FBFBBFFRLR"), 357);
        Assert.assertEquals(solution.getSeatId("FFFBBBFRRR"), 119);
        Assert.assertEquals(solution.getSeatId("BBFFBBFRLL"), 820);
    }

    @Test
    public void test6() {
        SolutionDay6 solution = new SolutionDay6();

        Assert.assertEquals(solution.getAnyoneYesCount(Collections.singletonList("abc")), 3);
        Assert.assertEquals(solution.getAnyoneYesCount(Arrays.asList("a", "b", "c")), 3);
        Assert.assertEquals(solution.getAnyoneYesCount(Arrays.asList("ab", "ac")), 3);
        Assert.assertEquals(solution.getAnyoneYesCount(Arrays.asList("a", "a", "a", "a")), 1);
        Assert.assertEquals(solution.getAnyoneYesCount(Collections.singletonList("b")), 1);

        Assert.assertEquals(solution.getEveryoneYesCount(Collections.singletonList("abc")), 3);
        Assert.assertEquals(solution.getEveryoneYesCount(Arrays.asList("a", "b", "c")), 0);
        Assert.assertEquals(solution.getEveryoneYesCount(Arrays.asList("ab", "ac")), 1);
        Assert.assertEquals(solution.getEveryoneYesCount(Arrays.asList("a", "a", "a", "a")), 1);
        Assert.assertEquals(solution.getEveryoneYesCount(Collections.singletonList("b")), 1);
    }

    @Test
    public void day7() {
        SolutionDay7 solution = new SolutionDay7();
        List<String> input = Arrays.asList(
                "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags."
        );

        Assert.assertEquals(solution.getOuterBags("shiny gold", input), 4);
        Assert.assertEquals(solution.getInnerBags("shiny gold", input), 32);
    }

    @Test
    public void day8() {
        SolutionDay8 solution = new SolutionDay8();
        List<String> input = Arrays.asList(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        );

        Assert.assertEquals(5, solution.getAccumulator(input));
    }
}
