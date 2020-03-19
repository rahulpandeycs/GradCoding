import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class board_path_Extra {

  static int[][] findMinimumPathBFS(double[][] terrainMatrix) {

    List<int[]> path = new ArrayList<>();
    double[][] dp = new double[terrainMatrix.length][terrainMatrix[0].length];
    double minCost = Double.MAX_VALUE;

    for (int i = 0; i < terrainMatrix[0].length; i++) {

      List<int[]> currentPath = new ArrayList<>();
      double currentCost = helperBFS(terrainMatrix, currentPath, i);
      System.out.println("cost start at:::" + terrainMatrix[0][i] + " ::->" + currentCost);
      if (currentCost < minCost) {
        minCost = currentCost;
        path = currentPath;
      }
    }

    System.out.println(minCost);
    return path.toArray(new int[path.size()][2]);
  }

  static double helperBFS(double[][] terrainMatrix, List<int[]> path, int start) {

    double[] dp = new double[terrainMatrix.length];
    int col = start;

    dp[0] = 0;
    path.add(new int[]{0, start});

    for (int i = 0; i + 1 < terrainMatrix.length && col < terrainMatrix[0].length; i++) {
      if (col > 0 && col + 1 < terrainMatrix[0].length && terrainMatrix[i + 1][col - 1] > terrainMatrix[i + 1][col + 1]) {
        if (Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col + 1]) > (terrainMatrix[i + 1][col] + terrainMatrix[i][col])) {
          dp[i + 1] = dp[i] + (terrainMatrix[i + 1][col] + terrainMatrix[i][col]) / 2;
          path.add(new int[]{i + 1, col});
        } else if (col + 1 < terrainMatrix[0].length) {
          dp[i + 1] = dp[i] + Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col + 1]) / 2;
          path.add(new int[]{i + 1, col + 1});
          col = col + 1;
        }
      } else if (col > 0 && Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col - 1]) < (terrainMatrix[i + 1][col] + terrainMatrix[i][col])) {
        dp[i + 1] = dp[i] + Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col - 1]) / 2;
        path.add(new int[]{i + 1, col - 1});
        col = col - 1;
      } else if (col + 1 < terrainMatrix[0].length && (terrainMatrix[i + 1][col] + terrainMatrix[i][col]) > Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col + 1])) {
        dp[i + 1] = dp[i] + Math.pow(2, 0.5) * (terrainMatrix[i][col] + terrainMatrix[i + 1][col + 1]) / 2;
        path.add(new int[]{i + 1, col + 1});
        col = col + 1;
      } else {
        dp[i + 1] = dp[i] + (terrainMatrix[i + 1][col] + terrainMatrix[i][col]) / 2;
        path.add(new int[]{i + 1, col});
      }
    }
    return dp[dp.length - 1];
  }


  // With recursion and not computing repetitive problems
  static String findMinPathRecursionWithDP(double[][] terrainMatrix) {
    String path = "";
    double[][] costDP = new double[terrainMatrix.length][terrainMatrix[0].length];
    String[][] pathDP = new String[terrainMatrix.length][terrainMatrix[0].length];

    for (String[] arr : pathDP)
       Arrays.fill(arr, "");

    double minCost = Double.MAX_VALUE;

    for (int i = 0; i < terrainMatrix[0].length; i++) {
      double currentCost = helperRecursionWithDP(terrainMatrix, costDP, pathDP, i, 0);
      if (currentCost < minCost) {
        minCost = currentCost;
        path = pathDP[0][i];
      }
    }
    return minCost + "\n" + path;
  }

  private static double helperRecursionWithDP(double[][] terrainMatrix, double[][] costDP, String[][] pathDP, int col, int row) {

    if (row == terrainMatrix.length - 1 && col >= 0 && col < terrainMatrix[0].length)
      pathDP[row][col] = row + " " + col + "\n";

    if (row < 0 || col < 0 || row + 1 > terrainMatrix.length - 1 || col > terrainMatrix[0].length - 1)
      return 0;

    if (costDP[row][col] != 0.0)
      return costDP[row][col];

    double leftDiagonal = helperRecursionWithDP(terrainMatrix, costDP, pathDP, col - 1, row + 1);
    double rightDiagonal = helperRecursionWithDP(terrainMatrix, costDP, pathDP, col + 1, row + 1);
    double up = helperRecursionWithDP(terrainMatrix, costDP, pathDP, col, row + 1);

    if (leftDiagonal != 0 && rightDiagonal != 0 && leftDiagonal < rightDiagonal) {
      if (col - 1 > 0 && leftDiagonal + Math.pow(2, 0.5) * (terrainMatrix[row][col] + terrainMatrix[row + 1][col - 1])
              < (leftDiagonal + terrainMatrix[row][col] + terrainMatrix[row + 1][col])) {

        costDP[row][col] = leftDiagonal + Math.pow(2, 0.5) * ((terrainMatrix[row][col] + terrainMatrix[row + 1][col - 1]) / 2);
        pathDP[row][col] += pathDP[row + 1][col - 1] + row + " " + col + "\n";

      } else {

        costDP[row][col] = up + (terrainMatrix[row][col] + terrainMatrix[row + 1][col]) / 2;
        pathDP[row][col] += pathDP[row + 1][col] + row + " " + col + "\n";

      }
    } else if (col + 1 < terrainMatrix[0].length && rightDiagonal + Math.pow(2, 0.5) * (terrainMatrix[row][col] + terrainMatrix[row + 1][col + 1])
            < (rightDiagonal + terrainMatrix[row][col] + terrainMatrix[row + 1][col])) {

      costDP[row][col] = rightDiagonal + Math.pow(2, 0.5) * ((terrainMatrix[row][col] + terrainMatrix[row + 1][col + 1]) / 2);
      pathDP[row][col] += pathDP[row + 1][col + 1] + row + " " + col + "\n";

    } else {

      costDP[row][col] = up + (terrainMatrix[row][col] + terrainMatrix[row + 1][col]) / 2;
      pathDP[row][col] += pathDP[row + 1][col] + row + " " + col + "\n";

    }
    return costDP[row][col];
  }


  public static void main(String[] args) {
    ClassLoader classLoader = board_path_Extra.class.getClassLoader();
    File boardFile = new File(classLoader.getResource("boards/board1.dat").getFile());
    double[][] inputBoard1 = null;

    try {
      BufferedReader in = new BufferedReader(new FileReader(boardFile));
      String line;
      int x = 0, y = 0;

      int dimension = Integer.parseInt(in.readLine());
      inputBoard1 = new double[dimension][dimension];

      while ((line = in.readLine()) != null) {

        String[] row = line.split(" ");
        y=0;
        for (String element : row) {
          double value = Double.parseDouble(element);
          inputBoard1[x][y] = value;
          y++;
        }
        x++;
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    double[][] board1 = new double[][]{{1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0}};
    System.out.println("----Board 1----");
//    System.out.println(Arrays.deepToString(findMinimumPath(board1)));

    System.out.println(findMinPathRecursionWithDP(inputBoard1));

    System.out.println("----Board 1 Ends----");

    System.out.println("\n----Board 2----");
    double[][] board2 = new double[][]{{2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board2)));

    System.out.println(findMinPathRecursionWithDP(board2));
    System.out.println("----Board 2 ends----");


    System.out.println("\n----Board 3----");
    double[][] board3 = new double[][]{{1.0, 2.0, 2.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 2.0, 1.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board3)));

    System.out.println(findMinPathRecursionWithDP(board3));
    System.out.println("----Board 3 ends----");


    System.out.println("\n----Board 4----");
    double[][] board4 = new double[][]{{2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board4)));

    System.out.println(findMinPathRecursionWithDP(board4));
    System.out.println("----Board 4 ends----");

    System.out.println("\n----Board 5----");
    double[][] board5 = new double[][]{{2.0, 1.0, 1.3, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board5)));

    System.out.println(findMinPathRecursionWithDP(board5));
    System.out.println("----Board 5 ends----");

    System.out.println("\n----Board 6----");
    double[][] board6 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board6)));

    System.out.println(findMinPathRecursionWithDP(board6));
    System.out.println("----Board 6 ends----");

    System.out.println("\n----Board 7----");
    double[][] board7 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            {1.0, 2.0, 2.0, 2.0, 2.0, 2.0, 9.0, 9.0}};

//    System.out.println(Arrays.deepToString(findMinimumPath(board7)));
    System.out.println(findMinPathRecursionWithDP(board7));
    System.out.println("----Board 7 ends----");
  }
}
