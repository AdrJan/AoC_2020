import utils.DataGetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    public boolean isStrictValid(List<String> input) {
//        Map<String, String> passportValues = getPassportData(input);
//        return passportValues.containsKey("byr") && passportValues.get("byr").matches("(19[2-8][0-9]|199[0-9]|200[0-2])") &&
//                passportValues.containsKey("iyr") && passportValues.get("iyr").matches("(201[0-9]|2020)") &&
//                passportValues.containsKey("eyr") && passportValues.get("eyr").matches("(202[0-9]|2030)")
//                passportValues.containsKey("hgt") &&
//                passportValues.containsKey("hcl") &&
//                passportValues.containsKey("ecl") &&
//                passportValues.containsKey("pid");
//    }

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

//    private boolean checkHeight(String input) {
//        if(input.contains("cm"))
//            return input.matches("(1[5-8][0-9]|19[0-3])cm");
//        else
//            return input.matches("(59|6[0-9]|7[0-6])");
//    }

    public static void main(String... args) {
        SolutionDay4 solution = new SolutionDay4();
        DataGetter dataGetter = new DataGetter();

        List<String> allLines = dataGetter.getLinesFromFile("data/day4.txt");
        List<String> personData = new ArrayList<>();
        int validCnt = 0;

        for (String line : allLines) {
            if (line.length() == 0) {
                if (solution.isValid(personData)) validCnt++;
                personData.clear();
            } else
                personData.add(line);
        }
        if (solution.isValid(personData)) validCnt++;

        Solution.printAnswer(Solution.Answer.Answer_1, validCnt);
    }
}
