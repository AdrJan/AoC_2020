import org.junit.Assert;
import org.junit.Test;
import solutions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        Assert.assertEquals(8, solution.getFixedAccumulator(input));
    }

    @Test
    public void day9() {
        SolutionDay9 solution = new SolutionDay9();
        List<Integer> input = Arrays.asList(
                35,
                20,
                15,
                25,
                47,
                40,
                62,
                55,
                65,
                95,
                102,
                117,
                150,
                182,
                127,
                219,
                299,
                277,
                309,
                576
        );

        Assert.assertEquals(127, solution.getFirstUnvalidatedNumber(5, input.stream()
                .mapToLong(Integer::longValue)
                .boxed()
                .collect(Collectors.toList())));

        Assert.assertEquals(62, solution.getEncryptionWeakness(127, input.stream()
                .mapToLong(Integer::longValue)
                .boxed()
                .collect(Collectors.toList())));
    }

    @Test
    public void day10() {
        SolutionDay10 solution = new SolutionDay10();
        List<Integer> input = Arrays.asList(
                28,
                33,
                18,
                42,
                31,
                14,
                46,
                20,
                48,
                47,
                24,
                23,
                49,
                45,
                19,
                38,
                39,
                11,
                1,
                32,
                25,
                35,
                8,
                17,
                7,
                9,
                4,
                2,
                34,
                10,
                3
        );

        Assert.assertEquals(35, solution.getMultipliedDiffs(input));
//        Assert.assertEquals(8, solution.getCombinations(input));
    }

    @Test
    public void day11() {
        SolutionDay11 solution = new SolutionDay11();
        List<String> input = Arrays.asList(
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"
        );

        Assert.assertEquals(37, solution.countOccupied(input, false));
        Assert.assertEquals(26, solution.countOccupied(input, true));
    }

    @Test
    public void day12() {
        SolutionDay12 solution = new SolutionDay12();
        List<String> input = Arrays.asList(
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        );

        Assert.assertEquals(25, solution.getManhattanDistance(input));
        Assert.assertEquals(286, solution.getManhattanDistanceWithWaypoint(input));
    }

    @Test
    public void day13() {
        SolutionDay13 solution = new SolutionDay13();
        List<String> input = Arrays.asList("939", "7,13,x,x,59,x,31,19");

        Assert.assertEquals(295, solution.getEarliestBusMultipliedByMinutes(input));
        Assert.assertEquals("1068781", solution.getMatchedTimestamps(input));
    }

    @Test
    public void day14() {
        SolutionDay14 solution = new SolutionDay14();
        List<String> input = Arrays.asList(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0"
        );
        List<String> input2 = Arrays.asList(
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1"
        );

        Assert.assertEquals(165, solution.getSumOfAllValuesLeftInMemory(input));
        Assert.assertEquals(208, solution.getSumOfAllValuesLeftInMemoryWithFloats(input2));
    }

    @Test
    public void day15() {
        SolutionDay15 solution = new SolutionDay15();
        List<Integer> input = Arrays.asList(0, 3, 6);

        Assert.assertEquals(436, solution.getNthNumber(input, 2020));
        Assert.assertEquals(175594, solution.getNthNumber(input, 30000000));
    }

    @Test
    public void day16() {
        SolutionDay16 solution = new SolutionDay16();
        List<String> input = Arrays.asList(
                "class: 1-3 or 5-7",
                "row: 6-11 or 33-44",
                "seat: 13-40 or 45-50",
                "\n",
                "your ticket:",
                "7,1,14",
                "\n",
                "nearby tickets:",
                "7,3,47",
                "40,4,50",
                "55,2,20",
                "38,6,12"
        );

        List<String> input2 = Arrays.asList(
                "class: 0-1 or 4-19",
                "row: 0-5 or 8-19",
                "seat: 0-13 or 16-19",
                "\n",
                "your ticket:",
                "11,12,13",
                "\n",
                "nearby tickets:",
                "3,9,18",
                "15,1,5",
                "5,14,9"
        );

        Assert.assertEquals(12, solution.getMultipliedFieldValues(input2, 1));
        Assert.assertEquals(71, solution.getSumOfInvalids(input));
    }

    @Test
    public void day17() {
        SolutionDay17 solution = new SolutionDay17();
        List<String> input = Arrays.asList(
                ".#.",
                "..#",
                "###"
        );

        Assert.assertEquals(112, solution.getActiveCubes(6, input));
    }
}
