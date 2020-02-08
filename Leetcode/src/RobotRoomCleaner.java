import java.util.HashSet;
import java.util.Set;

//Complexity Analysis
//
//    Time complexity : O(4^(N - M)),
//    where N is a number of cells in the room and M is a number of obstacles,
//    because for each cell the algorithm checks 4 directions.
//
//    Space complexity : O(N−M),
//    where N is a number of cells in the room and
//    M is a number of obstacles, to track visited cells.


//https://leetcode.com/problems/robot-room-cleaner/
//https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution
interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}


public class RobotRoomCleaner {
  int dirs[][] = new int[][]{{1,0}, {1,0}, {-1,0}, {0,-1}};
  public void cleanRoom(Robot robot) {
    Set<String> visited = new HashSet<>();
    helperCleanGrid(robot, 0, 0, 0, visited);
  }

  void helperCleanGrid(Robot robot, int x, int y, int currDirection, Set<String> visited){
    String path = x + "->" + y;
    if(visited.contains(path)) return;
    visited.add(path);
    robot.clean();

    for(int i = 0 ; i < 4; i++){
    if(robot.move()){

      int nextX = x + dirs[currDirection][0];
      int nextY = y + dirs[currDirection][1];

      helperCleanGrid(robot, nextX,nextY, currDirection,visited);

      robot.turnLeft();
      robot.turnLeft();
      robot.move();
      robot.turnLeft();
      robot.turnLeft();
    }
    robot.turnRight();
    currDirection = (currDirection + 1)%4;
   }
  }
}
