package src;

import java.util.*;

public class BestSquares {

    public static void main(String[] args) {
//        int[][] board1 = new int[][]{{5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}};
        int[][] board1 = new int[][]{{5}};
        int k = 2, maxSum = Integer.MIN_VALUE;
        if(board1.length < k || board1[0].length < k) {System.out.println(0); return;}


        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < board1.length - k; i++) {
            for (int j = 0; j < board1[0].length - k; j++) {
                int currSum = calculateSum(board1, i, j, k);
                if (currSum >= maxSum) {
                    maxSum = Math.max(currSum, maxSum);
                    List<int[]> retList = map.getOrDefault(currSum, new ArrayList<>());
                    retList.add(new int[]{i, j});
                    map.put(currSum, retList);
                }
            }
        }

        Set<Integer> distinct = new HashSet<>();
        int sum = 0;
        for (int[] arr : map.get(maxSum)) {
            for (int i = arr[0]; i < arr[0] + k; i++) {
                for (int j = arr[1]; j < arr[1] + k; j++) {
                    if (!distinct.contains(board1[i][j])) {
                        distinct.add(board1[i][j]);
                        sum += board1[i][j];
                    }
                }
            }
        }
        System.out.println(sum);
    }

    static int calculateSum(int[][] nums, int row, int col, int k) {
        int sum = 0;
        for (int i = row; i < row + k; i++) {
            for (int j = col; j < col + k; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }
}


