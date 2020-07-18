package src;

import java.util.*;

public class GridLand {

    public static List<String> getSafePaths(List<String> journeys) {
        List<String> resultPaths = new ArrayList<>();
        for (String journey : journeys) {
            String[] split = journey.split(" ");
            int endX = Integer.valueOf(split[0]);
            int endY = Integer.valueOf(split[1]);
            int key = Integer.valueOf(split[2]);

            List<String> allPaths = new ArrayList<>();
            dfsGetPaths(endX, endY, 0, 0, allPaths, "");
            Collections.sort(allPaths);
            resultPaths.add(allPaths.get(key));
        }
        return resultPaths;
    }


    static void dfsGetPaths(int endX, int endY, int startX, int startY, List<String> list, String output) {
        if (startX > endX || startY > endX)
            return;

        if (startX == endX && endY == startY) {
            list.add(output);
            return;
        }

        dfsGetPaths(endX, endY, startX, startY + 1, list, output + "H");
        dfsGetPaths(endX, endY, startX + 1, startY, list, output + "V");

    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<String>(Arrays.asList("2 2 2", "2 2 3"));
        List<String> result = getSafePaths(input);
        for (String out : result) {
            System.out.println(out);
        }
    }
}
