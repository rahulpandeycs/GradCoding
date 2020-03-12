import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DiagonalSort {
  //https://leetcode.com/problems/sort-the-matrix-diagonally/
  static int[][] diagonalSort(int[][] mat) {

    int[][] sortedMatrix = new int[mat.length][mat[0].length];
    Map<Integer, PriorityQueue<Integer>> diagonalDict = new HashMap<>();

    for (int row = 0; row < mat.length; row++) {
      for (int col = 0; col < mat[0].length; col++) {
        if (!diagonalDict.containsKey(row - col))
          diagonalDict.put(row - col, new PriorityQueue<Integer>());
        diagonalDict.get(row - col).add(mat[row][col]);
      }
    }

    for (int row = 0; row < mat.length; row++) {
      for (int col = 0; col < mat[0].length; col++) {
        sortedMatrix[row][col] = diagonalDict.get(row - col).poll();
      }
    }
    return sortedMatrix;
  }

  public static void main(String[] args) {
    int[][] input = new int[][]{
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
    };
    int[][] output = diagonalSort(input);
    for (int r = 0; r < input.length; r++) {
      for (int c = 0; c < input[0].length; c++) {
        System.out.print(output[r][c]);
      }
      System.out.println();
    }
  }
}