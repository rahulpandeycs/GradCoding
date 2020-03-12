import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoHW6 {

  static int[][] findMinimumPath(double[][] terrainMatrix){

    List<int[]> path = new ArrayList<>();
    double[][] dp = new double[terrainMatrix.length][terrainMatrix[0].length];
    double minCost = Double.MAX_VALUE;

    for(int i = 0; i < terrainMatrix[0].length; i++) {

        List<int[]> currentPath = new ArrayList<>();
        double currentCost = helperBFS(terrainMatrix, currentPath, i);
        System.out.println("cost start at:::" + terrainMatrix[0][i] + " ::->" + currentCost);
        if(currentCost < minCost) {
          minCost = currentCost;
          path = currentPath;
        }
    }

    System.out.println(minCost);
    return path.toArray(new int[path.size()][2]);
  }

  static double helperBFS(double[][] terrainMatrix, List<int[]> path, int start){

    double[] dp = new double[terrainMatrix.length];
    int col = start;

    dp[0] = 0;
    path.add(new int[]{0, start});

    for(int i = 0; i + 1 < terrainMatrix.length && col < terrainMatrix[0].length; i++) {
      if(col > 0 && col+1 < terrainMatrix[0].length && terrainMatrix[i+1][col-1] > terrainMatrix[i+1][col+1]) {
        if(Math.pow(2,0.5) * (terrainMatrix[i][col] + terrainMatrix[i+1][col+1]) > (terrainMatrix[i+1][col] + terrainMatrix[i][col])) {
          dp[i+1] = dp[i] + (terrainMatrix[i+1][col] + terrainMatrix[i][col])/2;
          path.add(new int[]{i+1, col});
        } else if(col + 1 < terrainMatrix[0].length) {
          dp[i+1] = dp[i] + Math.pow(2,0.5)*(terrainMatrix[i][col] + terrainMatrix[i+1][col+1])/2;
          path.add(new int[]{i+1, col+1});
          col = col+1;
        }
      } else if(col > 0 && Math.pow(2,0.5)*(terrainMatrix[i][col] + terrainMatrix[i+1][col-1]) < (terrainMatrix[i+1][col] + terrainMatrix[i][col])) {
          dp[i+1] = dp[i] + Math.pow(2,0.5)*(terrainMatrix[i][col] + terrainMatrix[i+1][col-1])/2;
          path.add(new int[]{i+1, col-1});
          col = col-1;
      } else {
          dp[i+1] = dp[i] + (terrainMatrix[i+1][col] + terrainMatrix[i][col])/2;
          path.add(new int[]{i+1, col});
      }
     }
    return dp[dp.length-1];
  }

  public static void main(String[] args){

    double[][] board1 = new double[][]{{1.0, 1.0, 1.0, 1.0},
                                    {1.0, 1.0, 1.0, 1.0},
                                    {1.0, 1.0, 1.0, 1.0},
                                    {1.0, 1.0, 1.0, 1.0}};
    System.out.println("----Board 1----");
    int[][] output1 = findMinimumPath(board1);
    System.out.println(Arrays.deepToString(output1));

    System.out.println("----Board 1 Ends----");

    System.out.println("\n----Board 2----");
    double[][] board2 = new double[][]{{2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board2)));
    System.out.println("----Board 2 ends----");


    System.out.println("\n----Board 3----");
    double[][] board3 = new double[][]{{1.0, 2.0 ,2.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 2.0, 1.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board3)));
    System.out.println("----Board 3 ends----");


    System.out.println("\n----Board 4----");
    double[][] board4 = new double[][]{{2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board4)));
    System.out.println("----Board 4----");

    System.out.println("\n----Board 5----");
    double[][] board5 = new double[][]{{2.0, 1.0, 1.3, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0 ,1.0 ,2.0 ,2.0},
            {2.0 ,2.0 ,1.0 ,2.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board5)));
    System.out.println("----Board 5 ends----");

    System.out.println("\n----Board 6----");
    double[][] board6 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 2.0 ,1.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board6)));
    System.out.println("----Board 6 ends----");

    System.out.println("\n----Board 7----");
    double[][] board7 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            { 2.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            { 1.0, 2.0, 2.0, 2.0, 2.0, 2.0, 9.0, 9.0}};

    System.out.println(Arrays.deepToString(findMinimumPath(board7)));
    System.out.println("----Board 7----");
  }
}
