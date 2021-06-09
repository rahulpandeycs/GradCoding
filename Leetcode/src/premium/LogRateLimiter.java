package src.premium;

import java.util.*;

public class LogRateLimiter {

    private Map<String, Integer> ok;

    /** Initialize your data structure here. */
    public LogRateLimiter() {
        ok = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
    }
}
