package codesignal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DiagonalSort {

    static int[][] diagonalSort(int[][] arr){

        Map<Integer, PriorityQueue<Integer>> pq = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            for(int j =0; j < arr[0].length; j++) {
                if(!pq.containsKey(i-j)) pq.put(i-j, new PriorityQueue<>());
                pq.get(i-j).add(arr[i][j]);
            }
        }

        int[][] output = new int[arr.length][arr[0].length];
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr[0].length; j++){
                output[i][j] = pq.get(i-j).poll();
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5,1,9},{1,2,3},{9,6,1}};
        System.out.println("Input");
        for(int i=0; i < input.length; i++){
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println("Output");
        input = diagonalSort(input);
        for(int i=0; i < input.length; i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }
}
