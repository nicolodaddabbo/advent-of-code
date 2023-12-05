package aoc.part1;

import java.util.List;

import aoc.utils.Utils;

public class Solution {
    private static final String INPUT_PATH = "src/main/java/aoc/part1/input.txt";

    public void run() {
        List<String> lines = Utils.readFile(INPUT_PATH);
        String[][] map = Utils.createMap(lines);
        int solution = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (Utils.isNumeric(map[i][j]) && Utils.isPart(map, i, j)) {
                    int value = Integer.parseInt(map[i][j]);
                    int k = j;
                    while (map[i][k].equals("0")) {
                        k--;
                    }
                    value = value == 0 ? Integer.parseInt(map[i][k]) : value;
                    System.out.println(value);
                    solution += value;
                    if (j + 1 < map[0].length && map[i][j + 1].equals("0")) {
                        // I know it's ugly, but I don't have time to fix it
                        j++;
                    }
                    while (map[i][j].equals("0") && j < map[0].length - 1) {
                        j++;
                    }
                }
            }
        }
        System.out.println(solution);
    }
}
