package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class UnitTerrain implements Cloneable{
  double cost;
  String path;

  UnitTerrain() {
    this.path = "";
    this.cost = 0.0;
  }

  @Override
  protected UnitTerrain clone() throws CloneNotSupportedException {
    UnitTerrain cloned = new UnitTerrain();
    cloned.cost = cost;
    cloned.path = path;
    return cloned;
  }
}

public class board_path_plus_1 {

  static UnitTerrain unitTerrain = new UnitTerrain();
  // With recursion and not computing repetitive problems
  static String findMinPathRecursionWithDP(double[][] terrainMatrix) throws CloneNotSupportedException {
    String path = "";

    UnitTerrain[][] costDP = new UnitTerrain[terrainMatrix.length][terrainMatrix[0].length];

    for(UnitTerrain[] arr :costDP)
        Arrays.fill(arr,new UnitTerrain());

    double minCost = Double.MAX_VALUE;

    for (int i = 0; i < terrainMatrix[0].length; i++) {
      costDP[0][i].path = "";
      costDP[0][i].cost = 0.0;
      UnitTerrain currentCost = helperRecursionWithDP(terrainMatrix, costDP, i, 0,i);
      if (currentCost.cost < minCost) {
        minCost = currentCost.cost;
        path = costDP[0][i].path;
      }
    }
    return minCost + "\n" + path;
  }

