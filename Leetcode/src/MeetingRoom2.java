package src;

import java.util.Arrays;

public class MeetingRoom2 {

  //https://leetcode.com/problems/meeting-rooms-ii/

  public static int minMeetingRooms(int[][] intervals) {

    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);
    int rooms = 0, endIndex = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (start[i] < end[endIndex]) {
        rooms++;
      } else
        endIndex++;
    }

    return rooms;
  }


  public static int minMeetingRoomsTrial(int[][] intervals) {
    if(intervals == null || intervals.length == 0) return 0;

    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    for(int i=0; i < intervals.length; i++){
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int endPointer = 0, rooms=0;

    for(int i=0; i < intervals.length; i++){
      if(start[i] < end[endPointer]) rooms++;
      else{
        endPointer++;
      }
    }
    return rooms;
  }
  public static void main(String[] args) {
    int[][] slots = new int[][]{{0, 30}, {5, 10}, {15, 20}};
    System.out.println(minMeetingRoomsTrial(slots));
  }
}
