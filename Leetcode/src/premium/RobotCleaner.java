//package src.premium;
//
//public class RobotCleaner {
//
//    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//    public void cleanRoom(Robot robot) {
//        clean(robot, 0, 0, 0, new HashSet<>());
//    }
//
//    private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
//        // Cleans current cell.
//        robot.clean();
//        visited.add(x + " " + y);
//
//        for (int nDirection = curDirection;
//             nDirection < curDirection + 4;
//             nDirection++) {
//            int nx = directions[nDirection % 4][0] + x;
//            int ny = directions[nDirection % 4][1] + y;
//            if (!visited.contains(nx + " " + ny) && robot.move()) {
//                clean(robot, nx, ny, nDirection % 4, visited);
//            }
//            // Changed orientation.
//            robot.turnRight();
//        }
//
//        // Moves backward one step while maintaining the orientation.
//        robot.turnRight();
//        robot.turnRight();
//        robot.move();
//        robot.turnRight();
//        robot.turnRight();
//    }
//}
