package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionDay15 {

    public int getNthNumber(List<Integer> input, int nth) {
        List<Integer> numbers = new LinkedList<>();

        numbers.addAll(input);
        int turn = numbers.size() - 1;

        while (++turn < nth) {
            System.out.println(turn);
            int lastIndex = turn - 1;
            int lastNumber = numbers.get(lastIndex);

            numbers.remove(lastIndex);
            if (numbers.contains(lastNumber)) {
                int lastNumberIndex = numbers.lastIndexOf(lastNumber);
                numbers.add(lastNumber);
                numbers.add(lastIndex - lastNumberIndex);
            } else {
                numbers.add(lastNumber);
                numbers.add(0);
            }
        }

        return numbers.get(turn - 1);
    }

    public static void main(String... args) {
        SolutionDay15 solution = new SolutionDay15();

        List<Integer> input = Arrays.asList(18, 11, 9, 0, 5, 1);

        //Needs smarter approach - brute force is not sufficient
        Solution.printAnswer(Solution.Answer.Answer_1, solution.getNthNumber(input, 2020));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getNthNumber(input, 30000000));
    }
}
