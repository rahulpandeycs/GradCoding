package src;

import java.util.Arrays;

public class SubrectangleQueries {

    int[][] rectangle;
    public SubrectangleQueries(int[][] rect) {
        rectangle = rect.clone();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int row = row1; row <= row2; row++){
            for(int col = col1; col <= col2; col++){
                rectangle[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle = new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries obj = new SubrectangleQueries(rectangle);
        obj.updateSubrectangle(0,0,3,2,5);
        System.out.println(Arrays.toString(rectangle));
    }
}
