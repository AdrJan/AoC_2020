package solutions;

import utils.DataGetter;

import java.util.Collections;
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

    public long getEncryptionWeakness(long number, List<Long> numbers) {
        for (int i = 2; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size() - i; j++) {
                List<Long> tempList = numbers.subList(j, j + i);
                if (tempList.stream().mapToLong(Long::longValue).sum() == number) {
                    return Collections.max(tempList) +
                            Collections.min(tempList);
                }
            }
        }
        return -1;
    }

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

        long firstUnvalidatedNumber = solution.getFirstUnvalidatedNumber(25, numbers);

        Solution.printAnswer(Solution.Answer.Answer_1, firstUnvalidatedNumber);
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getEncryptionWeakness(firstUnvalidatedNumber, numbers));
    }
}
