package string.atlassian.leetcode.ratelimiter;

public interface  RateLimiter {

    boolean allowRequest(String clientId);
}
