package codesignal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LastLeftBus {
    // Schedule: ["12:30", "14:00", "19:55"] time = "14.30"
    static int returnLastBusTime(String[] schedule, String currTime) {

        if(schedule.length == 0 || currTime.equals(schedule[0]))
            return -1;

        List<Map.Entry> scheduleList = new ArrayList<>();

        String[] currTimeSplit = currTime.split(":");
        int currTimeSplitHour = Integer.valueOf(currTimeSplit[0]);
        int currTimeSplitMinute = Integer.valueOf(currTimeSplit[1]);

        for(String time : schedule) {
            String[] splitTime = time.split(":");
            int hour = Integer.valueOf(splitTime[0]);
            int minute = Integer.valueOf(splitTime[1]);

            if(currTimeSplitHour > hour || currTimeSplitHour == hour && currTimeSplitMinute > minute) {
                scheduleList.add(new AbstractMap.SimpleEntry<>(hour, minute));
            } else {
                Map.Entry<Integer,Integer> lastLessTime = scheduleList.get(scheduleList.size()-1);
                int totalTime = (currTimeSplitHour - lastLessTime.getKey())*60;
                totalTime += currTimeSplitMinute - lastLessTime.getValue();
                return totalTime;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] schedule = new String[]{"12:30","14:00","19:55"};
        String currTime = "14:30";
        System.out.printf("Test1: Last bus left %d minutes ago.%n" , returnLastBusTime(schedule,currTime));

        String[] schedule2 = new String[]{"00:00","14:30","17:55"};
        String currTime2 = "00:00";
        System.out.printf("Test2: Last bus left %d minutes ago.%n" , returnLastBusTime(schedule2,currTime2));

        String[] schedule3 = new String[]{"12:30","14:00","19:55"};
        String currTime3 = "14:00";
        System.out.printf("Test3: Last bus left %d minutes ago.%n" , returnLastBusTime(schedule3,currTime3));
    }
}
