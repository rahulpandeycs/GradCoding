package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Segment {
    public static int segment(int x, List<Integer> space) {
        Integer [] arr = new Integer[space.size()];
        arr = space.toArray(arr);

        ArrayList<Integer> minims = findMinima(arr, arr.length, x);
        return Collections.max(minims);

    }

    static ArrayList<Integer> findMinima(Integer arr[], int n, int k)
    {
        int j, min;
        ArrayList<Integer> minima = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {

            min = arr[i];

            for (j = 1; j < k; j++) {
                if (arr[i + j] < min)
                    min = arr[i + j];
            }
            minima.add(min);
        }
        return minima;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(2);
        arr.add(4);
        System.out.println(segment(2, arr));
    }
}