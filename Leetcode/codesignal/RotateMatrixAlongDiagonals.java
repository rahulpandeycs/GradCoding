package codesignal;

import java.util.Arrays;

public class RotateMatrixAlongDiagonals {


    static void rotateAlongDiagonals(int[][] matrix){

        int len = matrix.length;
        for(int i=0; i < len; i++){
            for(int j=i; j < len; j++){
                if(i == j || i+j==len-1){

                }else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //Reverse each row
        for(int i=0; i < len; i++){
            for(int j=0; j < len/2; j++){
                if(i == j || i+j==len-1){

                } else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][len-j-1];
                    matrix[i][len-j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input");
        for(int i=0; i < input.length; i++){
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println("Output");
        rotateAlongDiagonals(input);
        for(int i=0; i < input.length; i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }
}
