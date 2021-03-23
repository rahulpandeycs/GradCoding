package codesignal;

import java.util.Arrays;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {

        for(int i=0; i < matrix.length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = temp;
        }

        for(int i=0; i < matrix.length; i++){
            for(int j=i+1; j < matrix[0].length; j++){
                swap(matrix, i,j);
            }
        }

        reverseLeftDiagonal(matrix);
        swapDiagonals(matrix);
    }


    static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void reverseLeftDiagonal(int[][] matrix) {
        for(int i=0; i< matrix.length/2; i++){
            int temp = matrix[i][i];
            matrix[i][i] = matrix[matrix.length-1-i][matrix.length-1-i];
            matrix[matrix.length-1-i][matrix.length-1-i] = temp;
        }
    }

    static void swapDiagonals(int[][] matrix){
        for(int i=0, j = matrix.length-1; i < matrix.length && j >= 0; i++, j--){
            int temp = matrix[i][i];
            matrix[i][i] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }

    public static void main(String[] args){
//        int input[][] = new int[][]{{5, 1, 9, 11, 12},{2, 4, 8, 10, 90},{13, 3, 6, 7, 19},{15, 14, 12, 16, 14}};
        int input[][] = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(input);

        for(int i=0; i < input.length; i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }
}
