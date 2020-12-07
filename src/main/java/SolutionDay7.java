import java.util.*;

public class SolutionDay7 {

    public int howManyBags(List<String> input) {
        Map<String, Set<String>> allBags = new HashMap<>();
        int indexOfContain;
        String divideWord = "contain";
        for(String line : input) {
            indexOfContain = line.indexOf(divideWord);
            String outerBag = line.substring(0, indexOfContain);
            String innerBagsStr = line.substring(indexOfContain + divideWord.length());
            String[] innerBagsArray = innerBagsStr.split(",");
            for(String innerBag : innerBagsArray) {
                String[] innerBagArray = innerBag.split(" ");
                String bagName = innerBagArray[0] + " " + innerBagArray[1];
                if(allBags.containsKey(bagName)) {
                }
            }
        }

        return 0;
    }
}
