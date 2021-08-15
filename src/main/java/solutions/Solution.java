package solutions;

public class Solution {

    public static void printAnswer(Answer answer, Object value) {
        System.out.printf((answer.text) + "%n", value);
    }

    public enum Answer {
        Answer_1("Answer for first part: %s."),
        Answer_2("Answer for second part: %s");

        String text;

        Answer(String text) {
            this.text = text;
        }
    }
}
