package src;

import java.util.Arrays;

public class RotateImageNoDiagonals {
    static void rotate(int[][] matrix) {
            int start = 0, end = matrix.length - 1;
            while (start < end) {
                int[] temp = matrix[start];
                matrix[start] = matrix[end];
                matrix[end] = temp;
                start++;
                end--;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; i++, j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][i];
                matrix[i][i] = temp;
            }

            for (int i = 0, j = matrix[0].length - 1; i < matrix.length / 2; i++, j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

/* 7 8 9
   4 5 6
   1 2 3

   7 4 1
   8 5 2
   9 6 3


   7 4 1
   8 5 2
   9 6 3

   [[5,13,2,15],
   [14,4,3,1],
   [12,8,6,9],
   [11,7,10,16]]

 [[5,13,2,11],
 [14,4,8,1],
 [12,3,6,9],
 [15,7,10,16]]
   */

    public static void main(String[] args) {
        int[][] board1 = new int[][]{{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(board1);
        for(int i = 0; i < board1.length; i++)
           System.out.println(Arrays.toString(board1[i]));
    }
}
