package solutions;

import java.util.*;

public class SolutionDay15 {

    public int getNthNumber(List<Integer> input, int nth) {
        Map<Integer, Deque<Integer>> numbers = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            numbers.put(input.get(i), new ArrayDeque<>());
            numbers.get(input.get(i)).push(i);
        }

        int lastNumber = input.get(input.size() - 1);
        int lastIndex = numbers.size() - 1;

        while (++lastIndex < nth) {
            if(numbers.containsKey(lastNumber)) {
                if(numbers.get(lastNumber).size() < 2) {
                    numbers.get(0).add(lastIndex);
                    lastNumber = 0;
                } else {
                    int last = numbers.get(lastNumber).removeLast();
                    int beforeLast = numbers.get(lastNumber).removeLast();
                    int currentNumber = last - beforeLast;

                    if(!numbers.containsKey(currentNumber))
                        numbers.put(currentNumber, new ArrayDeque<>());

                    numbers.get(lastNumber).add(beforeLast);
                    numbers.get(lastNumber).add(last);
                    numbers.get(currentNumber).add(lastIndex);

                    lastNumber = currentNumber;
                }
            }
        }

        return lastNumber;
    }

    //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    //0 3 6 0 3 3 1 0 4  0  2  0  2  2  1  8  0  5  0  2
    //(0, 0) (3, 1) (6, 2) 3 turn
    //(0, 3) (3, 1) (6, 2) 4 turn
    //(0, 3) (3, 4) (6, 2) 5 turn
    //(0, 3) (3, 5)
    //TODO: OPTIMIZE
    public static void main(String... args) {
        SolutionDay15 solution = new SolutionDay15();

        List<Integer> input = Arrays.asList(18, 11, 9, 0, 5, 1);

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getNthNumber(input, 2020));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getNthNumber(input, 30000000));
    }
}
