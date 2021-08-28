package solutions;

import utils.DataGetter;

import java.util.*;

public class SolutionDay14 {

    public long getSumOfAllValuesLeftInMemory(List<String> input) {
        Map<Integer, BitSet> bitSets = new HashMap<>();
        Map<Integer, Boolean> maskChangedValues = new HashMap<>();

        for (String line : input) {
            if (line.contains("mask")) {
                maskChangedValues.clear();
                String mask = line.split("=")[1].trim();
                for (int i = mask.length() - 1; i >= 0; i--)
                    if (mask.charAt(i) != 'X')
                        maskChangedValues.put(mask.length() - 1 - i, mask.charAt(i) - '0' != 0);
            } else {
                int memoryAddress = Integer.parseInt(line.substring(line.indexOf('[') + 1, line.indexOf(']')));
                int value = Integer.parseInt(line.substring(line.indexOf('=') + 1).trim());

                BitSet bitSet = BitSet.valueOf(new long[]{value});
                for (Map.Entry<Integer, Boolean> maskValue : maskChangedValues.entrySet())
                    bitSet.set(maskValue.getKey(), maskValue.getValue());

                bitSets.put(memoryAddress, bitSet);
            }
        }
        long result = 0;
        for (Map.Entry<Integer, BitSet> bitset : bitSets.entrySet()) {
            result += bitset.getValue().toLongArray()[0];
        }

        return result;
    }

    public long getSumOfAllValuesLeftInMemoryWithFloats(List<String> input) {
        Map<Long, Integer> memoryAddresses = new HashMap<>();
        Map<Integer, Character> maskValues = new HashMap<>();

        for (String line : input) {
            if (line.contains("mask")) {
                maskValues.clear();
                String mask = line.split("=")[1].trim();
                for (int i = mask.length() - 1; i >= 0; i--)
                    if (mask.charAt(i) != '0')
                        maskValues.put(mask.length() - 1 - i, mask.charAt(i));
            } else {
                int memoryAddress = Integer.parseInt(line.substring(line.indexOf('[') + 1, line.indexOf(']')));
                int value = Integer.parseInt(line.substring(line.indexOf('=') + 1).trim());

                List<BitSet> bitSetComb = new ArrayList<>();
                bitSetComb.add(BitSet.valueOf(new long[]{memoryAddress}));

                for (Map.Entry<Integer, Character> maskValue : maskValues.entrySet()) {
                    if (maskValue.getValue() == '1') {
                        for (BitSet bitSet : bitSetComb)
                            bitSet.set(maskValue.getKey(), true);
                    } else if (maskValue.getValue() == 'X') {
                        List<BitSet> tempComb = new ArrayList<>();
                        for (BitSet bitSet : bitSetComb) {
                            BitSet tempBitSet0 = (BitSet) bitSet.clone();
                            BitSet tempBitSet1 = (BitSet) bitSet.clone();
                            tempBitSet0.set(maskValue.getKey(), false);
                            tempBitSet1.set(maskValue.getKey(), true);
                            tempComb.add(tempBitSet0);
                            tempComb.add(tempBitSet1);
                        }
                        bitSetComb.remove(0);
                        bitSetComb.addAll(tempComb);
                    }
                }

                for (BitSet bitSet : bitSetComb)
                    memoryAddresses.put(bitSet.toLongArray()[0], value);
            }
        }

        long result = 0;
        for (Map.Entry<Long, Integer> memory : memoryAddresses.entrySet()) {
            result += memory.getValue();
        }

        return result;
    }

    public static void main(String... args) {
        SolutionDay14 solution = new SolutionDay14();

        List<String> input = new DataGetter().getLinesFromFile("data/day14.txt");

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getSumOfAllValuesLeftInMemory(input));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getSumOfAllValuesLeftInMemoryWithFloats(input));
    }
}
