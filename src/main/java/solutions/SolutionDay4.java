package solutions;

import utils.DataGetter;

import java.util.*;

public class SolutionDay4 {

    public boolean isValid(List<String> input) {
        Map<String, String> passportValues = getPassportData(input);
        return passportValues.containsKey("byr") &&
                passportValues.containsKey("iyr") &&
                passportValues.containsKey("eyr") &&
                passportValues.containsKey("hgt") &&
                passportValues.containsKey("hcl") &&
                passportValues.containsKey("ecl") &&
                passportValues.containsKey("pid");
    }

    public boolean isStrictValid(List<String> input) {
        Map<String, String> passportValues = getPassportData(input);
        return passportValues.containsKey("byr") && passportValues.get("byr").matches("(19[2-8][0-9]|199[0-9]|200[0-2])") &&
                passportValues.containsKey("iyr") && passportValues.get("iyr").matches("(201[0-9]|2020)") &&
                passportValues.containsKey("eyr") && passportValues.get("eyr").matches("(202[0-9]|2030)") &&
                passportValues.containsKey("hgt") && checkHeight(passportValues.get("hgt")) &&
                passportValues.containsKey("hcl") && passportValues.get("hcl").matches("(#[a-f0-9]{6})") &&
                passportValues.containsKey("ecl") && checkEyeColor(passportValues.get("ecl")) &&
                passportValues.containsKey("pid") && passportValues.get("pid").matches("([0-9]{9})");
    }

    private Map<String, String> getPassportData(List<String> input) {
        Map<String, String> passportValues = new HashMap<>();
        for (String inputLine : input) {
            String[] values = inputLine.split(" ");
            for (String value : values) {
                String[] keyValue = value.split(":");
                passportValues.put(keyValue[0], keyValue[1]);
            }
        }
        return passportValues;
    }

    private boolean checkHeight(String input) {
        if (input.contains("cm"))
            return input.matches("(1[5-8][0-9]|19[0-3])cm");
        else
            return input.matches("(59|6[0-9]|7[0-6])in");
    }

    private boolean checkEyeColor(String input) {
        List<String> eyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

        for (String eyeColor : eyeColors)
            if (input.equals(eyeColor))
                return true;
        return false;
    }

    public static void main(String... args) {
        SolutionDay4 solution = new SolutionDay4();
        DataGetter dataGetter = new DataGetter();

        List<String> allLines = dataGetter.getLinesFromFile("data/day4.txt");
        List<String> personData = new ArrayList<>();
        int validCnt = 0;
        int strictValidCnt = 0;

        for (String line : allLines) {
            if (line.length() == 0) {
                if (solution.isValid(personData)) validCnt++;
                if (solution.isStrictValid(personData)) strictValidCnt++;
                personData.clear();
            } else
                personData.add(line);
        }
        if (solution.isValid(personData)) validCnt++;
        if (solution.isStrictValid(personData)) strictValidCnt++;

        Solution.printAnswer(Solution.Answer.Answer_1, validCnt);
        Solution.printAnswer(Solution.Answer.Answer_2, strictValidCnt);
    }
}
