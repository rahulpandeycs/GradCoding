package src.premium;

import java.util.HashSet;
import java.util.*;

public class NumberOfDistinctIslands {
//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
//
//Return the number of distinct islands.
// https://leetcode.com/problems/number-of-distinct-islands/

    public int numDistinctIslands(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;
        Set<String> seen = new HashSet<>();

        for(int i=0; i <grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();
                    helperDFS(grid,i,j,'O',sb);
                    if(!seen.contains(sb.toString())){
                        seen.add(sb.toString());
                    }
                }
            }
        }
        return seen.size();
    }

    void helperDFS(int[][] grid, int i, int j, char dir, StringBuilder sb){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;
        sb.append(dir);
        helperDFS(grid,i-1,j,'u',sb);
        helperDFS(grid,i+1,j,'d',sb);
        helperDFS(grid,i,j-1,'l',sb);
        helperDFS(grid,i,j+1,'r',sb);
        sb.append('b');
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(new NumberOfDistinctIslands().numDistinctIslands(grid));
    }
}
