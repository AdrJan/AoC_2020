package solutions;

import utils.DataGetter;

import java.util.List;

public class SolutionDay12 {

    public int getManhattanDistance(List<String> input) {
        //starting position
        int x = 0;
        int y = 0;
        Direction dir = Direction.EAST;

        for (int i = 0; i < input.size(); i++) {
            char instruction = input.get(i).charAt(0);
            int value = Integer.parseInt(input.get(i).substring(1));

            switch (instruction) {
                case 'N':
                    y += value;
                    break;
                case 'S':
                    y -= value;
                    break;
                case 'W':
                    x -= value;
                    break;
                case 'E':
                    x += value;
                    break;
                case 'L':
                    for(int j = 0; j < value/90; j++)
                        dir = Direction.turnLeft(dir);
                    break;
                case 'R':
                    for(int j = 0; j < value/90; j++)
                        dir = Direction.turnRight(dir);
                    break;
                case 'F':
                    x += dir.getxDiff() * value;
                    y += dir.getyDiff() * value;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    private enum Direction {
        NORTH("N", 0, +1),
        EAST("E", 1, 0),
        SOUTH("S", 0, -1),
        WEST("W", -1, 0);

        private String name;
        private int xDiff;
        private int yDiff;

        Direction(String name, int xDiff, int yDiff) {
            this.name = name;
            this.xDiff = xDiff;
            this.yDiff = yDiff;
        }

        public int getxDiff() {
            return xDiff;
        }

        public int getyDiff() {
            return yDiff;
        }

        public static Direction turnLeft(Direction dir) {
            return Direction.values()[Math.floorMod((dir.ordinal() - 1), Direction.values().length)];
        }

        public static Direction turnRight(Direction dir) {
            return Direction.values()[Math.floorMod((dir.ordinal() + 1), Direction.values().length)];
        }
    }

    public static void main(String... args) {
        SolutionDay12 solution = new SolutionDay12();

        List<String> input = new DataGetter().getLinesFromFile("data/day12.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getManhattanDistance(input));
    }
}
