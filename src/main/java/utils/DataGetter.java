package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataGetter {

    public List<Integer> getIntsFromFile(String filename) {
        List<Integer> ints = new ArrayList<Integer>();
        try {
            File file = new File(getClass().getClassLoader().getResource(filename).getFile());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                ints.add(Integer.parseInt(scanner.nextLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ints;
    }

    public List<String> getLinesFromFile(String filename) {
        List<String> strings = new ArrayList<String>();
        try {
            File file = new File(getClass().getClassLoader().getResource(filename).getFile());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                strings.add(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }
}
