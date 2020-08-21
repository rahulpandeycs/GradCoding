package src;

import java.util.HashMap;
import java.util.Map;

public class ThrottlingGateway {
    public static final int MAX_PER_SECOND = 3;
    public static final int MAX_TEN_SECONDS = 20;
    public static final int MAX_PER_MINUTE = 60;
    public static void main(String[] args) {
        int[] requestTime11 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4,5,5,5, 6, 6, 6, 7, 7};
        int[] requestTime1 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 11, 11, 11, 6, 6, 6, 5, 5, 5};
        int[] requestTime2 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        int[] requestTime3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9,
                10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 14, 16, 16, 16, 16, 16,
                16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20};

        int[] requestTime4 = new int[]{1,
                1,
                1,
                1,
                1,
                1,
                1,
                2,
                2,
                2,
                2,
                2,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                4,
                4,
                4,
                4,
                5,
                5,
                5,
                5,
                5,
                5,
                5,
                5,
                6,
                6,
                6,
                6,
                6,
                6,
                7,
                7,
                7,
                8,
                8,
                8,
                8,
                8,
                8,
                8,
                9,
                9,
                9,
                9,
                9,
                10,
                10,
                10,
                10,
                10,
                10,
                11,
                11,
                11,
                11,
                11,
                11,
                11,
                11,
                11,
                12,
                12,
                12,
                12,
                12,
                12,
                12,
                12,
                12,
                12,
                13,
                13,
                13,
                13,
                13,
                13,
                13,
                13,
                14,
                14,
                14,
                14,
                14,
                14,
                15,
                15,
                15,
                15,
                15,
                15,
                15,
                15,
                15,
                15,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                17,
                17,
                17,
                17,
                17,
                17,
                18,
                18,
                18,
                18,
                18,
                18,
                19,
                19,
                19,
                19,
                19,
                19,
                20,
                20,
                20,
                20,
                20,
                20,
                20};
        ThrottlingGateway test = new ThrottlingGateway();
        System.out.println(test.droppedRequests(requestTime4));
    }

    public int droppedRequests(int[] requestTime) {
        if (requestTime == null || requestTime.length == 0) {
            return 0;
        }
        int drop = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lastReqTime = 0;
        for (int i : requestTime) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            lastReqTime = Math.max(lastReqTime, i);
        }
        int[] nums = new int[lastReqTime + 1];
        for (int i = 1; i < nums.length; ++i) {
            int numReqThisSecond = map.getOrDefault(i, 0);
            nums[i] = nums[i - 1] + numReqThisSecond;
            if (numReqThisSecond == 0) {
                continue;
            }
            int toDrop = 0;
            if (numReqThisSecond > MAX_PER_SECOND) {
                toDrop = Math.max(toDrop, numReqThisSecond - MAX_PER_SECOND);
            }

            int timeTenSecondsAgo = Math.max(i - 10, 0);
            int numReqPastTenSecond = nums[i] - nums[timeTenSecondsAgo];
            if (numReqPastTenSecond > MAX_TEN_SECONDS) {
                int numReqExceeded = Math.min(numReqThisSecond, numReqPastTenSecond - MAX_TEN_SECONDS);
                toDrop = Math.max(toDrop, numReqExceeded);
            }

            int timeOneMinuteAgo = Math.max(i - 60, 0);
            int numReqPastMinute = nums[i] - nums[timeOneMinuteAgo];
            if (numReqPastMinute > MAX_PER_MINUTE) {
                int numReqExceeded = Math.min(numReqThisSecond, numReqPastMinute - MAX_PER_MINUTE);
                toDrop = Math.max(toDrop, numReqExceeded);
            }
            drop += toDrop;
        }
        return drop;
    }
}