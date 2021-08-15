package solutions;

import utils.DataGetter;

import java.util.*;

public class SolutionDay7 {

    static Set<String> usedBags = new HashSet<>();

    //TODO: Could be refactored into one method
    private Map<String, Set<String>> getMappedOuterBags(List<String> input) {
        Map<String, Set<String>> allBags = new HashMap<>();
        int indexOfContain;
        String divideWord = "contain";
        for (String line : input) {
            indexOfContain = line.indexOf(divideWord);

            String outerBag = line.substring(0, indexOfContain);
            String[] outerBagArray = outerBag.split(" ");
            allBags.putIfAbsent(outerBagArray[0] + " " + outerBagArray[1], new HashSet<>());

            String innerBagsStr = line.substring(indexOfContain + divideWord.length());
            if (!innerBagsStr.contains("no other bags.")) {
                String[] innerBagsArray = innerBagsStr.split(",");
                for (String innerBag : innerBagsArray) {
                    String[] innerBagArray = innerBag.split(" ");
                    String bagName = innerBagArray[2] + " " + innerBagArray[3];
                    if (!allBags.containsKey(bagName))
                        allBags.put(bagName, new HashSet<>());
                    allBags.get(bagName).add(outerBagArray[0] + " " + outerBagArray[1]);
                }
            }
        }

        return allBags;
    }

    private Map<String, Map<String, Integer>> getMappedCountedBags(List<String> input) {
        Map<String, Map<String, Integer>> countedBags = new HashMap<>();
        int indexOfContain;
        String divideWord = "contain";
        for (String line : input) {
            indexOfContain = line.indexOf(divideWord);

            String outerBag = line.substring(0, indexOfContain);
            String[] outerBagArray = outerBag.split(" ");
            String outerBagName = outerBagArray[0] + " " + outerBagArray[1];
            countedBags.putIfAbsent(outerBagName, new HashMap<>());

            String innerBagsStr = line.substring(indexOfContain + divideWord.length());
            if (!innerBagsStr.contains("no other bags.")) {
                String[] innerBagsArray = innerBagsStr.split(",");
                for (String innerBag : innerBagsArray) {
                    String[] innerBagArray = innerBag.split(" ");
                    String bagName = innerBagArray[2] + " " + innerBagArray[3];
                    countedBags.get(outerBagName).putIfAbsent(bagName, Integer.parseInt(innerBagArray[1]));
                }
            }
        }

        return countedBags;
    }

    private int countOuterBags(String bag, Map<String, Set<String>> allBags, int counter) {
        for (String outerBag : allBags.get(bag)) {
            if (!usedBags.contains(outerBag)) {
                counter++;
                usedBags.add(outerBag);
                counter = countOuterBags(outerBag, allBags, counter);
            }
        }
        return counter;
    }

    private int countBags(String bag, Map<String, Map<String, Integer>> bags, int counter) {
        for (Map.Entry<String, Integer> innerBag : bags.get(bag).entrySet()) {
            counter += innerBag.getValue() + innerBag.getValue() * countBags(innerBag.getKey(), bags, 0);
        }
        return counter;
    }

    public int getOuterBags(String bag, List<String> input) {
        Map<String, Set<String>> bags = getMappedOuterBags(input);
        return countOuterBags(bag, bags, 0);
    }

    public int getInnerBags(String bag, List<String> input) {
        Map<String, Map<String, Integer>> bags = getMappedCountedBags(input);
        return countBags(bag, bags, 0);
    }

    public static void main(String... args) {
        SolutionDay7 solution = new SolutionDay7();
        DataGetter dataGetter = new DataGetter();

        List<String> input = dataGetter.getLinesFromFile("data/day7.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getOuterBags("shiny gold", input));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getInnerBags("shiny gold", input));
    }
}
