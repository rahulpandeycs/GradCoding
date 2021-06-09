package src.premium;

import java.util.Arrays;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0, startIndex = 0, endIndex=0, maxRoom = 0;
        while(startIndex < start.length && endIndex < end.length){
            if(start[startIndex] < end[endIndex]){
                room++;
            }else{
                endIndex++;
            }
            startIndex++;
        }
        return room;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
    }
}
