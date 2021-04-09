package src.AmzOA;

public class RobotBoundedInCircle {

    // Time: O(n)   https://leetcode.com/problems/robot-bounded-in-circle/
    // Space: O(1)
    public boolean isRobotBounded(String instructions) {

        int[][] dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}};
        int curr = 0, x =0, y =0;;
        for(char ch : instructions.toCharArray()){
            if(ch == 'R'){
                curr = (curr + 1) % 4;
            }else if(ch == 'L'){
                curr = (curr + 3) % 4;
            }else if(ch == 'S'){
                x += dirs[curr][0];
                y += dirs[curr][1];
            }
        }

        return x == 0 && y == 0 || curr > 0;
    }
}
