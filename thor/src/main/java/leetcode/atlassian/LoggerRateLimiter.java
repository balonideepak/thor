package leetcode.atlassian;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    static Map<String, Integer> map;
    static final Object lock=new Object();

    public static void main(String[] args) {
        map = new HashMap<>();
        shouldPrintMessage(1,"foo");
        shouldPrintMessage(2,"bar");
        shouldPrintMessage(3,"foo");
        shouldPrintMessage(10,"foo");
        shouldPrintMessage(11,"foo");


    }

    public static boolean shouldPrintMessage(int timestamp, String message) {
        Integer timestampRecorded = map.get(message);
        if (null == timestampRecorded || timestamp >= timestampRecorded + 10) {
            synchronized (lock) {
                Integer timestampRecorded2 = map.get(message);
                if (null == timestampRecorded2 || timestamp >= timestampRecorded2 + 10) {
                    map.put(message, timestamp);
                    return true;
                }
            }
        }
        return false;
    }
}
