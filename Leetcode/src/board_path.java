import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class TerrainUnit implements Cloneable {
  double cost;
  String path;
  TerrainUnit() {
    this.path = "";
    this.cost = 0.0;
  }

  @Override
  protected TerrainUnitPlus clone() throws CloneNotSupportedException {
    TerrainUnitPlus cloned = new TerrainUnitPlus();
    cloned.cost = cost;
    cloned.path = path;
    return cloned;
  }
}

public class board_path {
  // With recursion and not computing repetitive problems
  static String findMinPathRecursionWithDP(double[][] terrainMatrix) throws CloneNotSupportedException {
    String path = "";

    TerrainUnitPlus[][] costDP = new TerrainUnitPlus[terrainMatrix.length][terrainMatrix[0].length];

    for(TerrainUnitPlus[] arr : costDP)
        Arrays.fill(arr, new TerrainUnitPlus());

    double minCostValue = Double.MAX_VALUE;

    for (int col = 0; col < terrainMatrix[0].length; col++) {

      costDP[0][col].path = "";
      costDP[0][col].cost = 0.0;

      TerrainUnitPlus currentCost = helperRecursionWithDP(terrainMatrix, costDP, col, 0);
      if (currentCost.cost < minCostValue) {
        minCostValue = currentCost.cost;
        path = costDP[0][col].path;
      }
    }
    return minCostValue + "\n" + path;
  }

  private static TerrainUnitPlus helperRecursionWithDP(double[][] terrainMatrix, TerrainUnitPlus[][] costDP, int col, int row) throws CloneNotSupportedException {

    if (row == terrainMatrix.length - 1 && col >= 0 && col < terrainMatrix[0].length){
       costDP[row][col].path = row + " " + col + "\n";
       return costDP[row][col];
    }

    if (row < 0 || col < 0 || row > terrainMatrix.length - 1 || col > terrainMatrix[0].length - 1)
      return new TerrainUnitPlus();

    if (costDP[row][col] != null && costDP[row][col].cost != 0.0)
      return costDP[row][col];

    TerrainUnitPlus min = new TerrainUnitPlus();
    double minCost = Double.MAX_VALUE;

    TerrainUnitPlus leftDiagonal;
    TerrainUnitPlus rightDiagonal;
    TerrainUnitPlus down;

    if( (row+1) < terrainMatrix.length ) {
      down = helperRecursionWithDP(terrainMatrix, costDP, col, row + 1).clone();
      down.cost += (terrainMatrix[row][col] + terrainMatrix[row + 1][col]) / 2;

      if(down.cost != 0.0 && down.cost < minCost){
        minCost = down.cost;
        min.cost = down.cost;
        min.path = costDP[row + 1][col].path + row + " " + col + "\n";
      }


    if( (col-1) > -1 ) {
      leftDiagonal = helperRecursionWithDP(terrainMatrix, costDP, col - 1, row + 1).clone();
      leftDiagonal.cost += Math.pow(2, 0.5) * (terrainMatrix[row][col] + terrainMatrix[row + 1][col - 1]) / 2;

      if(leftDiagonal.cost!=0.0 && leftDiagonal.cost < minCost){
        minCost = leftDiagonal.cost;
        min.cost = leftDiagonal.cost ;
        min.path = costDP[row + 1][col - 1].path + row + " " + col + "\n";
      }
    }

    if( (col+1) < terrainMatrix[0].length ) {
      rightDiagonal = helperRecursionWithDP(terrainMatrix, costDP, col + 1, row + 1).clone();
      rightDiagonal.cost += Math.pow(2, 0.5) * (terrainMatrix[row][col] + terrainMatrix[row + 1][col + 1]) / 2;

      if(rightDiagonal.cost!=0.0 && rightDiagonal.cost < minCost){
        min.cost = rightDiagonal.cost;
        min.path = costDP[row + 1][col + 1].path + row + " " + col + "\n";
      }
     }
    }

    costDP[row][col] = min;
    return costDP[row][col];
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    ClassLoader classLoader = board_path_plus.class.getClassLoader();
    File boardFile = new File(classLoader.getResource("boards/board1.dat").getFile());
    double[][] inputBoard1 = null;

    try{
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
   //   System.out.println(findMinPathRecursionWithDP(inputBoard1));
    } catch (IOException e) {
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
