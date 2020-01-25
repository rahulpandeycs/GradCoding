import java.util.Arrays;

public class MergeIntervals {

  static int merge_intervals(int[][] inputArray){

    int rooms =0;

    int[] start = new int[inputArray.length];
    int[] end = new int[inputArray.length];

    for(int k=0; k < inputArray.length; k++){
      start[k] = inputArray[k][0];
      end[k] = inputArray[k][1];
    }
    int endPosition = 0;
    Arrays.sort(start);
    Arrays.sort(end);
    for(int j = 0; j < inputArray.length; j++) {
        if(start[j] < end[endPosition]){
           rooms++;
        } else {
           endPosition++;
        }
    }
    return rooms;
  }

  public static void main(String[] args){
// https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
//    int[][] input = {{0,30},{5,10},{15,20}};
    int[][] input = {{7,10},{2,4}};
    System.out.println(merge_intervals(input));
  }
}
