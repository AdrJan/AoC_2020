import java.util.*;

public class SolutionDay7 {

    public int howManyBags(List<String> input) {
        Map<String, Set<String>> allBags = new HashMap<>();
        int indexOfContain;
        String divideWord = "contain";
        for(String line : input) {
            indexOfContain = line.indexOf(divideWord);

            String outerBag = line.substring(0, indexOfContain);
            String[] outerBagArray =  outerBag.split(" ");

            String innerBagsStr = line.substring(indexOfContain + divideWord.length());
            if(!innerBagsStr.contains("no other bags.")) {
                String[] innerBagsArray = innerBagsStr.split(",");
                for(String innerBag : innerBagsArray) {
                    String[] innerBagArray = innerBag.split(" ");
                    String bagName = innerBagArray[2] + " " + innerBagArray[3];
                    if(!allBags.containsKey(bagName))
                        allBags.put(bagName, new HashSet<>());
                    allBags.get(bagName).add(outerBagArray[0] + " " + outerBagArray[1]);
                }
            }
        }


    }
}
