package string.atlassian.leetcode.ratelimiter;

public class FixedWindowRateLimiter implements RateLimiter {


    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {

    }

    @Override
    public boolean allowRequest(String clientId) {

        return false;
    }
}
