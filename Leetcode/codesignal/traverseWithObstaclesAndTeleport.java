package codesignal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class traverseWithObstaclesAndTeleport {
//https://www.coursehero.com/tutors-problems/Python-Programming/26718503-Please-read-from-top-to-bottom-starting-from-the-first-column-and-dow/
    public static void main(String[] args) {
//        int[][] obstacles = new int[][]{{2,0}, {1,0}};
//        int[][] teleports  = new int[][]{{0,1,1,1}, {1,2,0,2}, {0,3,2,1}};
//        int n=3, m= 4;

        int[][] obstacles = new int[][]{{2,1}, {1,0}};
        int[][] teleports  = new int[][]{{0,1,2,0}};
        int n=3, m= 3;

        System.out.println(isLabyrinthPossible(n, m , obstacles, teleports));
    }

    private static boolean isLabyrinthPossible(int n, int m, int[][] obstacles, int[][] teleports) {

        Set<String> obstacleSet = new HashSet<>();
        for(int[] obstacle : obstacles){
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        Map<String, int[]> teleportMap = new HashMap<>();
        for(int[] teleport : teleports){
            teleportMap.put(teleport[0]+ "," + teleport[1], new int[]{teleport[2],teleport[3]});
        }

        return helperDFS(n, m, 0, 0, teleportMap, obstacleSet);
    }

    static boolean helperDFS(int n, int m, int row, int col, Map<String, int[]> teleportMap, Set<String> obstacleSet) {
        if(row < 0 || row >= n || col < 0 || col >= m || obstacleSet.contains(row+ "," +col)) return false;

        if(row == n-1 && col == m-1) return true;

        boolean isPossible = false;

        obstacleSet.add(row+ "," + col);
        if(teleportMap.containsKey(row+ "," +col)){
            int[] teleportAddress =  teleportMap.get(row + "," +col);
            isPossible = helperDFS(n, m, teleportAddress[0], teleportAddress[1], teleportMap, obstacleSet);
        }else{
            isPossible = helperDFS(n, m, row, col+1, teleportMap, obstacleSet);
        }
        obstacleSet.remove(row+ "," + col);
        return isPossible;
    }
}
