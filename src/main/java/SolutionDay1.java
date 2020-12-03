import utils.DataGetter;

import java.util.List;

public class SolutionDay1 {

    public Integer getMultiplyResultFor2(List<Integer> values) {
        int size = values.size();
        for (int i = 0; i < size; i++)
            for (int j = i; j < size; j++)
                if (values.get(i) + values.get(j) == 2020)
                    return values.get(i) * values.get(j);
        throw new IllegalStateException();
    }

    public Integer getMultiplyResultFor3(List<Integer> values) {
        int size = values.size();
        for (int i = 0; i < size; i++)
            for (int j = i; j < size; j++)
                for (int k = j; k < size; k++)
                    if (values.get(i) + values.get(j) + values.get(k) == 2020)
                        return values.get(i) * values.get(j) * values.get(k);
        throw new IllegalStateException();
    }

    public static void main(String... args) {
        DataGetter dataGetter = new DataGetter();
        SolutionDay1 solution = new SolutionDay1();

        List<Integer> data = dataGetter.getIntsFromFile("data/day1_1.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getMultiplyResultFor2(data));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getMultiplyResultFor3(data));
    }
}
