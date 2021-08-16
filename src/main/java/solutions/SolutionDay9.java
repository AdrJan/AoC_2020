package solutions;

import utils.DataGetter;

import java.util.LinkedList;
import java.util.List;

public class SolutionDay9 {

    public long getFirstUnvalidatedNumber(int preambleLength, List<Long> numbers) {
        for (int i = preambleLength; i < numbers.size(); i++) {
            if (!getComb(numbers.subList(i - preambleLength, i)).contains(numbers.get(i)))
                return numbers.get(i);
        }

        return -1;
    }

//TODO:
//    public long getEncryptionWeakness(String number, List<Long> numbers) {
//        for(int i = 1; i < numbers.size(); i++) {
//            for(int j = 0; j < numbers.size() - i; j++) {
//                if numbers.subList(j, j + i).stream()
//                        .collect(Collectors.summingLong(Long::longValue));
//            }
//        }
//    }

    private List<Long> getComb(List<Long> numbers) {
        List<Long> resultComb = new LinkedList<>();

        for (int i = 0; i < numbers.size(); i++)
            for (int j = 0; j < numbers.size(); j++)
                if (i != j) resultComb.add(numbers.get(i) + numbers.get(j));

        return resultComb;
    }

    public static void main(String... args) {
        SolutionDay9 solution = new SolutionDay9();

        List<Long> numbers = new DataGetter().getLongsFromFile("data/day9.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getFirstUnvalidatedNumber(25, numbers));
    }
}