  private static UnitTerrain helperRecursionWithDP(double[][] terrainMatrix, UnitTerrain[][] costDP, int col, int row, int prevCol) throws CloneNotSupportedException {

    if (row == terrainMatrix.length - 1 && col >= 0 && col < terrainMatrix[0].length) {
      costDP[row][col].path = row + " " + col + "\n";
      return costDP[row][col];
    }

    if (row < 0 || col < 0 || row > terrainMatrix.length - 1 || col > terrainMatrix[0].length - 1)
      return new UnitTerrain();

    if (costDP[row][col] != null && costDP[row][col].cost != 0.0)
      return costDP[row][col];

    UnitTerrain left = new UnitTerrain(), right = new UnitTerrain();

    UnitTerrain leftDiagonal = helperRecursionWithDP(terrainMatrix, costDP, col - 1, row + 1,col).clone();
//    if(row+1 < terrainMatrix.length && col-1 >= 0)
//                leftDiagonal.cost += Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col-1])/2;

    UnitTerrain rightDiagonal = helperRecursionWithDP(terrainMatrix, costDP, col + 1, row + 1,col).clone();
//    if(row+1 < terrainMatrix.length && col+1 < terrainMatrix[0].length)
//                rightDiagonal.cost += Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col+1])/2;

    UnitTerrain down = helperRecursionWithDP(terrainMatrix, costDP, col, row + 1,col).clone();
//    if(row+1 < terrainMatrix.length)
//                down.cost += (terrainMatrix[row][col] + terrainMatrix[row + 1][col])/2;

    if(col - 1 != prevCol){
      left = helperRecursionWithDP(terrainMatrix, costDP,col - 1, row,col).clone();
//      if(col-1 >=0)
//         left.cost += (terrainMatrix[row][col] + terrainMatrix[row][col-1])/2;
    }
    if(col + 1 != prevCol) {
      right = helperRecursionWithDP(terrainMatrix, costDP,col + 1, row,col).clone();
//      if(col+1 < terrainMatrix[0].length)
//         right.cost += (terrainMatrix[row][col] + terrainMatrix[row][col+1])/2;
    }

    UnitTerrain min = unitTerrain;
    double minCost = Integer.MAX_VALUE;

    if(row + 1 < terrainMatrix.length-1 && down.cost < minCost) {
       minCost = down.cost + (terrainMatrix[row][col] + terrainMatrix[row + 1][col])/2.0;
       min.cost = down.cost + (terrainMatrix[row][col] + terrainMatrix[row + 1][col])/2.0;
       min.path = costDP[row + 1][col].path + row + " " + col + "\n";
    }

    if(col + 1 < terrainMatrix[0].length && (right.cost + (terrainMatrix[row][col] + terrainMatrix[row][col+1])/2.0) < minCost) {
       minCost = right.cost + (terrainMatrix[row][col] + terrainMatrix[row][col+1])/2.0;
       min.cost = right.cost + (terrainMatrix[row][col] + terrainMatrix[row][col+1])/2.0;
       min.path = costDP[row][col+1].path + row + " " + col + "\n";
    }

    if(col - 1 >= 0 && (left.cost + (terrainMatrix[row][col] + terrainMatrix[row][col-1])/2.0) < minCost) {
       minCost = left.cost + (terrainMatrix[row][col] + terrainMatrix[row][col-1])/2.0;
       min.cost = left.cost + (terrainMatrix[row][col] + terrainMatrix[row][col-1])/2.0;
       min.path = costDP[row][col-1].path + row + " " + col + "\n";
    }

    if(row + 1 < terrainMatrix.length && col-1 >= 0 && (leftDiagonal.cost + Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col-1])/2.0) < minCost) {
       minCost = leftDiagonal.cost + Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col-1])/2.0;
       min.cost = leftDiagonal.cost + Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col-1])/2.0;
       min.path = costDP[row + 1][col - 1].path + row + " " + col + "\n";
    }

    if(row + 1 < terrainMatrix.length && col + 1 < terrainMatrix[0].length && (rightDiagonal.cost + Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col+1])/2.0) < minCost) {
       min.cost = rightDiagonal.cost + Math.pow(2,0.5)*(terrainMatrix[row][col] + terrainMatrix[row+1][col+1])/2.0;
       min.path = costDP[row + 1][col + 1].path + row + " " + col + "\n";
    }

    costDP[row][col].cost = min.cost;
    costDP[row][col].path = min.path;
    return costDP[row][col];
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    ClassLoader classLoader = board_path_plus_1.class.getClassLoader();
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
      System.out.println(findMinPathRecursionWithDP(inputBoard1));
    } catch (IOException | CloneNotSupportedException e) {
      e.printStackTrace();
    }

    double[][] board1 = new double[][]{{1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0},
            {1.0, 1.0, 1.0, 1.0}};
    System.out.println("----Board 1----");
    System.out.println(findMinPathRecursionWithDP(board1));
    System.out.println("----Board 1 Ends----");


    double[][] board2 = new double[][]{{2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

    System.out.println("\n----Board 2----");
    System.out.println(findMinPathRecursionWithDP(board2));
    System.out.println("----Board 2 ends----");



    double[][] board3 = new double[][]{{1.0, 2.0, 2.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 2.0, 2.0, 1.0}};

    System.out.println("\n----Board 3----");
    System.out.println(findMinPathRecursionWithDP(board3));
    System.out.println("----Board 3 ends----");

    double[][] board4 = new double[][]{{2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

    System.out.println("\n----Board 4----");
    System.out.println(findMinPathRecursionWithDP(board4));
    System.out.println("----Board 4 ends----");

    double[][] board5 = new double[][]{{2.0, 1.0, 1.3, 2.0},
            {2.0, 2.0, 1.0, 2.0},
            {2.0, 1.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0}};

    System.out.println("\n----Board 5----");
    System.out.println(findMinPathRecursionWithDP(board5));
    System.out.println("----Board 5 ends----");

    double[][] board6 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 2.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0}};

    System.out.println("\n----Board 6----");
    System.out.println(findMinPathRecursionWithDP(board6));
    System.out.println("----Board 6 ends----");

    double[][] board7 = new double[][]{{2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 2.0, 2.0, 1.0, 2.0, 2.0, 2.0, 1.0},
            {2.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 1.0},
            {1.0, 2.0, 2.0, 2.0, 2.0, 2.0, 9.0, 9.0}};

    System.out.println("\n----Board 7----");
    System.out.println(findMinPathRecursionWithDP(board7));
    System.out.println("----Board 7 ends----");
  }
}
