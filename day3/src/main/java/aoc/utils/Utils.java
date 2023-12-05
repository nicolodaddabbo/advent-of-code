package aoc.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static Scanner openFile(String path) {
        try {
            File file = new File(path);
            return new Scanner(file);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static List<String> readFile(String path) {
        Scanner scanner = openFile(path);
        List<String> lines = new ArrayList<>();
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        }
        return lines;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPart(String[][] map, int i, int j) {
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                    if (!isNumeric(map[x][y]) && !map[x][y].equals(".")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String[][] createMap(List<String> lines) {
        String[][] map = new String[lines.size()][lines.get(0).length()];
        int i = 0;
        int j = 0;

        for (String line : lines) {
            String[] parts = line.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            j = 0;
            for (String part : parts) {
                if (isNumeric(part)) {
                    for (int k = 0; k < part.length(); k++) {
                        map[i][j] = k == 0 ? part : "0";
                        j++;
                    }
                } else {
                    for (int k = 0; k < part.length(); k++) {
                        map[i][j] = part.charAt(k) + "";
                        j++;
                    }
                }
            }
            i++;
        }
        return map;
    }
}
