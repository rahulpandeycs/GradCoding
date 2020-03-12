import java.util.Arrays;
//https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {
  public static boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0])
        return false;
    }
    return true;
  }

   public static void main(String[] args){
    int[][] slots = new int[][]{{0,30}, {5,10},{15,20}};
    System.out.println(canAttendMeetings(slots));
   }
}
