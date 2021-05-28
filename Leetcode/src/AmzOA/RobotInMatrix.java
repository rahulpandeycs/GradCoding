package src.AmzOA;

import java.util.ArrayList;
import java.util.List;

public class RobotInMatrix {
    public static void main(String[] args) {

        List<List<Integer>> output = new ArrayList<>();
        int[][] matrix = new int[][]{{1,2,3,4},
                                     {5,6,7,8},
                                     {9,10,11,12}};
        helperFindPaths(0,0,new ArrayList<>(), output, matrix);
        System.out.println(output);
    }

    static void helperFindPaths(int row, int col, List<Integer> current, List<List<Integer>> output,int[][] matrix ){

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == -1) return;

        if(row == matrix.length-1 && col == matrix[0].length-1) {
            output.add(new ArrayList<>(current));
            return;
        }

        current.add(matrix[row][col]);

        int temp = matrix[row][col];
        matrix[row][col] = -1;

        helperFindPaths(row+1, col, current,output,matrix);
        helperFindPaths(row, col+1, current,output,matrix);
        helperFindPaths(row-1, col, current,output,matrix);
        helperFindPaths(row, col-1, current,output,matrix);

        current.remove(current.size()-1);
        matrix[row][col] = temp;
    }

}



